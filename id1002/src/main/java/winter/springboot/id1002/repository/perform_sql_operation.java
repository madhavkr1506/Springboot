package winter.springboot.id1002.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import winter.springboot.id1002.model.entity_class;

public interface perform_sql_operation extends JpaRepository<entity_class,Long> {
    
}
