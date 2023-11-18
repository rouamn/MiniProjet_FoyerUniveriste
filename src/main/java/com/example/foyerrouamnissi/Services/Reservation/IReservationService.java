package com.example.foyerrouamnissi.Services.Reservation;

import com.example.foyerrouamnissi.DAO.Entities.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IReservationService {
    Reservation addReservation(Reservation b);
    List<Reservation> addReservation(List<Reservation> b);
    Reservation editReservation(Reservation b);
    List<Reservation> findAll();
    Reservation findById(long id);
    void deleteById(long id);
    void delete(Reservation b);
    public void createReservationWithChambre(Date anneeUniversitaire, boolean estVrai, long chambreId);


    }
