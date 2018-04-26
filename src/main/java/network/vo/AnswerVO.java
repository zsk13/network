package network.vo;

public class AnswerVO {
    private String username;
    
    private String content;

    private Boolean correct;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public AnswerVO(String username, String content, Boolean correct) {
        super();
        this.username = username;
        this.content = content;
        this.correct = correct;
    }
    
}
