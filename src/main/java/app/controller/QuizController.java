package app.controller;

import app.model.SubjectEntity;
import app.service.serviceInterface.IQuizEntityService;
import app.service.serviceInterface.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class QuizController {
    @Autowired
    ISubjectService subjectService;
    @GetMapping("/createquiz")
    public String getCreateQuizView(Model model) {
        List<SubjectEntity> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        return "create_quiz";
    }
}
