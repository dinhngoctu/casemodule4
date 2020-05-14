package app.service.serviceInterface;

import app.model.TestEntity;

import java.util.List;
import java.util.Optional;

public interface ITestEntityService {
    public List<TestEntity> findAll();

    public void add(TestEntity testEntity);

    public TestEntity findOne(Long id);
}
