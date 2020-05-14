package app.model;

import java.util.List;

public class QuizForm {
    private List<String> correctAnswer;
    private String content;
    private String subjectName;
    private List<String> answer;

    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    public QuizEntity getQuizEntity() {
        return new QuizEntity(this.content,new SubjectEntity(this.subjectName));
    }

    public String getContent() {
        return content;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setCorrectAnswer(List<String> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
