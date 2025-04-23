package h2.database.h2_crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import h2.database.h2_crud.model.model;


public interface h2_repository extends JpaRepository<model, Long> {
    Optional<model> findUserByName(String name);
    void deleteByName(String name);
}
