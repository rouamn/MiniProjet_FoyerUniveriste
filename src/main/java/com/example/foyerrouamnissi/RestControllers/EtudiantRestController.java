package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.AUTH.AuthenticationRequest;
import com.example.foyerrouamnissi.DAO.AUTH.AuthenticationResponse;
import com.example.foyerrouamnissi.DAO.AUTH.RegisterRequest;
import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.Services.Etudiant.IEtudiantService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/etudiants")
public class EtudiantRestController {
    @Autowired
    IEtudiantService iEtudiantService;

    //Authentification
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRquest
    ){
        return ResponseEntity.ok(iEtudiantService.register(registerRquest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticateRequest
    ) {
        return ResponseEntity.ok(iEtudiantService.authenticate(authenticateRequest));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        iEtudiantService.refreshToken(request, response);
    }

    @GetMapping("/findAll")
    public List<Etudiant> findAll() {

        return iEtudiantService.findAll();
    }
    @PutMapping("update")
    Etudiant update(@PathVariable("id") int id,@RequestBody Etudiant b){

        return iEtudiantService.editEtudiant(id, b);
    }
    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {

        return iEtudiantService.addEtudiant(etudiant);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable("id") int id) {
        iEtudiantService.deleteById(id);
    }
}