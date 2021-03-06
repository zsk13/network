package network.controller;

import com.github.pagehelper.PageInfo;
import network.model.*;
import network.service.LocationService;
import network.service.RegistrationPageService;
import network.service.RegistrationService;
import network.service.RollcallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private LocationService locationService;
    @Autowired
    private RegistrationPageService registrationPageService;


    @RequestMapping(value = "/display_registrations.do")
    public ModelAndView displayRegistrations(Integer registrationId,Integer pageNo,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        PageInfo<Registration> page = registrationPageService.queryByPage(teacher.gettId(),pageNo,10);
        //List<Registration> list1 = registrationService.getAll();
        ModelAndView mv = new ModelAndView("display_registrations");
        mv.addObject("registrationList",page.getList());
        mv.addObject("totalPage",page.getPages());
        mv.addObject("currentPage",page.getPageNum());
        mv.addObject("registrationId",registrationId);
        return mv;
    }
    @RequestMapping(value = "/display_registration_records.do")
    public ModelAndView displayRegistrationInDetail(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("display_registration_records");
    	Long rid = Long.parseLong(request.getParameter("registrationId"));
    	List<RollcallExport> list = rollCallService.getRegistration(rid);
    	mv.addObject("rollcallDisplayList",list);
    	mv.addObject("rId",rid);
    	return mv;
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
    	List<Location> locationList1 = locationService.getAll();
    	
    	
    	mav.addObject("clist",courseList1);
    	mav.addObject("locationList",locationList1);
        return mav;
    }
    
    @RequestMapping(value = "/welcome.do")
    public String welcome(Registration registration) {
        return "teacher_login";

    }
    
    @RequestMapping(value = "/add.do")
    public String asdf(HttpServletRequest req) throws ParseException, UnsupportedEncodingException {
    	
    	Enumeration<String> em = req.getParameterNames();
        while(em.hasMoreElements()) {
        	String name1 = em.nextElement();
        	String value1 = req.getParameter(name1);
        	byte[] b = value1.getBytes("ISO-8859-1");
        	String value2 = new String(b, "UTF-8");
        }
		
        
        
        Registration registration = new Registration();
        String classId = req.getParameter("class_id");
        String className = req.getParameter("class_name");
        className = new String(className.getBytes("ISO-8859-1"),"UTF-8");
        String locationId = req.getParameter("location_id");
        String sTime = req.getParameter("sTime");
        String eTime = req.getParameter("eTime");
        
        sTime = sTime.replaceAll("T", " ");
        eTime = eTime.replaceAll("T", " ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startTime = sdf.parse(sTime);
        Date endTime = sdf.parse(eTime);
        
        
        registration.setcId(Long.parseLong(classId));
        registration.setcName(className);
        registration.setlId(Long.parseLong(locationId));
        registration.setsTime(startTime);
        registration.seteTime(endTime);
        
        registrationService.add(registration);
        
    	/**
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
    	*/
        return "teacher_login";
    }

    @RequestMapping(value="/delete.do")
    @ResponseBody
    public Map<String, String> delete(HttpServletRequest request){
    	System.out.println("Here is manage/delete.do");
    	String rId = request.getParameter("rId");
    	Map<String, String> result = new HashMap<String,String>();
    	if(rId!=null&&(!rId.equals(""))) {
    		long registrationId = Long.parseLong(rId);
    		registrationService.deleteById(registrationId);
    		result.put("message","success");
    	}else {
    		result.put("message", "fail");
    	}
    	
    	System.out.println("deletion result = "+result.get("message"));
    	return result;
    }
}
