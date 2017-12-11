package network.controller;

import com.alibaba.fastjson.JSON;
import network.common.wechatUtil.WechatMessageUtil;
import network.model.Question;
import network.service.QuestionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "question")
public class QuestionCtr {
    Log logger = LogFactory.getLog(QuestionCtr.class);

    @Autowired
    QuestionService questionservice;


    @RequestMapping(value = "/addquestion.do")
    public ModelAndView QuestionAddView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("question");
        return mv;
    }

    @RequestMapping(value = "/questionlist.do")
    public ModelAndView QuestionListView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("questionList");
        return mv;
    }

    @RequestMapping(value = "/add.do")
    public void add(Long teacher_id,String question,String answer,String status,HttpServletResponse res){


        //teacher_id = Long.valueOf(1);

        //status ="0" ;

        Date first = new Date();
        DateFormat formatfirst = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = formatfirst.format(first);

        Question que=new Question();
        que.setQid(first.getTime());
        que.setAnswer(answer);
        que.setQuestion(question);
        que.setStatus(status);
        que.setTeacherId(teacher_id);

        questionservice.insert(que);

        //String responseMessage = WechatMessageUtil.textMessageToXml(que);


        JSON.parse(String.valueOf(que));
        //System.out.println("a");

    }



}
