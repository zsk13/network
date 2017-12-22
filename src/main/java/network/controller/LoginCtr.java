package network.controller;

import network.service.LoginService;
import network.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "manage")
public class LoginCtr {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/login.do")
    public String login() {
        return "login";
    }

    @RequestMapping("/check.do")
    public String check(HttpServletRequest request, String name, String password, RedirectAttributes attr) {
        if (name == null || name.length() <= 0 || password == null || password.length() <= 0) {
            attr.addFlashAttribute("msg", "用户名或密码不能为空！");
            return "redirect:./login.do";
        }
        if (!teacherService.login(name, password)) {
            attr.addFlashAttribute("msg", "用户名或密码不正确！");
            return "redirect:./login.do";
        } else {
            attr.addFlashAttribute("name", name);
            request.getSession().setAttribute("username", name);
            request.getSession().setAttribute("type", "teacher");
            return "redirect:./welcome.do";
        }


    }

}
