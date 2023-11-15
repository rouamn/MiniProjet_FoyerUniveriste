package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String > {
    // 1- Recherche des réservations validées
    //List<Reservation> findByEstValideTrue();

    // 2- Recherche des réservations par l'id de l'étudiant
    //List<Reservation> findByEtudiantsIdEtudiant(long idEtudiant);

    // 3- Recherche des réservations par année et validité
    //List<Reservation> findByAnneeUniversitaireAndEstValide(LocalDate anneeUniversitaire, boolean estValide);
    Reservation findByIdReservation(String id);
    // 1- Recherche des réservations validées
    List<Reservation> findByEstValideTrue();

    // 2- Recherche des réservations par l'id de l'étudiant
    List<Reservation> findByEtudiantsIdEtudiant(long idEtudiant);

    // 3- Recherche des réservations par année et validité
    List<Reservation> findByAnneeUniversitaireAndEstValide(LocalDate anneeUniversitaire, boolean estValide);



}
