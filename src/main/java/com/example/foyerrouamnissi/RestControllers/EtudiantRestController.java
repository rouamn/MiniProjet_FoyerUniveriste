package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.Services.Etudiant.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    @Autowired
    IEtudiantService iEtudiantService;

    @PostMapping("/addEtudiant")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/updateEtudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/getAllEtudiants")
    List<Etudiant> getAllEtudiants() {
        return iEtudiantService.getAllEtudiants();
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    void deleteEtudiant(@PathVariable Integer id) {
        iEtudiantService.deleteEtudiant(id);
    }
}
