package winter.springboot.ticket_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winter.springboot.ticket_management_system.model.City;
import winter.springboot.ticket_management_system.model.Theater;
import winter.springboot.ticket_management_system.repositories.city_repository;
import winter.springboot.ticket_management_system.repositories.theaters_repository;

@Service
public class api_service {
    
    @Autowired
    private city_repository city_repo;

    @Autowired
    private theaters_repository theater_repo;

    public String insertDetails(City city, Theater theater){
        city_repo.save(city);
        theater_repo.save(theater);
        return "Data Saved Successfully";
    }

    public String deleteById(Long id){
        city_repo.deleteById(id);
        return "Deleted Successfully";
    }

}
