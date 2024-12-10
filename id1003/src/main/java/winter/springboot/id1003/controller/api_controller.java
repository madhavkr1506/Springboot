package winter.springboot.id1003.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import winter.springboot.id1003.service.api_service;

@RestController
@RequestMapping("/stocks")
public class api_controller {

    @Autowired
    api_service service;
    
    @GetMapping("/get")
    public String stockDetails(){
        service.getDetails();
        return "Data fetch and stored successfully";
    }
    
}
