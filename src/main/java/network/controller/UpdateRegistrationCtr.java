package network.controller;

import network.model.Registration;
import network.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "manage")
public class UpdateRegistrationCtr {
    @Autowired
    private RegistrationService registrationService;
    @RequestMapping(value = "/add.do")
    public String add(Registration registration) {
        registrationService.add(registration);
        return "teacher_login";

    }

}
