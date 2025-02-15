package winter.springboot.ticket_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import winter.springboot.ticket_management_system.model.Theater;

@Repository
public interface theaters_repository extends JpaRepository<Theater, Long> {

}
