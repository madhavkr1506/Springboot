package winter.springboot.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import winter.springboot.employee_management_system.model.Department;
import winter.springboot.employee_management_system.service.department_service;

@RestController
@RequestMapping("/department")
public class department_controller {

    @Autowired
    private department_service service;

    @PostMapping("/post")
    public String insertDepartment(){
        Department department = new Department();
        department.setDepartment("Engineering");
        department.setDepartmentHead("Madhav");
        department.setTotalRevenue("1 LAKH CRORE");

        return service.insertDetails(department);
    }
    

    @GetMapping("/get")
    public List<Department> getDetails(){
        return service.fetchAllDetails();
    }

    @GetMapping("/getbyid")
    public Department findById(@RequestParam Long id){
        return service.findDepartmentById(id);
    }

    @PutMapping("/update")
    public Department updateDepartmentHead(@RequestParam Long id, @RequestBody String newHead){
        return service.updateDepartmentHead(id, newHead);
    }
}
