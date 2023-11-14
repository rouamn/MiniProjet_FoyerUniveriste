package com.example.foyerrouamnissi.Services.Etudiant;

import com.example.foyerrouamnissi.DAO.AUTH.AuthenticationRequest;
import com.example.foyerrouamnissi.DAO.AUTH.AuthenticationResponse;
import com.example.foyerrouamnissi.DAO.AUTH.RegisterRequest;
import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant b);
    List< Etudiant> addEtudiants(List<Etudiant> b);
    Etudiant editEtudiant(int id,Etudiant b);
    List<Etudiant> findAll();
    Etudiant findById(int id);
    void deleteById(int id);
    void delete(Etudiant b);

    AuthenticationResponse register (RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
