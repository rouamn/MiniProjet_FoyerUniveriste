package com.example.foyerrouamnissi.Services.Reservation;

import com.example.foyerrouamnissi.DAO.Entities.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IReservationService {
    Reservation addReservation(Reservation b);
    List<Reservation> addReservations(List<Reservation> reservations);
    Reservation editReservation(String id,Reservation b);
    List<Reservation> findAll();
    Reservation findById(String id);
    void deleteById(String id);
    void delete(Reservation b);
    public void createReservationWithChambre(Date anneeUniversitaire, boolean estVrai, long chambreId);





    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Long numChambre, Long cin) ;

}

