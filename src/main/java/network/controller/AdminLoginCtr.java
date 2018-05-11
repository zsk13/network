package network.controller;

import network.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "adminLogin")
public class AdminLoginCtr {
    @Autowired
    private AdminLoginService adminLoginService;

    @RequestMapping("/adminLogin.do")
    public String login() {
        return "admin_login";
    }

    @RequestMapping("/check.do")
    public String check(HttpServletRequest request, String name, String password, RedirectAttributes attr) {
        if (name == null || name.length() <= 0 || password == null || password.length() <= 0) {
            attr.addFlashAttribute("msg", "用户名或密码不能为空！");
            return "redirect:./adminLogin.do";
        }
        if (!adminLoginService.check(name, password)) {
            attr.addFlashAttribute("msg", "用户名或密码不正确！");
            return "redirect:./adminLogin.do";
        } else {
            attr.addFlashAttribute("name", name);
            request.getSession().removeAttribute("username");
            request.getSession().setAttribute("username", name);
            request.getSession().setAttribute("type", "admin");
            return "redirect:../teacher/teacherlist.do";
        }


    }

}

