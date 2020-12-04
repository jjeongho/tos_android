package deu.cse.tos;

public class QnAList {
    private String question;
    private String answer;

    public QnAList(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
