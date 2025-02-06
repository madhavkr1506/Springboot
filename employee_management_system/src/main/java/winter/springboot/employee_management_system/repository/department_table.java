package winter.springboot.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import winter.springboot.employee_management_system.model.Department;

@Repository
public interface department_table extends JpaRepository<Department, Long>{

}
