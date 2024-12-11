package winter.springboot.id004.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import winter.springboot.id004.model.entity_class;
import winter.springboot.id004.service.api_service;

@Controller
@RequestMapping("/sentenceanalysis/")
public class api_controller {

    @Autowired
    private api_service service;
    
    @GetMapping("/getwebpage")
    public String displayWebPage(){
        return "loginpage";
    }

    @PostMapping("/savedetails")
    public String getDetails(@ModelAttribute entity_class entity){
        service.manageDatabase(entity);
        return "inputsentence";
    }
}
