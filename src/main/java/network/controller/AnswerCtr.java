package network.controller;

import network.model.Question;
import network.service.QuestionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "answer")
public class AnswerCtr {
    Log logger = LogFactory.getLog(AnswerCtr.class);

    QuestionService questionservice;


    @RequestMapping(value = "/addquestion.do")
    public ModelAndView QuestionAddView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("answer");
        return mv;
    }

    @RequestMapping(value = "/add.do")
    public void add(Long qid,Long teacher_id,String question,String answer,String status,HttpServletResponse res){

        Question que=new Question();
        que.setQid(qid);
        que.setAnswer(answer);
        que.setQuestion(question);
        que.setStatus(status);
        que.setTeacherId(teacher_id);

        questionservice.insert(que);

        //String responseMessage = WechatMessageUtil.textMessageToXml(que);



    }
}
