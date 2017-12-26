package network.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import network.model.Course;
import network.model.Question;

public interface QuestionService {
    public void dealGetQuestion(Map<String, String> map, PrintWriter out);
    public void dealCommitQuestion(Map<String, String> map, PrintWriter out);
    int insert(Question record);
    public List<Question> getQuestions();
    public void publishQuestion(Long qid);
    public List<Course> getCourses(Long tId);
    public List<Course> getAllCourses(Long tId);
    public Question getQuestion(Long qid);
    public void update(Question que);
}
