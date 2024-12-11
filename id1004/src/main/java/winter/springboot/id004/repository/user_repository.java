package winter.springboot.id004.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import winter.springboot.id004.model.entity_class;

public interface user_repository extends JpaRepository<entity_class,Long>{

}
