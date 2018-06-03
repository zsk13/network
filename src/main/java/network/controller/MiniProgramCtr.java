package network.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import network.model.Course;
import network.model.CourseStudent;
import network.model.Question;
import network.model.Registration;
import network.model.Rollcall;
import network.model.Users;
import network.service.CourseService;
import network.service.CourseStudentService;
import network.service.QuestionService;
import network.service.RegistrationService;
import network.service.RollcallService;
import network.service.UsersService;
import network.vo.CommonBean;

@Controller
@RequestMapping(value = "miniProgram")
public class MiniProgramCtr {
    @Autowired
    private UsersService usersService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private RegistrationService registrationService;
    
    @Autowired
    private RollcallService rollcallService;

    @RequestMapping("/first")
    @ResponseBody
    public CommonBean getFirst() {
        CommonBean bean = new CommonBean();
        bean.setResultCode("success");
        bean.setData("this is first message");
        return bean;
    }

    @RequestMapping("/getOpenid")
    @ResponseBody
    public CommonBean getOpenid(String code) throws IOException {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + "wxeb98926a6249d73b" + "&secret="
                + "f77fc9ce8163a716abe1f9b2f114e9f9" + "&js_code=" + code + "&grant_type=authorization_code";
        URL urls = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
        InputStream inputStream = conn.getInputStream();
        InputStreamReader read = new InputStreamReader(inputStream, "utf-8");
        // 为字符输入流添加缓冲
        BufferedReader br = new BufferedReader(read);
        // 读取返回结果
        String data = br.readLine();
        System.out.println(data);
        JSONObject obj = JSONObject.parseObject(data);
        String openid = obj.getString("openid");
        Users user = usersService.findByOpneId(openid);
        if (user == null) {
            user = new Users();
            user.setuOpenId(openid);
            usersService.createUser(user);
        }
        CommonBean bean = new CommonBean();
        bean.setCode(200);
        bean.setData(openid);
        return bean;
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public CommonBean getUserInfo(String openid) {
        Users user = usersService.findByOpneId(openid);
        CommonBean bean = new CommonBean();
        bean.setCode(200);
        bean.setData(user);
        return bean;
    }

    @RequestMapping("/getQuestion")
    @ResponseBody
    public CommonBean getQuestion(String openid) {
        Users user = usersService.findByOpneId(openid);
        Question q = questionService.getQuestionByOpenId(openid);
        CommonBean bean = new CommonBean();
        bean.setCode(200);
        bean.setData(q);
        return bean;
    }

    /**
     * 获取当前需要签到的签到信息
     * @param openid
     * @return
     */
    @RequestMapping("/getCourse")
    @ResponseBody
    public CommonBean getCourse(String openid) {
        Users user = usersService.findByOpneId(openid);
        List<Registration> list = registrationService.getByOpenid(openid);

        CommonBean bean = new CommonBean();
        bean.setCode(200);
        if(list==null || list.size()==0){
            bean.setData(null);
        }else{
            Rollcall rollcall = rollcallService.getRegistrationByRidAndUid(list.get(0).getrId(), user.getuId());
            if(rollcall==null){
                bean.setData(list.get(0));
            }else{
                bean.setData(list.get(0).getcName());
            }
            
        }
        return bean;
    }



    @RequestMapping("/submitUserInfo")
    @ResponseBody
    public CommonBean submitUserInfo(String openid, String name, String sno) {
        CommonBean bean = new CommonBean();
        Users user = usersService.findByOpneId(openid);
        if(user!=null){
            user.setName(name);
            user.setSno(sno);
            usersService.updateUser(user);
            
            bean.setCode(200);
            bean.setData(user);
        }else{
            bean.setCode(500);
            bean.setData("user not exist");
        }

        return bean;
    }


    @RequestMapping("/submitAnswer")
    @ResponseBody
    public CommonBean submitAnswer(String openid, String answer) {
        Users user = usersService.findByOpneId(openid);
        boolean b = questionService.dealCommitQuestionWithoutAuth(openid, answer);
        CommonBean bean = new CommonBean();
        bean.setCode(200);
        bean.setData(b);
        return bean;
    }

    @RequestMapping("/rollcall")
    @ResponseBody
    public CommonBean rollcall(String openid, double x, double y) {
        Date date = new Date();
        List<Registration> list = registrationService.getByOpenid(openid);
        int state = 1;
        if (list == null || list.size() == 0) {

        } else {
            state = registrationService.registration(list.get(0).getrId(), x, y, openid, date);
        }
        CommonBean bean = new CommonBean();
        bean.setCode(200);
        bean.setData(state);
        return bean;
    }

    @RequestMapping("/getCourses")
    @ResponseBody
    public CommonBean getCourses(String openid) {
        Users user = usersService.findByOpneId(openid);
        List<Course> all = new ArrayList<Course>();
        List<Course> selected = new ArrayList<Course>();
        JSONArray array = new JSONArray();
        if (user != null) {
            selected = courseStudentService.getAllSelected(user.getuId());
            Set<Long> ids = new HashSet<Long>();
            for(Course course : selected){
                JSONObject obj = new JSONObject();
                obj.put("id", course.getcId());
                obj.put("name", course.getcName());
                obj.put("hasSelected", true);
                array.add(obj);
                ids.add(course.getcId());
            }
            all = courseStudentService.getAllSelectiveCourses();
            for(Course course : all){
                if(!ids.contains(course.getcId())){
                    JSONObject obj = new JSONObject();
                    obj.put("id", course.getcId());
                    obj.put("name", course.getcName());
                    obj.put("hasSelected", false);
                    array.add(obj);
                }
            }
        }else{
            array = null;
        }

        CommonBean bean = new CommonBean();
        bean.setCode(200);
        bean.setData(array);
        return bean;
    }

    
    @RequestMapping("/selectCourse")
    @ResponseBody
    public CommonBean selectCourse(String openid, Long cId,String password) {
        Date date = new Date();
        CommonBean bean = new CommonBean();
        bean.setCode(200);
        Users users = usersService.findByOpneId(openid);
        if (!courseStudentService.checkPassword(Long.valueOf(cId), password)) {
            bean.setData("密码错误");
        }else{
            CourseStudent courseStudent = new CourseStudent();
            courseStudent.setcId(Long.valueOf(cId));
            courseStudent.setsTime(date);
            courseStudent.setsId(users.getuId());
            courseStudentService.addCourseStudent(courseStudent);
            bean.setData("success");
        }
        return bean;
    }
}
