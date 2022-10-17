package com.usa.misiontic.masterclass3.repository.crudRepository;

import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.Tool;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();
    public List<Reservation> findAllByStatus(String status);
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
}


