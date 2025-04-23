package h2.database.h2_crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import h2.database.h2_crud.model.model;
import h2.database.h2_crud.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class controller {

    @Autowired
    service service_;

    @PostMapping("/add-user")
    public String add_user(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String contact_no, @RequestParam String province) {
        model model_ = new model();
        model_.setName(name);
        model_.setEmail(email);
        model_.setPassword(password);
        model_.setContact_no(contact_no);
        model_.setProvince(province);

        if(service_.addUserProfile(model_)){
            return "User profile has been created";
        }

        return "Error while creating user profile";

        
    }

    @GetMapping("/get-all-user")
    public List<model> get_all_profile(){
        List<model> all_profile = service_.getAllProfile();
        return all_profile;
    }
    
    @GetMapping("/get-user-by-name")
    public Optional<model> fetchUserByName(@RequestParam String name){
        return service_.getUserByName(name);
    }

    @PutMapping("/update-user")
    public String updateUser(@RequestParam String name, @RequestParam String email){
        return service_.updateUser(name, email);
    }

    @DeleteMapping("/delete-user")
    public String removeUser(@RequestParam String name){
        return service_.deleteUserByName(name);
    }
    
}
