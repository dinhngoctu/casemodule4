package app.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "quiz", schema = "case4")
public class QuizEntity {
    private long id;
    private String content;
    private List<AnswerEntity> answersById;
    private SubjectEntity subjectBySubjectName;
    private List<TestEntity> testEntities;

    public QuizEntity() {
    }

    public QuizEntity(String content, SubjectEntity subjectEntity) {
        this.content = content;
        this.subjectBySubjectName = subjectEntity;
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
        QuizEntity that = (QuizEntity) o;
        return id == that.id &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

//    @OneToMany
    @OneToMany(mappedBy = "quizByQuizId",fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    public List<AnswerEntity> getAnswersById() {
        return answersById;
    }

    public void setAnswersById(List<AnswerEntity> answersById) {
        this.answersById = answersById;
    }

    @ManyToOne
    @JoinColumn(name = "subjectName", referencedColumnName = "subjectName", nullable = false)
    public SubjectEntity getSubjectBySubjectName() {
        return subjectBySubjectName;
    }

    public void setSubjectBySubjectName(SubjectEntity subjectBySubjectName) {
        this.subjectBySubjectName = subjectBySubjectName;
    }
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "quizEntities",cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    public List<TestEntity> getTestEntities() {
        return testEntities;
    }

    public void setTestEntities(List<TestEntity> testEntities) {
        this.testEntities = testEntities;
    }
}
