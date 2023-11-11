package com.example.foyerrouamnissi.Services.Reservation;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation b);
    List<Reservation> addReservation(List<Reservation> b);
    Reservation editReservation(Reservation b);
    List<Reservation> findAll();
    Reservation findById(long id);
    void deleteById(long id);
    void delete(Reservation b);

}
