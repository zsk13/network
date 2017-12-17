package network.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import network.model.Question;
import network.service.AnswerService;
import network.service.QuestionService;

@Controller
@RequestMapping(value = "question")
public class QuestionCtr {
    Log logger = LogFactory.getLog(QuestionCtr.class);

    @Autowired
    QuestionService questionservice;
    
    @Autowired
    AnswerService answerservice;


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
        List<Question> qs = questionservice.getQuestions();
        mv.addObject("qs", qs);
        return mv;
    }
    
    @RequestMapping(value = "/answer.do")
    public ModelAndView AnswerView(Long qid,HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("answer");
        List<Integer> qs = answerservice.getAnswerNum(qid);
        mv.addObject("total", qs.get(0));
        mv.addObject("correct", qs.get(1));
        mv.addObject("wrong", qs.get(2));
        return mv;
    }

    @RequestMapping(value = "/add.do")
    @ResponseBody
    public String add(Long teacher_id,String question,String answer,String status,HttpServletResponse res){


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
        return "success";

        //String responseMessage = WechatMessageUtil.textMessageToXml(que);


        //System.out.println("a");

    }
    
    @RequestMapping(value = "/publishQuestion.do")
    public void publishQuestion(Long qid,HttpServletResponse res, HttpServletRequest request) throws Exception {
        questionservice.publishQuestion(qid);
    }



}
