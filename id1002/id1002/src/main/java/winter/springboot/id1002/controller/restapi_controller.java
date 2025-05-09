package winter.springboot.id1002.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import winter.springboot.id1002.model.entity_class;
import winter.springboot.id1002.service.api_service;

@RestController
@RequestMapping("/restapi")
public class restapi_controller {
    
    @Autowired
    private api_service service;
    // public void setApi_service(api_service service){
    //     this.service = service;
    // }
    @PostMapping("/add")
    public String addDetails(@RequestBody entity_class enity){
        service.saveDetails(enity);
        return "Details are added successfully";
    }

    @GetMapping("/get")
    public List<entity_class>  getAllDetails(){
        return service.getAllEmployee();
    }

    @GetMapping("/get/{id}")
    public  entity_class findbyId(@PathVariable Long id){
        Optional<entity_class> detail = service.findbyId_(id);
        System.out.println("ID: " + id);
        return detail.orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteId(@PathVariable Long id){
        service.deletebyId(id);
        return "Successfully deleted from database";
    }
}
