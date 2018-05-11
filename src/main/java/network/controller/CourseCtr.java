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
import network.model.Question;
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
        List<Course> courseList = questionService.getAllCourses(teacher.gettId());
        mv.addObject("courseList", courseList);
        return mv;
    }
    
    @RequestMapping(value = "/editCourse.do")
    public ModelAndView updateCourse(Long cid,HttpServletResponse res, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editCourse");
        Course c = courseService.getCourse(cid);
        mv.addObject("c", c);
        return mv;
    }
    
    @RequestMapping(value = "/update.do")
    @ResponseBody
    public String update(Long cid, String  c_name,String  c_password,Integer c_state,HttpServletResponse res, HttpServletRequest request){
        Course c=new Course();
        c.setcId(cid);
        c.setcName(c_name);
        c.setcPassword(c_password);
        c.setcState(c_state);
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        c.settId(teacher.gettId());

        courseService.updateByPrimaryKey(c);
        return "success";
    }
    
    @RequestMapping(value = "/deleteCourse.do")
    public String deleteCourse(Long cid,HttpServletResponse res, HttpServletRequest request) throws Exception{
        courseService.deleteByPrimaryKey(cid);
        return "redirect:./courseList.do";
    }

}
