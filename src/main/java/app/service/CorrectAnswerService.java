package app.service;

import app.model.CorrectAnswerEntity;
import app.repository.repoInterface.ICorrectRepo;
import app.service.serviceInterface.ICorrectAnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CorrectAnswerService implements ICorrectAnswerService {
    @Autowired
    ICorrectRepo correctRepo;

    @Override
    public void add(List<CorrectAnswerEntity> list) {
        correctRepo.saveAll(list);
    }

    @Override
    public List<String> findAll() {
       List<CorrectAnswerEntity> correctAnswerEntities = (List<CorrectAnswerEntity>) correctRepo.findAll();
       try {
           List<String> list = new ArrayList<>();
           for (CorrectAnswerEntity c : correctAnswerEntities
           ) {
               list.add(c.getResult());
           }
           return list;
       }catch (Exception e){
           return null;
       }
    }
}
