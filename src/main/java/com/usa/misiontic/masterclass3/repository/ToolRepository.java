package com.usa.misiontic.masterclass3.repository;

import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.Tool;
import com.usa.misiontic.masterclass3.repository.crudRepository.ToolCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToolRepository {


    @Autowired
    private ToolCrudRepository toolCrudRepository;

    public List<Tool> getAll(){
        return (List<Tool>) toolCrudRepository.findAll();
    }
    public Optional<Tool> getTool(int id){
        return toolCrudRepository.findById(id);
    }

    public Tool save(Tool p){
        return toolCrudRepository.save(p);
    }

    public void delete(Tool p){
        toolCrudRepository.delete(p);
    }
}
