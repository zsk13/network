package network.controller;

import network.model.Course;
import network.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value="course")
public class CourseCtr {
    Log logger = LogFactory.getLog(CourseCtr.class);

    @Autowired
    CourseService courseService ;

    @RequestMapping(value = "/addcourse.do")
    public ModelAndView CourseAddView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addCourse");
        return mv;
    }

    @RequestMapping(value = "/publishCourse.do")
    @ResponseBody
    public String publishCourse(String  c_name,String  c_password,int c_state, Long t_id,HttpServletResponse res){



        Date first = new Date();
        DateFormat formatfirst = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = formatfirst.format(first);

        Course c=new Course();

        c.setcId(first.getTime());
        c.setcName(c_name);
        c.setcPassword(c_password);
        c.setcState(c_state);
        c.settId(t_id);

        courseService.insert(c);
        return "success";

    }
}
