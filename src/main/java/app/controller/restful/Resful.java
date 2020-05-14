package app.controller.restful;


import app.model.*;
import app.service.serviceInterface.IAnswerService;
import app.service.serviceInterface.ICorrectAnswerService;
import app.service.serviceInterface.IQuizEntityService;
import app.service.serviceInterface.ITestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = {"/api"})
public class Resful {
    @Autowired
    ITestEntityService testEntityService;
    @Autowired
    IQuizEntityService quizEntityService;
    @Autowired
    IAnswerService answerService;
    @Autowired
    ICorrectAnswerService correctAnswerService;

    @ResponseBody
    @PostMapping(value = "/quiz/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public QuizForm postQuizForm(@RequestBody QuizForm quizForm, UriComponentsBuilder ucBuilder) {
        Long idQuiz = quizEntityService.getMaxId();
        QuizEntity quizEntity = quizForm.getQuizEntity();
        System.out.println(idQuiz);
        quizEntity.setId(idQuiz);
        Long idAnswer = answerService.getMaxId();
        List<AnswerEntity> listAnswer = new ArrayList<>();
        quizEntityService.add(quizEntity);
        List<CorrectAnswerEntity> listCorrectAnswer = new ArrayList<>();
        for (int i = 0; i < quizForm.getAnswer().size(); i++) {
            for (int j = 0; j < quizForm.getCorrectAnswer().size(); j++) {
                if (Long.valueOf(quizForm.getCorrectAnswer().get(j)) == Long.valueOf(i)) {
//                    listCorrectAnswer.add(new CorrectAnswerEntity(new AnswerEntity(idAnswer+i,quizEntity,quizForm.getAnswer().get(i)),quizEntity));
                    listCorrectAnswer.add(new CorrectAnswerEntity(String.valueOf(idQuiz)+"_"+String.valueOf(idAnswer+i)));
                }
            }
            listAnswer.add(new AnswerEntity(idAnswer+i,quizEntity,quizForm.getAnswer().get(i)));
        }
        answerService.add(listAnswer);
        correctAnswerService.add(listCorrectAnswer);
        return quizForm;
    }

    @ResponseBody
    @PostMapping(value = "/test/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TestForm postTest(@RequestBody TestForm test) {
        List<String> idQuiz = test.getListQuiz();
        List<QuizEntity> listQuiz = new ArrayList<>();
        for (String q : idQuiz
        ) {
            listQuiz.add(quizEntityService.findOne(Long.valueOf(q)));
        }
        TestEntity testEntity = new TestEntity(test.getTestName(), test.getTime(), test.getClassName(), listQuiz);
        testEntityService.add(testEntity);
        return test;
    }
    @ResponseBody
    @PostMapping(value = "/test/finish", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postTest(@RequestBody QuizForm quizForm) {
        List<String> correctAnswerEntities = correctAnswerService.findAll();
        float i = 0;
        for (String s : quizForm.getCorrectAnswer()
        ) {
            if (correctAnswerEntities.contains(s)) {
                i=i+1;
            }
        }
        System.out.println(i);
        return String.valueOf(i*10/quizForm.getCorrectAnswer().size());
    }

}
