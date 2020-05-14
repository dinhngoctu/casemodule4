package app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answer", schema = "case4")
public class AnswerEntity {
    private long id;
    private String content;
    private QuizEntity quizByQuizId;

    public AnswerEntity() {
    }
    public AnswerEntity(Long id,QuizEntity quizByQuizId,String content) {
        this.id = id;
        this.content = content;
        this.quizByQuizId = quizByQuizId;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity that = (AnswerEntity) o;
        return id == that.id &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

//    @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "quizId", referencedColumnName = "id", nullable = false)
    public QuizEntity getQuizByQuizId() {
        return quizByQuizId;
    }

    public void setQuizByQuizId(QuizEntity quizByQuizId) {
        this.quizByQuizId = quizByQuizId;
    }

}
