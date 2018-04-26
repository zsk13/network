package network.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import network.dao.AnswerMapper;
import network.dao.UsersDao;
import network.model.Answer;
import network.model.AnswerExample;
import network.model.Users;
import network.service.AnswerService;
import network.vo.AnswerVO;

@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    AnswerMapper answerMapper;
    
    @Autowired
    UsersDao usersDao;
    
    public List<Answer> getAnswer(Long qid){
        AnswerExample answerExample = new AnswerExample();
        AnswerExample.Criteria criteria = answerExample.createCriteria();
        criteria.andQidEqualTo(qid);
        return  answerMapper.selectByExample(answerExample);
    }
    public List<Integer> getAnswerNum(Long qid){
        List<Integer> num = new ArrayList<Integer>();
        List<Answer> listAnswer = getAnswer(qid);
        int total = listAnswer.size();
        num.add(total);
        int correctNum = 0;
        boolean answer;
        for (Answer t : listAnswer) {
            answer = t.getCorrect();
            if(answer){
                correctNum++;
            }
        }
        num.add(correctNum);
        int wrongNum = total - correctNum;
        num.add(wrongNum);
        return  num;
    }
    @Override
    public List<AnswerVO> getAnswerVO(Long qid) {
        // TODO Auto-generated method stub
        List<Answer> listAnswer = getAnswer(qid);
        List<AnswerVO> alist = new ArrayList<AnswerVO>();
        for(Answer a : listAnswer){
            Users u =usersDao.selectByPrimaryKey(a.getUid());
            AnswerVO tempVO = new AnswerVO(u.getName(), a.getContent(), a.getCorrect());
            alist.add(tempVO);
        }
        return alist;
    }

}
