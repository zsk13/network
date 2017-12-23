package network.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import network.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import network.model.Rollcall;
import network.model.RollcallDisplay;
import network.service.RegistrationService;
import network.service.RollcallService;

@Controller
@RequestMapping(value = "rollcall")
public class RollcallCtr {
	@Autowired
    private RollcallService rollcallService;
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value = "/display_registrations.do")
	public ModelAndView showRegistrations(HttpServletRequest request) {
		System.out.println("This is RollcallCtr.showRegistrations. rollcall/display_registrations.do expected.");
		ModelAndView mav = new ModelAndView("display_registrations");
		List<Registration> list1 = registrationService.getAll();
		mav.addObject("registrationList", list1);
		return mav;
	}
	
	@RequestMapping(value="/display_registration_records.do")
	public ModelAndView showRollcall(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("display_registration_records");
		List<Rollcall> rollcallList1 = null;
		List<RollcallDisplay> list2 = null;
		
		String registrationId = request.getParameter("registrationId");
		if(registrationId!=null && (!registrationId.equals(""))) {
			Long rid = Long.parseLong(registrationId);
			rollcallList1 = rollcallService.getByRegistrationId(rid);
			list2 = rollcallService.getAllRollcallDisplaysByRegistrationId(rid);
		}else {
			rollcallList1 = rollcallService.getAll();
			list2 = rollcallService.getAllRollcallDisplays();
		}
		
		mav.addObject("rollcallList", rollcallList1);
		mav.addObject("rollcallDisplayList", list2);
		
		
		return mav;
	}
}
