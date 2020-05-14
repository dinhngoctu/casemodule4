package app.service;

import app.model.SubjectEntity;
import app.repository.repoInterface.ISubjectRepo;
import app.service.serviceInterface.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubjectService implements ISubjectService {
    @Autowired
    ISubjectRepo subjectRepo;

    @Override
    public List<SubjectEntity> findAll() {
        List<SubjectEntity> list = (List<SubjectEntity>) subjectRepo.findAll();
        return list;
    }
}
