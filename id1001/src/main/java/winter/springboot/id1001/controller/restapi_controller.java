package winter.springboot.id1001.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi/")
public class restapi_controller {

    @GetMapping("/name")
    public String getRequest(){
        return "Madhav Kumar";
    }
    
}
