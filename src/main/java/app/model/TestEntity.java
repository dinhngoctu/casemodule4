package app.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "test", schema = "case4", catalog = "")
public class TestEntity {
    private long id;
    private String testName;
    private Integer time;
    private String className;
    private List<QuizEntity> quizEntities;

    public TestEntity() {
    }

    public TestEntity(String testName, Integer time, String className,List<QuizEntity> quizEntities) {
        this.testName = testName;
        this.time = time;
        this.className = className;
        this.quizEntities = quizEntities;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "testName")
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Basic
    @Column(name = "time")
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }


    @Basic
    @Column(name = "className")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "quiz_test",joinColumns = @JoinColumn(name = "testId"),inverseJoinColumns = @JoinColumn(name="quizId"))
    public List<QuizEntity> getQuizEntities() {
        return quizEntities;
    }

    public void setQuizEntities(List<QuizEntity> quizEntities) {
        this.quizEntities = quizEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return id == that.id &&
                Objects.equals(testName, that.testName) &&
                Objects.equals(time, that.time) &&
                Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testName, time, className);
    }
}
