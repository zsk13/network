package network.service;

import network.model.Question;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public interface QuestionService {
    public void dealGetQuestion(Map<String, String> map, PrintWriter out);
    public void dealCommitQuestion(Map<String, String> map, PrintWriter out);
    int insert(Question record);
    public List<Question> getQuestions();
    public void publishQuestion(Long qid);
}
