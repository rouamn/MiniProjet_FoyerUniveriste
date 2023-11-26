package com.example.foyerrouamnissi.Services.Etudiant;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Integer id);
}
