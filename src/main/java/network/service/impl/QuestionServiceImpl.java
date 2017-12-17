package network.service.impl;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import network.common.wechatUtil.TextMessage;
import network.common.wechatUtil.WechatMessageUtil;
import network.dao.AnswerMapper;
import network.dao.QuestionMapper;
import network.dao.UsersDao;
import network.model.Answer;
import network.model.Question;
import network.model.QuestionExample;
import network.model.Users;
import network.service.QuestionService;

@Service

public class QuestionServiceImpl implements QuestionService{

    BaseService baseService = new BaseService();

    @Autowired
    QuestionMapper questionMapper;
    
    @Autowired
    AnswerMapper answerMapper;
    
    @Autowired
    UsersDao usersDao;

    public List<Question> getQuestion(){
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andStatusEqualTo("1");
        questionExample.setOrderByClause("qid DESC");
        return  questionMapper.selectByExample(questionExample);
    }

    public void dealGetQuestion(Map<String, String> map,PrintWriter out) {
        // TODO Auto-generated method stub
        String question = "";
        List<Question> listQuestions = getQuestion();
        question = listQuestions.get(0).getQuestion();
        
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        TextMessage textMessage = new TextMessage();
        textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setContent(question);
        String responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        out.print(responseMessage);
        out.flush();
    }

    public void dealCommitQuestion(Map<String, String> map, PrintWriter out) {
        // TODO Auto-generated method stub
        
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String answer = map.get("Content");
        String responseMessage = "默认";
        String correctAnswer = "";
        
        TextMessage textMessage = new TextMessage();
        textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(System.currentTimeMillis());
        String respContent = "";
        List<Question> listQuestions = getQuestion();
        Question question = listQuestions.get(0);
        correctAnswer = question.getAnswer();
        
        Users user = usersDao.selectByOpenId(fromUserName);
        Answer answer1 = new Answer();
        answer1.setQid(question.getQid());
        answer1.setContent(answer);
        answer1.setUid(user.getuId());

        if(correctAnswer==null || correctAnswer.equals("") ||answer.equals(correctAnswer)){
            answer1.setCorrect(true);
            respContent = "回答正确";
        }else{
            answer1.setCorrect(false);
            respContent = "回答错误";
        }
        
        answerMapper.insert(answer1);
        
        textMessage.setContent(respContent);
        responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        out.print(responseMessage);
        out.flush();
    }

    @Override
    public int insert(Question record) {

        
        return questionMapper.insert(record);
    }

    @Override
    public List<Question> getQuestions() {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        questionExample.setOrderByClause("qid DESC");
        return  questionMapper.selectByExample(questionExample);
    }

    @Override
    public void publishQuestion(Long qid) {
        Question q = questionMapper.selectByPrimaryKey(qid);
        q.setStatus("1");
        List<Question> questions = getQuestion();
        for(Question q1 : questions){
            q1.setStatus("2");
            questionMapper.updateByPrimaryKey(q1);
        }
        questionMapper.updateByPrimaryKey(q);
        
    }

}
