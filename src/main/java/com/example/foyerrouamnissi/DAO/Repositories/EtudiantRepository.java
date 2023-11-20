package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer > {
    Etudiant findByCin(Long cin);
    //1- Recherche par nom et prénom de l'étudiant
    //List<Etudiant> findByNomEtAndPrenomEt(String nom, String prenom);
    //2- Recherche par CIN de l'étudiant
    //Etudiant findByCin(long cin);
    //3- Recherche des étudiants par date de naissance après une certaine date
    //List<Etudiant> findByDateNaissanceAfter(Date date);
    //4- Recherche des étudiants par nom d'école
    //List<Etudiant> findByEcole(String nomEcole);
    //5- Recherche des étudiants par réservation (id de réservation)
    //List<Etudiant> findByReservationsIdReservation(String idReservation);
    //6- Recherche des étudiants par réservation (année de réservation)
    //List<Etudiant> findByReservationsAnnee(int annee);
    //7- Recherche des étudiants par nom d'école et date de naissance après une certaine date
    //List<Etudiant> findByEcoleAndDateNaissanceAfter(String nomEcole,Date date);
    //8- Recherche des étudiants par réservation pour une année donnée et triés par date de naissance
    //List<Etudiant> findByReservationsAnneeUniversitaireOrderByDateNaissance(Date annee);
}

