package network.controller;

import network.model.Users;
import network.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "student")
public class StudentCtr {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/addStudent.do")
    public ModelAndView StudentAddView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addStudent");
        return mv;
    }

    @RequestMapping(value = "/add.do")
    public @ResponseBody Map<String, Object> add(HttpServletRequest request, HttpServletResponse response) {
        String sno = request.getParameter("sno");
        String name = request.getParameter("sName");

        Users users = new Users();
        users.setSno(sno);
        users.setName(name);

        studentService.addStudent(users);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "success");
        return map;
    }
}
