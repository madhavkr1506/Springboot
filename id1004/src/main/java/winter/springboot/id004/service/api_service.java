package winter.springboot.id004.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winter.springboot.id004.model.entity_class;
import winter.springboot.id004.repository.user_repository;

@Service
public class api_service {
    @Autowired
    private user_repository repository;

    public void manageDatabase(entity_class entity){
        repository.save(entity);
    }
}
