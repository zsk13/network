package network.model;

public class Question {
    private Long qid;
    private Long teacher_id;
    private String question;
    private String answer;
    private String status;
    public Long getQid() {
        return qid;
    }
    public void setQid(Long qid) {
        this.qid = qid;
    }
    public Long getTeacher_id() {
        return teacher_id;
    }
    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
