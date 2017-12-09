package network.service.impl;

import network.dao.AnswerMapper;
import network.model.Answer;
import network.model.AnswerExample;
import network.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnswerServiceImpl implements AnswerService{
    @Autowired
    AnswerMapper answerMapper;
    public List<Answer> getAnswer(Long qid){
        AnswerExample answerExample = new AnswerExample();
        AnswerExample.Criteria criteria = answerExample.createCriteria();
        criteria.andQidEqualTo(qid);
        return  answerMapper.selectByExample(answerExample);
    }
    public List<Integer> getAnswerNum(Long qid){
        List<Integer> num = null;
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
    
}
