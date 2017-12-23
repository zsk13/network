package network.controller;

import network.model.Registration;
import network.model.Rollcall;
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

@Controller
@RequestMapping(value = "manage")
public class UpdateRegistrationCtr {
	
	
	
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private RollcallService rollCallService;
    @RequestMapping(value = "/display_registrations.do")
    public ModelAndView displayRegistrations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Registration> list1 = registrationService.getAll();
    	ModelAndView mv = new ModelAndView("display_registrations");
    	mv.addObject("registrationList",list1);
    	return mv;
    }
    
    @RequestMapping(value = "/display_registration_records.do")
    public ModelAndView displayRegistrationInDetail(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("Here is DRID");
    	Long rid = Long.parseLong(request.getParameter("registrationId"));
    	System.out.println(rid);
    	List<Rollcall> list = rollCallService.getAll();
    	for(int i = 0;i<list.size();i++) {
    		System.out.println(list.get(i).getuId());
    	}
    	return null;
    }
    
    @RequestMapping(value = "/start_add.do")
    public String add(Registration registration) {
        return "start_a_registration";

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
