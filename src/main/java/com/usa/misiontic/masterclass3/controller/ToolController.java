package com.usa.misiontic.masterclass3.controller;


import com.usa.misiontic.masterclass3.entities.Category;
import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.Tool;
import com.usa.misiontic.masterclass3.service.ReservationService;
import com.usa.misiontic.masterclass3.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
@RequestMapping("/api/Tool")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ToolController {


    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getAll(){
        return toolService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Tool> getById(@PathVariable("id") int id){
        return toolService.getTool(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save(@RequestBody Tool p){
        return toolService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool update(@RequestBody Tool p){return toolService.update(p);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){return toolService.delete(id);}
}
