package network.controller;

import network.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "adminLogin")
public class AdminLoginCtr {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/adminLogin.do")
    public String login(){
        return "admin_login";
    }
    @RequestMapping("/check.do")
    public String check(String name,String password, RedirectAttributes attr ){
        if(name == null || name.length()<=0 || password ==null || password.length()<=0) {
            attr.addFlashAttribute("msg", "用户名或密码不能为空！");
            return "redirect:./adminLogin.do";
        }
        if(!loginService.check(name, password)) {
            attr.addFlashAttribute("msg", "用户名或密码不正确！");
            return "redirect:./adminLogin.do";
        }else {
            attr.addFlashAttribute("name", name);

            return "redirect:../manage/welcome.do";
        }


    }

}
