package com.usa.misiontic.masterclass3.repository.crudRepository;

import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.Tool;
import org.springframework.data.repository.CrudRepository;

public interface ToolCrudRepository extends CrudRepository<Tool, Integer> {
}
