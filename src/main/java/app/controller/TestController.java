package app.controller;

import app.model.QuizEntity;
import app.model.TestEntity;
import app.service.serviceInterface.IAnswerService;
import app.service.serviceInterface.IQuizEntityService;
import app.service.serviceInterface.ITestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class TestController {
    @Autowired
    IAnswerService answerService;
    @Autowired
    ITestEntityService testEntityService;
    @Autowired
    IQuizEntityService quizEntityService;

    @GetMapping(value = "/createtest")
    public String getCreateTestView(Model model) {
        List<QuizEntity> listQuiz = quizEntityService.findAll();
//        System.out.println(listQuiz.get(0).getListAnswer().get(0));
        model.addAttribute("listQuiz", listQuiz);
        return "create_test";
    }

    @GetMapping(value = "/test/view/{id}")
    public String takeTest(@PathVariable(name = "id") String id, Model model) {
        TestEntity test = testEntityService.findOne(Long.valueOf(id));
        List<QuizEntity> list = test.getQuizEntities();
        System.out.println(list.size());
        Set<QuizEntity> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        System.out.println(list.size());
        Collections.shuffle(list);
        test.setQuizEntities(list);
//        System.out.println(quizEntityService.findOne(list.get(0).getId()).getAnswersById().size());
        model.addAttribute("test", test);
        return "take_test";
    }
}
