package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Universite;
import com.example.foyerrouamnissi.Services.Bloc.IBlocService;

import com.example.foyerrouamnissi.DAO.Entities.*;
import com.example.foyerrouamnissi.Services.Chambre.IChambreService;
import com.example.foyerrouamnissi.Services.Foyer.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")

@RequestMapping("/foyer")
@AllArgsConstructor
@CrossOrigin("*")
public class FoyerRestController {
    IFoyerService iFoyerService;
    IBlocService iBlocService;

    @GetMapping("/findAll")
    List<Foyer> findAll() {
        return iFoyerService.findAll();
    }
    @GetMapping("/getAllFoyersWithUniversites")
    List<Foyer> getAllFoyersWithUniversites() {
        return iFoyerService.getAllFoyersWithUniversites();
    }
    @GetMapping("/findAllFoyersWithUniversiteAndBlocs")
    List<Foyer> findAllFoyersWithUniversiteAndBlocs() {
        return iFoyerService.findAllFoyersWithUniversiteAndBlocs();
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
 /*   @GetMapping("getFoyerAndUniversity/{idFoyer}")
    Foyer getFoyerAndUniversity(@PathVariable("idFoyer") Long id) {
        return iFoyerService.getFoyerAndUniversity(id);
    }
*/
 @PutMapping("/{universitName}")
 public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,
                                                @PathVariable("universitName") long idUniversite) {
     return iFoyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
 }

    @PutMapping("ajouterFoyerEtAffecterAUniversiteByname/{universiteName}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,
                                                   @PathVariable("universiteName") String universiteName) {
        return iFoyerService.ajouterFoyerEtAffecterAUniversiteByname(foyer, universiteName);
    }


        @DeleteMapping("/deleteFoyerAndDissociateUniversite/{idFoyer}")
        public void deleteFoyerAndDissociateUniversite(@PathVariable("idFoyer") Long idFoyer) {
            iFoyerService.supprimerFoyerEtDesaffecterUniversite(idFoyer);
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
    @PostMapping("/ajouter-et-affecter-bloc")
    public Foyer ajouterFoyerEtAffecterBlocAfoyerByname(@RequestBody Foyer foyer, @RequestParam String nomBloc) {
        Foyer updatedFoyer = iFoyerService.ajouterFoyerEtAffecterBlocAfoyerByname(foyer, nomBloc);
        return updatedFoyer;
    }
    @PostMapping("ajouterFoyerEtAffecterUniversiteEtBlocByname/{universiteNom}/{nomBloc}")
    public ResponseEntity<Foyer> ajouterFoyerEtAffecterUniversiteEtBlocByname(
            @RequestBody Foyer foyer,
            @PathVariable String universiteNom,
            @PathVariable String nomBloc
    ) {
        try {
            Foyer createdFoyer = iFoyerService.ajouterFoyerEtAffecterUniversiteEtBlocByname(foyer, universiteNom, nomBloc);
            return ResponseEntity.ok(createdFoyer);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping("updateFoyerAndAssignUniversite/{foyerId}/{universiteNom}")
    public ResponseEntity<Foyer> updateFoyerAndAssignUniversite(
            @PathVariable("foyerId") long foyerId,
            @PathVariable("universiteNom") String universiteNom,
            @RequestBody Foyer updatedFoyer
    ) {
        Foyer updatedFoyerWithAssociation = iFoyerService.updateFoyerEtAffecterUniversiteByname(
                foyerId,
                universiteNom,
                updatedFoyer
        );

        return ResponseEntity.ok(updatedFoyerWithAssociation);
    }



    @GetMapping("/statistics")
    public Map<String, long[]> getFoyerStatistics() {
        return iFoyerService.getFoyerStatistics();
    }




      @GetMapping("/search/byFoyerName")
    public ResponseEntity<List<Foyer>> searchFoyersByFoyerName(
            @RequestParam(required = false) String foyerName
    ) {
        List<Foyer> foyers = iFoyerService.searchFoyersByNameFoyer(foyerName);
        return ResponseEntity.ok(foyers);
    }

    @GetMapping("/search/byUniversite")
    public ResponseEntity<List<Foyer>> searchFoyersByUniversite(
            @RequestParam(required = false) String universityName
    ) {
        List<Foyer> foyers = iFoyerService.searchFoyersByNomUniversite(universityName);
        return ResponseEntity.ok(foyers);
    }
    //by zeineb
    @GetMapping("/{idBloc}/foyer")
    public Foyer getFoyerByBlocId(@PathVariable Long idBloc) {
        Foyer foyer = iBlocService.getFoyerByBlocId(idBloc);
        return foyer;
    }
}

  @GetMapping("/search/byBloc")
    public ResponseEntity<List<Foyer>> searchFoyersByBloc(
            @RequestParam(required = false) String bloc
    ) {
        List<Foyer> foyers = iFoyerService.searchFoyersByBloc(bloc);
        return ResponseEntity.ok(foyers);
    } }
