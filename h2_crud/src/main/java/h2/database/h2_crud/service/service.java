package h2.database.h2_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import h2.database.h2_crud.model.model;
import h2.database.h2_crud.repository.h2_repository;
import jakarta.transaction.Transactional;

@Service
public class service {

    @Autowired
    h2_repository repository;

    public boolean addUserProfile(model profile){
        repository.save(profile);
        return true;
    }
    
    public List<model> getAllProfile(){
        return repository.findAll();
    }

    @Transactional
    public Optional<model> getUserByName(String name){
        return repository.findUserByName(name);
    }

    public String updateUser(String name, String email){
        Optional<model> user = repository.findUserByName(name);
        if(user.isPresent()){
            model existingUser = user.get();
            existingUser.setEmail(email);
            repository.save(existingUser);
            return "User email has been updated successfully";
        }
        else{
            return "User not found";
        }
    }

    @Transactional
    public String deleteUserByName(String name){
        repository.deleteByName(name);
        return "User deleted successfully";
    }
}
