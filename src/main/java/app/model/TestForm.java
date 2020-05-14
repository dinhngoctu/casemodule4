package app.model;

import app.service.serviceInterface.IQuizEntityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TestForm {

    private long id;
    private String testName;
    private Integer time;
    private String className;
    private List<String> listQuiz;

    public List<String> getListQuiz() {
        return listQuiz;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setListQuiz(List<String> listQuiz) {
        this.listQuiz = listQuiz;
    }
}
