package network.service;

import java.util.List;

import network.model.Answer;
import network.vo.AnswerVO;

public interface AnswerService {
    
    public List<Integer> getAnswerNum(Long qid);
    public List<Answer> getAnswer(Long qid);
    public List<AnswerVO> getAnswerVO(Long qid);
}
