package network.service;

import network.model.Question;

import java.io.PrintWriter;
import java.util.Map;

public interface QuestionService {
    public void dealGetQuestion(Map<String, String> map, PrintWriter out);
    public void dealCommitQuestion(Map<String, String> map, PrintWriter out);
    int insert(Question record);
}
