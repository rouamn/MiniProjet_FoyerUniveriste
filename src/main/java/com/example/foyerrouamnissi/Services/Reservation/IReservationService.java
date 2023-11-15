package com.example.foyerrouamnissi.Services.Reservation;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation b);
    List<Reservation> addReservations(List<Reservation> reservations);
    Reservation editReservation(String id,Reservation b);
    List<Reservation> findAll();
    Reservation findById(String id);
    void deleteById(String id);
    void delete(Reservation b);

    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Long numChambre, Long cin) ;

}
