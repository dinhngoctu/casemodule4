package app.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subject", schema = "case4", catalog = "")
public class SubjectEntity {
    private String subjectName;
    private List<QuizEntity> quizzesBySubjectName;

    public SubjectEntity() {
    }
    public SubjectEntity(String subjectName) {
        this.subjectName = subjectName;
    }

    @Id
    @Column(name = "subjectName")
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName);
    }

    @OneToMany(mappedBy = "subjectBySubjectName")
    public List<QuizEntity> getQuizzesBySubjectName() {
        return quizzesBySubjectName;
    }

    public void setQuizzesBySubjectName(List<QuizEntity> quizzesBySubjectName) {
        this.quizzesBySubjectName = quizzesBySubjectName;
    }
}
