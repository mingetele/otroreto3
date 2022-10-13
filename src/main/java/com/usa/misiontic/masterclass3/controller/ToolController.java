package com.usa.misiontic.masterclass3.controller;


import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.Tool;
import com.usa.misiontic.masterclass3.service.ReservationService;
import com.usa.misiontic.masterclass3.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tool")
public class ToolController {


    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getAll(){
        return toolService.getAll();
    }

    @PostMapping("/save")
    public Tool save(@RequestBody Tool p){
        return toolService.save(p);
    }
}
