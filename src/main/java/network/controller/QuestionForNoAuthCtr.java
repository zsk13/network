package network.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import network.model.Question;
import network.service.QuestionService;

@Controller
@RequestMapping(value="courseques")
public class QuestionForNoAuthCtr {
    
    @Autowired
    QuestionService questionService ;
    
    @RequestMapping(value = "/get.do")
    public ModelAndView quesView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        String openid = (String)request.getParameter("openId");
        Question q =questionService.getQuestionByOpenId(openid);
        String question ;
        if(q == null){
            question = "当前没有问题";
        }else{
            question = q.getQuestion();
        }
        mv.addObject("openid", openid);
        mv.addObject("question", question);
        mv.setViewName("courseQues");
        return mv;
    }
    @RequestMapping(value = "/submit.do")
    public @ResponseBody String submit(HttpServletResponse res, HttpServletRequest request) throws Exception {
        String openid = (String)request.getParameter("openId");
        String answer = (String)request.getParameter("answer");
        Boolean cor = questionService.dealCommitQuestionWithoutAuth(openid, answer);
        return cor.toString();
    }
}
