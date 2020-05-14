package app.service.serviceInterface;

import app.model.SubjectEntity;

import java.util.List;

public interface ISubjectService {
    List<SubjectEntity> findAll();
}
