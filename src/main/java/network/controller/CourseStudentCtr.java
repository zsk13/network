package network.controller;

import network.common.AppUtil;
import network.common.OpenIdUtil;
import network.model.Course;
import network.model.CourseStudent;
import network.model.Users;
import network.service.CourseStudentService;
import network.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping(value = "course_student")
public class CourseStudentCtr {

    @Autowired
    private CourseStudentService courseStudentService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/redirect.do")
    public String wechatRedirect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String appid = AppUtil.getAppId();
        String URL = AppUtil.getURL();
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid="+appid+"&" +
                "redirect_uri="+URL+"course_student/addCourseStudent.do?type=1" +
                "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    }
    @RequestMapping(value = "/quitRedirect.do")
    public String quitRedirect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String appid = AppUtil.getAppId();
        String URL = AppUtil.getURL();
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid="+appid+"&" +
                "redirect_uri="+URL+"course_student/addCourseStudent.do?type=2" +
                "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    }

    @RequestMapping(value = "/addCourseStudent.do")
    public ModelAndView CourseStudentAddView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer type = Integer.valueOf(request.getParameter("type"));
        String openid = (String) request.getSession().getAttribute("openId");
        if (openid == null || openid.trim().length() <= 0) {

            //用code换取openid
            String CODE = request.getParameter("code");
            try {
                if (CODE != null)
                    openid = OpenIdUtil.getOpenId(URLEncoder.encode(CODE, "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute("openId", openid);
        }
        Users users = usersService.findByOpneId(openid);
        ModelAndView mv = new ModelAndView();
        List<Course> list = new ArrayList<Course>();
        if (type == 1) {
            mv.setViewName("selectCourse");

            if (users != null) {
                list = courseStudentService.getAllNoSelected(users.getuId());
            }
            mv.addObject("cList", list);
        } else {
            mv.setViewName("quitCourse");
            if (users != null)
                list = courseStudentService.getAllSelected(users.getuId());
            mv.addObject("cList", list);
        }

        mv.addObject("openId", openid);
        return mv;
    }

    @RequestMapping(value = "/add.do")
    public @ResponseBody
    Map<String, Object> add(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();

        Date first = new Date();

        String cId = request.getParameter("cId");
        String cPassword = request.getParameter("cPassword");
        String openId = request.getParameter("openId");

        int code;

        Users users = usersService.findByOpneId(openId);

        if (!courseStudentService.checkPassword(Long.valueOf(cId), cPassword)) {
            code = 2;
            map.put("code", code);
            return map;
        }

        CourseStudent courseStudent = new CourseStudent();
        courseStudent.setcId(Long.valueOf(cId));
        courseStudent.setsTime(first);
        courseStudent.setsId(users.getuId());
        courseStudentService.addCourseStudent(courseStudent);
        code = 1;
        map.put("code", code);
        return map;
    }

    @RequestMapping(value = "/delete.do")
    public @ResponseBody
    Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();

        String cId = request.getParameter("cId");
        String openId = request.getParameter("openId");

        int code;
        Users users = usersService.findByOpneId(openId);

        courseStudentService.delete(users.getuId(), Long.valueOf(cId));
        code = 1;
        map.put("code", code);
        return map;
    }
}
