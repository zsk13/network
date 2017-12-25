package network.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import network.model.Course;
import network.model.Teacher;
import network.service.CourseService;
import network.service.QuestionService;

@Controller
@RequestMapping(value="course")
public class CourseCtr {
    Log logger = LogFactory.getLog(CourseCtr.class);

    @Autowired
    CourseService courseService ;
    
    @Autowired
    QuestionService questionService ;

    @RequestMapping(value = "/addCourse.do")
    public ModelAndView CourseAddView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addCourse");
        return mv;
    }

    @RequestMapping(value = "/publishCourse.do")
    @ResponseBody
    public String publishCourse(String  c_name,String  c_password,HttpServletResponse res, HttpServletRequest request){
        Date first = new Date();
        Course c=new Course();
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        
        c.setcId(first.getTime());
        c.setcName(c_name);
        c.setcPassword(c_password);
        c.setcState(1);
        c.settId(teacher.gettId());

        courseService.insert(c);
        return "success";

    }
    
    @RequestMapping(value = "/courseList.do")
    public ModelAndView courseListView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courseList");
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        List<Course> courseList = questionService.getCourses(teacher.gettId());
        mv.addObject("courseList", courseList);
        return mv;
    }
}
