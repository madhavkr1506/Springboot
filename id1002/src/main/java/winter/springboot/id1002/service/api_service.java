package winter.springboot.id1002.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winter.springboot.id1002.model.entity_class;
import winter.springboot.id1002.repository.perform_sql_operation;

@Service
public class api_service {
    @Autowired
    private perform_sql_operation sql_operation;
    // public void setSql_operation(perform_sql_operation sql_operation){
    //     this.sql_operation = sql_operation;
    // }

    public List<entity_class> getAllEmployee(){
        return sql_operation.findAll();
    }

    public void saveDetails(entity_class entity){
        sql_operation.save(entity);
    }

    public Optional<entity_class> findbyId_(Long id){
        return sql_operation.findById(id);
    } 



}
