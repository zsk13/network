package network.model;

public class Answer {
    Long aid;
    Long uid;
    Long qid;
    String content;
    Boolean correct;
    public Long getAid() {
        return aid;
    }
    public void setAid(Long aid) {
        this.aid = aid;
    }
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getQid() {
        return qid;
    }
    public void setQid(Long qid) {
        this.qid = qid;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Boolean getCorrect() {
        return correct;
    }
    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
    
}
