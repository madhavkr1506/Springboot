package winter.springboot.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winter.springboot.employee_management_system.model.Department;
import winter.springboot.employee_management_system.repository.department_table;

@Service
public class department_service {
    @Autowired
    private department_table department;

    public String insertDetails(Department newDepartment){
        department.save(newDepartment);
        return "New Department Added Successfully";
    }

    public List<Department> fetchAllDetails() {
        return department.findAll();
    }

    public Department findDepartmentById(Long id){
        return department.findById(id).orElseThrow(() -> new RuntimeException("Department id is not available in Department database."));
    }

    public Department updateDepartmentRevenue(Long id, String newRevenue){
        Department departmentUpdate = findDepartmentById(id);
        departmentUpdate.setTotalRevenue(newRevenue);
        return department.save(departmentUpdate);
    }

    public Department updateDepartmentHead(Long id, String newHead){
        Department departmentUpdate = findDepartmentById(id);
        departmentUpdate.setDepartmentHead(newHead);
        return department.save(departmentUpdate);
    }

    public Department deletDepartmentById(Long id){
        Department departmentToBeRemoved = findDepartmentById(id);
        department.delete(departmentToBeRemoved);

        return departmentToBeRemoved;
    }

}
