package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Universite;
import com.example.foyerrouamnissi.Services.Bloc.IBlocService;
import com.example.foyerrouamnissi.Services.Chambre.IChambreService;
import com.example.foyerrouamnissi.Services.Foyer.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerRestController {
    IFoyerService iFoyerService;
    IBlocService iBlocService;

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
    //by zeineb
    @GetMapping("/{idBloc}/foyer")
    public Foyer getFoyerByBlocId(@PathVariable Long idBloc) {
        Foyer foyer = iBlocService.getFoyerByBlocId(idBloc);
        return foyer;
    }
}