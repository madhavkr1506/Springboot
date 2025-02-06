package winter.springboot.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import winter.springboot.employee_management_system.model.Employee;
import winter.springboot.employee_management_system.service.employee_service;

@RestController
@RequestMapping("/employee")
public class employee_controller {

    @Autowired
    private employee_service service;

    // @PostMapping("/post")
    // public String postEmployee(){
    //     Employee employee = new Employee();
    //     // employee.setId(12213356L);
    //     employee.setName("Abhinandan Kumar");
    //     employee.setDepartment("Application Development");
    //     employee.setSalary(560100.00);
    //     employee.setJoiningYear("2025");

    //     return service.insertDetails(employee);
    // } 

    @PostMapping("/post")
    public String postEmployee(@RequestBody Employee employee){
        System.out.println("Received Data" + employee);
        return service.insertDetails(employee);
        
    }


    @GetMapping("/get")
    public List<Employee> getAllEmployee(){
        return service.fetchAllDetails();
    }
    

    @GetMapping("/get/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        return service.findEmployeeById(id);
    }


    @PutMapping("/update")
    public Employee updateEmployeeSalary(@RequestParam Long id, @RequestBody JsonNode body){
        double doubleSalary = body.get("salary").asDouble();
        return service.updateEmployeeSalary(id, doubleSalary);
    }

    
}
