package winter.springboot.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winter.springboot.employee_management_system.model.Employee;
import winter.springboot.employee_management_system.repository.employee_table;

@Service
public class employee_service {

    @Autowired
    private employee_table employee;


    public String insertDetails(Employee newEmployee){
        employee.save(newEmployee);
        return "New Employee Added Successfully";
    }

    public List<Employee> fetchAllDetails() {
        return employee.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employee.findById(id).orElseThrow(() -> new RuntimeException("Employee id is not available in Employee database."));
    }

    public Employee updateEmployeeSalary(Long id, double newSalary){
        Employee employeeUpdate = findEmployeeById(id);
        employeeUpdate.setSalary(newSalary);
        return employee.save(employeeUpdate);
    }

    public Employee updateEmployeeDepartment(Long id, String newDepartment){
        Employee employeeUpdate = findEmployeeById(id);
        employeeUpdate.setDepartment(newDepartment);
        return employee.save(employeeUpdate);
    }

    public Employee deletEmployeeById(Long id){
        Employee employeeToBeRemoved = findEmployeeById(id);
        employee.delete(employeeToBeRemoved);

        return employeeToBeRemoved;
    }
    
}
