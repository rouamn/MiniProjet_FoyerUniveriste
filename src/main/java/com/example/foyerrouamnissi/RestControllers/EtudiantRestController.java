package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.Services.Etudiant.IEtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantRestController {
    private final IEtudiantService iEtudiantService;

    public EtudiantRestController(IEtudiantService iEtudiantService) {
        this.iEtudiantService = iEtudiantService;
    }

    @GetMapping("/findAll")
    public List<Etudiant> findAll() {
        return iEtudiantService.findAll();
    }
    @PutMapping("update")
    Etudiant update(@RequestBody Etudiant b){
        return iEtudiantService.editEtudiant( b);
    }
    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantService.addEtudiant(etudiant);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable long id) {
        iEtudiantService.deleteById(id);
    }
}