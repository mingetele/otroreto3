package com.usa.misiontic.masterclass3.service;

import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.Tool;
import com.usa.misiontic.masterclass3.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll(){
        return toolRepository.getAll();
    }

    public Optional<Tool> getTool(int id){
        return toolRepository.getTool(id);
    }

    public Tool save(Tool p) {
        if (p.getId() == null) {
            return toolRepository.save(p);
        } else {
            Optional<Tool> e = toolRepository.getTool(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return toolRepository.save(p);
            }
        }

    }
    public Tool update(Tool p) {
        if (p.getId() != null) {
            Optional<Tool> q = toolRepository.getTool(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName((p.getName()));
                }
                if (p.getBrand() != null) {
                    q.get().setBrand((p.getBrand()));
                }
                if (p.getYear() != null) {
                    q.get().setYear((p.getYear()));
                }
                if (p.getDescription() != null) {
                    q.get().setDescription((p.getDescription()));
                }

                toolRepository.save(q.get());
                return q.get();
            } else {
                return p;
            }
        }else{
            return p;
        }

    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Tool>p= toolRepository.getTool(id);
        if(p.isPresent()){
            toolRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
