package winter.springboot.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import winter.springboot.employee_management_system.model.Employee;

@Repository
public interface employee_table extends JpaRepository<Employee, Long>{

}
