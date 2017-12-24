package network.controller;

import network.common.OpenIdUtil;
import network.model.Users;
import network.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "student")
public class StudentCtr {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/redirect.do")
    public String wechatRedirect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=wx39b5d81dba20a59e&" +
                "redirect_uri=http://47.100.116.100/network/student/addStudent.do" +
                "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    }

    @RequestMapping(value = "/addStudent.do")
    public ModelAndView StudentAddView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //用code换取openid
        String CODE = request.getParameter("code");
        String openid = null;
        try {
            if (CODE != null)
                openid = OpenIdUtil.getOpenId(URLEncoder.encode(CODE, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addStudent");
        mv.addObject("openId", openid);
        return mv;
    }

    @RequestMapping(value = "/add.do")
    public @ResponseBody
    Map<String, Object> add(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();

        String sno = request.getParameter("sno");
        String name = request.getParameter("sName");
        String openId = request.getParameter("openId");
        String className = request.getParameter("className");
        int code;
        if (openId == null || openId.trim().length() == 0) {
            code = 3;
            map.put("code", code);
            return map;
        }
        Users users = new Users();
        users.setSno(sno);
        users.setName(name);
        users.setuOpenId(openId);
        users.setClassname(className);
        code = studentService.addStudent(users);

        map.put("code", code);
        return map;
    }
}
