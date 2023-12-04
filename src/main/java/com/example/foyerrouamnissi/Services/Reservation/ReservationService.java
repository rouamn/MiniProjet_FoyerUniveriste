package com.example.foyerrouamnissi.Services.Reservation;

import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Entities.Reservation;
import com.example.foyerrouamnissi.DAO.Repositories.EtudiantRepository;
import com.example.foyerrouamnissi.DAO.Repositories.ReservationRepository;
import com.example.foyerrouamnissi.DAO.Repositories.ChambreRepository;
import com.example.foyerrouamnissi.DAO.Repositories.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

import java.time.LocalDate;
import java.time.Year;

import java.util.List;
@Service
public class ReservationService implements  IReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Reservation addReservation(Reservation b) {
        return reservationRepository.save(b);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation editReservation(String id, Reservation b) {
        if (reservationRepository.findById(id).isPresent()) {
            Reservation toUpdateReservation = reservationRepository.findById(id).get();
            //toUpdateReservation.setIdReservation(r.getIdReservation());
            toUpdateReservation.setAnneeUniversitaire(b.getAnneeUniversitaire());
            toUpdateReservation.setEstValide(b.isEstValide());
            toUpdateReservation.setEtudiants(b.getEtudiants());

            return reservationRepository.save(toUpdateReservation);
        }
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();

    }

    @Override
    public Reservation findById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void delete(Reservation b) {
        reservationRepository.delete(b);

    }

    @Override

    public void createReservationWithChambre(Date anneeUniversitaire, boolean estVrai, long chambreId) {


    }

    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Long numChambre, Long cin) {
        return null;
    }
}
