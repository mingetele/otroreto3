package com.usa.misiontic.masterclass3.service;

import com.usa.misiontic.masterclass3.entities.*;
import com.usa.misiontic.masterclass3.repository.ClientRepository;
import com.usa.misiontic.masterclass3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ClientRepository clientRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation p) {
        if (p.getIdReservation() == null) {
            return reservationRepository.save(p);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(p.getIdReservation());
            if (e.isPresent()) {
                return p;
            } else {
                return reservationRepository.save(p);
            }
        }

    }
    public Reservation update(Reservation p) {
        if (p.getIdReservation() != null) {
            Optional<Reservation> q = reservationRepository.getReservation(p.getIdReservation());
            if (q.isPresent()) {
                if (p.getStartDate() != null) {
                    q.get().setStartDate((p.getStartDate()));
                }
                if (p.getDevolutionDate() != null) {
                    q.get().setDevolutionDate((p.getDevolutionDate()));
                }
                if (p.getStatus() != null) {
                    q.get().setStatus((p.getStatus()));
                }



                reservationRepository.save(q.get());
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
        Optional<Reservation>p= reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

    public Status getStatus() {
        Status status = new Status();
        List<Reservation> reservations = reservationRepository.getAll();
        int contF = 0;
        int contC = 0;
        for (Reservation res : reservations) {
            if (res.getStatus().equals("completed")) {
                contF = contF + 1;

            } else if (res.getStatus().equals("cancelled")) {
                contC = contC + 1;
            }

        }
        status.setCompleted(contF);
        status.setCancelled(contC);
        return status;
    }

    public List<ReportClient> getReportClient() {
        List<ReportClient> repoclient=new ArrayList<ReportClient>();
        List<Client> clients=clientRepository.getAll();
        int total=0;
        for(Client cli:clients){
            for(Reservation res:cli.getReservations()){
                total=total+1;
            }
            ReportClient reportclient= new ReportClient();
            reportclient.setTotal(total);
            reportclient.setClient(cli);
            repoclient.add(reportclient);
            total=0;
        }
        return repoclient;
    }

    public List<Reservation> getReportDates(Date date1, Date date2){
        List<Reservation> reservations= reservationRepository.getAll();
        List<Reservation> reservationsDate = new ArrayList<Reservation>();
        for(Reservation res:reservations){
            if(date1.compareTo(res.getStartDate()) * res.getStartDate().compareTo(date2) >= 0){
                reservationsDate.add(res);
            }
        }
        return reservationsDate;
    }

}
