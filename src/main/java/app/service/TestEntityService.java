package app.service;

import app.model.TestEntity;
import app.repository.repoInterface.ITestEntityRepo;
import app.service.serviceInterface.ITestEntityService;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;
import java.util.Optional;

public class TestEntityService implements ITestEntityService {
    @Autowired
    ITestEntityRepo testEntityRepo;

    @Override
    public List<TestEntity> findAll() {
        return (List<TestEntity>) testEntityRepo.findAll();
    }

    @Override
    public void add(TestEntity testEntity) {
        testEntityRepo.save(testEntity);
    }
    @Override
    public TestEntity findOne(Long id) {
       Optional<TestEntity> optionalTestEntity = testEntityRepo.findById(id);
        return optionalTestEntity.get();
    }
}
