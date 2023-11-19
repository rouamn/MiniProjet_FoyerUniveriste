package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Universite;
import com.example.foyerrouamnissi.Services.Chambre.IChambreService;
import com.example.foyerrouamnissi.Services.Foyer.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
@CrossOrigin("*")
public class FoyerRestController {
    IFoyerService iFoyerService;

    @GetMapping("/findAll")
    List<Foyer> findAll() {
        return iFoyerService.findAll();
    }

    @PostMapping("/add")
    Foyer add(@RequestBody Foyer b) {
        return iFoyerService.addFoyer(b);
    }

    @PutMapping("update")
    Foyer update(@RequestBody Foyer f){
        return iFoyerService.editFoyer( f);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id) {
        iFoyerService.deleteById(id);
    }

    @GetMapping("/{id}")
    Foyer findById(@PathVariable("id") Long id) {
        return iFoyerService.findById(id);
    }

    @PutMapping("/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,
                                                   @PathVariable("idUniversite") long idUniversite) {
        return iFoyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
    @GetMapping("/searchFoyer")
    public List<Foyer> searchFoyers(@RequestParam(required = false) String nom,

                                    @RequestParam(required = false) Integer capacite) {
        return iFoyerService.searchFoyers(nom, capacite);
    }
    @GetMapping("/foyers/count")
    public int getFoyerCount() {
        return iFoyerService.getFoyerCount(); // Utilisez la méthode du service pour obtenir le nombre total de foyers
    }
}