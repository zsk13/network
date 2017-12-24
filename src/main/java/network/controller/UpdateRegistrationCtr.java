package network.controller;

import com.github.pagehelper.PageInfo;
import network.model.Course;
import network.model.Registration;
import network.model.Rollcall;
import network.model.Teacher;
import network.service.RegistrationPageService;
import network.service.RegistrationService;
import network.service.RollcallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "manage")
public class UpdateRegistrationCtr {
	
	
	
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private RollcallService rollCallService;
    @Autowired
    private RegistrationPageService registrationPageService;
    @RequestMapping(value = "/display_registrations.do")
    public ModelAndView displayRegistrations(Integer registrationId,Integer pageNo,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageInfo<Registration> page = registrationPageService.queryByPage(pageNo,10);
        //List<Registration> list1 = registrationService.getAll();
    	ModelAndView mv = new ModelAndView("display_registrations");
    	System.out.println("size:"+page.getList().size());
    	mv.addObject("registrationList",page.getList());
    	mv.addObject("totalPage",page.getPages());
    	mv.addObject("currentPage",page.getPageNum());
    	mv.addObject("registrationId",registrationId);
    	return mv;
    }
    
    @RequestMapping(value = "/display_registration_records.do")
    public ModelAndView displayRegistrationInDetail(HttpServletRequest request, HttpServletResponse response) {
    	Long rid = Long.parseLong(request.getParameter("registrationId"));
    	System.out.println(rid);
    	List<Rollcall> list = rollCallService.getAll();
    	for(int i = 0;i<list.size();i++) {
    		System.out.println(list.get(i).getuId());
    	}
    	return null;
    }
    
    @RequestMapping(value = "/start_add.do")
    public ModelAndView add(HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView("start_a_registration");
    	HttpSession session = request.getSession();
    	Teacher teacher = (Teacher) session.getAttribute("teacher");
    	
    	List<Course> courseList1 = null;
    	if(teacher !=null && teacher.gettId()!=0) {
    		courseList1 = registrationService.getValidCoursesByTeacherId(teacher.gettId());
    	}else{
    		courseList1 = registrationService.getAllCourses();
    	}
    	mav.addObject("clist",courseList1);
    	
        return mav;
    }
    
    @RequestMapping(value = "/welcome.do")
    public String welcome(Registration registration) {
        return "teacher_login";

    }
    
    @RequestMapping(value = "/add.do")
    public String asdf(HttpServletRequest req) throws ParseException, UnsupportedEncodingException {
    	
    	//req.setCharacterEncoding("utf8");
    	//req.set
    	/**
    	Enumeration<String> em = req.getParameterNames();
        while(em.hasMoreElements()) {
        	String name1 = em.nextElement();
        	String value1 = req.getParameter(name1);
        	byte[] b = value1.getBytes("ISO-8859-1");
        	String value2 = new String(b, "UTF-8");
        	System.out.println(name1+"\t"+value1+"\t"+value2);
        }
		*/
    	if(req != null && req.getParameter("name") !=null &&  req.getParameter("name").length() >0) {
        Registration reg2 = new Registration();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
    	String name = req.getParameter("name");
    	//↓我们明明在能写utf-8的地方都写了utf-8，但是不知道哪个容器的哪个步骤将这些parameter用ISO-859-1进行编码了
    	name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
    	
        String className = req.getParameter("className");
        className = new String(className.getBytes("ISO-8859-1"),"UTF-8");
        
        Long locationId = Long.parseLong(req.getParameter("location_id"));
        Date startTime = sdf.parse(req.getParameter("sTime").replaceAll("T", " "));
        Date endTime = sdf.parse(req.getParameter("eTime").replaceAll("T", " "));

        reg2.setsTime(startTime);
        reg2.seteTime(endTime);
        reg2.setlId(locationId);
        registrationService.add(reg2);
    	}
        return "teacher_login";
    }

}
