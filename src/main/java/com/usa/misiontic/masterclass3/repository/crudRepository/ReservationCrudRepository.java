package com.usa.misiontic.masterclass3.repository.crudRepository;

import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.Tool;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>
//public List<Reservation>findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
{
}


