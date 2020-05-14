package app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "correct_answer", schema = "case4")
public class CorrectAnswerEntity {
    private long id;
    private String result;

    public CorrectAnswerEntity() {
    }
    public CorrectAnswerEntity(String result) {
        this.result = result;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name="result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectAnswerEntity that = (CorrectAnswerEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    public static void main(String[] args) {
//        System.out.println(String.valueOf(2l));
//    }

}
