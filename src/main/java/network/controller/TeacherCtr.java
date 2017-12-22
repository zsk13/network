package network.controller;

import network.model.Teacher;
import network.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "teacher")
public class TeacherCtr {
    @Autowired
    TeacherService teacherservice;


    @RequestMapping(value = "/addteacher.do")
    public ModelAndView TeacherAddView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addTeacher");
        return mv;
    }

    @RequestMapping(value = "/teacherlist.do")
    public ModelAndView TeacherListView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teacherList");
        List<Teacher> ts = teacherservice.getTeachers();
        mv.addObject("ts", ts);
        return mv;
    }

    @RequestMapping(value = "/editteacher.do")
    public ModelAndView TeacherEditView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editTeacher");
        return mv;
    }

    @RequestMapping(value = "/add.do")
    public
    @ResponseBody Map<String, Object> add(HttpServletRequest request, HttpServletResponse response){
        String tName = request.getParameter("tName");
        String tPassword = request.getParameter("tPassword");
        String tNumber = request.getParameter("tNumber");
        String tMail= request.getParameter("tMail");
        String tPhone = request.getParameter("tPhone");

        Teacher teacher=new Teacher();
        teacher.settName(tName);
        teacher.settPassword(tPassword);
        teacher.settNumber(tNumber);
        teacher.settMail(tMail);
        teacher.settPhone(tPhone);

        teacherservice.createTeacher(teacher);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "success");
        return map;

    }
    @RequestMapping(value = "/del.do")
    public
    @ResponseBody Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response){
        String tNumber = request.getParameter("tNumber").toString();

        teacherservice.deleteTeacherBytNumber(tNumber);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "success");
        return map;

    }

    @RequestMapping(value = "/edit.do")
    public
    @ResponseBody Map<String, Object> edit(HttpServletRequest request, HttpServletResponse response) {
        String tNumber = request.getParameter("tNumber").toString();

        Teacher teacher = teacherservice.findTeacher(tNumber);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "success");
        map.put("name",teacher.gettName());
        map.put("password",teacher.gettPassword());
        map.put("number",teacher.gettNumber());
        map.put("mail",teacher.gettMail());
        map.put("phone",teacher.gettPhone());
        return map;

    }

    @RequestMapping(value = "/update.do")
    public
    @ResponseBody Map<String, Object> update(HttpServletRequest request, HttpServletResponse response){
        String tName = request.getParameter("tName");
        String tPassword = request.getParameter("tPassword");
        String tNumber = request.getParameter("tNumber");
        String tMail= request.getParameter("tMail");
        String tPhone = request.getParameter("tPhone");
        String tid = request.getParameter("tid");
        System.out.println("success read");

        Teacher teacher=new Teacher();
        teacher.settName(tName);
        teacher.settPassword(tPassword);
        teacher.settNumber(tNumber);
        teacher.settMail(tMail);
        teacher.settPhone(tPhone);

        teacherservice.updateTeacherBytNumber(teacher,tid);

        System.out.println("success update");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "success");
        return map;

    }
}

