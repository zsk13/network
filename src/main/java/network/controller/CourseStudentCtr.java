package network.controller;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "course_student")
public class CourseStudentCtr {

    @Autowired
    private CourseStudentService courseStudentService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/redirect.do")
    public String wechatRedirect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=wx39b5d81dba20a59e&" +
                "redirect_uri=http://47.100.116.100/network/course_student/addCourseStudent.do" +
                "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    }

    @RequestMapping(value = "/addCourseStudent.do")
    public ModelAndView CourseStudentAddView(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("selectCourse");
        List<Course> cList = courseStudentService.getAllSelectiveCourses();
        mv.addObject("cList", cList);
        mv.addObject("openId", openid);
        return mv;
    }

    @RequestMapping(value = "/add.do")
    public @ResponseBody
    Map<String, Object> add(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();

        Date first = new Date();
//        DateFormat formatfirst = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String createtime = formatfirst.format(first);

        String cId = request.getParameter("cId");
        String cPassword = request.getParameter("cPassword");
        String openId = request.getParameter("openId");

        int code;

        if(openId == null || openId.trim().length()<=0){
            code = 3;
            map.put("code", code);
            return map;

        }
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
}
