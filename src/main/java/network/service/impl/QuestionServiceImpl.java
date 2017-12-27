package network.service.impl;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import network.common.wechatUtil.TextMessage;
import network.common.wechatUtil.WechatMessageUtil;
import network.dao.AnswerMapper;
import network.dao.CourseMapper;
import network.dao.CourseStudentMapper;
import network.dao.QuestionMapper;
import network.dao.UsersDao;
import network.model.Answer;
import network.model.AnswerExample;
import network.model.Course;
import network.model.CourseExample;
import network.model.CourseStudent;
import network.model.CourseStudentExample;
import network.model.Question;
import network.model.QuestionExample;
import network.model.Users;
import network.service.QuestionService;

@Service

public class QuestionServiceImpl implements QuestionService {

    BaseService baseService = new BaseService();

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    AnswerMapper answerMapper;

    @Autowired
    UsersDao usersDao;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    CourseStudentMapper courseStudentMapper;

    public List<Question> getQuestions(Long cid) {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andStatusEqualTo("1");
        criteria.andCourseIdEqualTo(cid);
        questionExample.setOrderByClause("qid DESC");
        return questionMapper.selectByExample(questionExample);
    }

    public void dealGetQuestion(Map<String, String> map, PrintWriter out) {
        // TODO Auto-generated method stub

        String fromUserName = map.get("FromUserName");
        Question q = getQuestionByOpenId(fromUserName);

        String toUserName = map.get("ToUserName");
        TextMessage textMessage = new TextMessage();
        textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(System.currentTimeMillis());
        if (q == null) {
            textMessage.setContent("当前没有需要回答的问题");
        } else {
            textMessage.setContent(q.getQuestion());
        }

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

        Question question = getQuestionByOpenId(fromUserName);
        if (question == null) {
            respContent = "回答正确~";
        } else {
            correctAnswer = question.getAnswer();

            Users user = usersDao.selectByOpenId(fromUserName);
            Answer answer1 = new Answer();
            answer1.setQid(question.getQid());
            answer1.setContent(answer);
            answer1.setUid(user.getuId());

            AnswerExample answerExample = new AnswerExample();
            AnswerExample.Criteria criteria = answerExample.createCriteria();
            criteria.andQidEqualTo(question.getQid());
            criteria.andUidEqualTo(user.getuId());
            List<Answer> list = answerMapper.selectByExample(answerExample);
            
            
            if (correctAnswer == null || correctAnswer.equals("") || answer.equals(correctAnswer)) {
                answer1.setCorrect(true);
                respContent = "回答正确";
            } else {
                answer1.setCorrect(false);
                respContent = "回答错误";
            }
            if(list==null || list.size()==0){
                answerMapper.insert(answer1);
            }else{                           
                answer1.setAid(list.get(0).getAid());
                answerMapper.updateByPrimaryKey(answer1);
            }

        }
        

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
        return questionMapper.selectByExample(questionExample);
    }

    @Override
    public void publishQuestion(Long qid) {
        Question q = questionMapper.selectByPrimaryKey(qid);
        q.setStatus("1");
        List<Question> questions = getQuestions(q.getCourseId());
        for (Question q1 : questions) {
            q1.setStatus("2");
            questionMapper.updateByPrimaryKey(q1);
        }
        questionMapper.updateByPrimaryKey(q);

    }

    @Override
    public List<Course> getCourses(Long tId) {
        // TODO Auto-generated method stub
        return courseMapper.getValidCoursesByTeacherId(tId);
    }

    @Override
    public Question getQuestion(Long qid) {
        // TODO Auto-generated method stub
        return questionMapper.selectByPrimaryKey(qid);
    }

    @Override
    public void update(Question que) {
        questionMapper.updateByPrimaryKey(que);
    }

    /**
     * 选的课程id集合
     * 
     * @param sopenid 学生openid
     * @return 选的课程id集合
     */
    private List<Long> getCIds(String sopenid) {
        Users u = usersDao.selectByOpenId(sopenid);
        CourseStudentExample courseStudentExample = new CourseStudentExample();
        CourseStudentExample.Criteria criteria = courseStudentExample.createCriteria();
        criteria.andSIdEqualTo(u.getuId());
        List<CourseStudent> cs = courseStudentMapper.selectByExample(courseStudentExample);
        List<Long> ls = (List<Long>) cs.stream().map(c -> c.getcId()).collect(Collectors.toList());;
        return ls;
    }

    private Question getQuestionByCids(List<Long> cids) {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andCourseIdIn(cids);
        criteria.andStatusEqualTo("1");
        questionExample.setOrderByClause("qid DESC");

        List<Question> qs = questionMapper.selectByExample(questionExample);
        if (qs == null || qs.size() == 0) {
            return null;
        } else {
            return qs.get(0);
        }
    }

    private Question getQuestionByOpenId(String sopenid) {
        return getQuestionByCids(getCIds(sopenid));
    }

    @Override
    public List<Course> getAllCourses(Long tId) {
        CourseExample CourseExample = new CourseExample();
        CourseExample.Criteria criteria = CourseExample.createCriteria();
        criteria.andTIdEqualTo(tId);
        
        return courseMapper.selectByExample(CourseExample);
    }

    @Override
    public void finishQuestion(Long qid) {
        // TODO Auto-generated method stub
        Question q = questionMapper.selectByPrimaryKey(qid);
        q.setStatus("2");
        questionMapper.updateByPrimaryKey(q);
    }

}
