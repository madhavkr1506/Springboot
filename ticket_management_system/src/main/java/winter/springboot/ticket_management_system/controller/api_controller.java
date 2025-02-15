package winter.springboot.ticket_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import winter.springboot.ticket_management_system.model.City;
import winter.springboot.ticket_management_system.model.Theater;
import winter.springboot.ticket_management_system.service.api_service;

@RestController
@RequestMapping("/ticket")
public class api_controller {

    @Autowired
    private api_service service;

    @PostMapping("/post")
    public String saveDetails(){
        City city = new City();
        city.setName("Mumbai");
        Theater theater = new Theater();
        theater.setCity(city);
        theater.setName("INOX");
        return service.insertDetails(city,theater);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteRecord(@PathVariable Long id){
        return service.deleteById(id);
    }
    
}
