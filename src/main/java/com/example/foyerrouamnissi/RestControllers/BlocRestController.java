package com.example.foyerrouamnissi.RestControllers;


import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.Services.Bloc.IBlocService;
import com.example.foyerrouamnissi.Services.Chambre.IChambreService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bloc")
@CrossOrigin("*")
@AllArgsConstructor
@RequiredArgsConstructor

public class BlocRestController {
    @Autowired
    IBlocService iBlocService;

    IChambreService iChambreService;

    @GetMapping("/a")
    List<Bloc> findAll(){
        return iBlocService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> createBlocWithFoyer(@RequestBody Bloc bloc) {
        // Extract the necessary information from the Bloc entit
        long capaciteBloc = bloc.getCapaciteBloc();
        String nomBloc = bloc.getNomBloc();
        long idFoyer = bloc.getFoyer().getIdFoyer();
        // Call the ChambreService to create the Chambre entity
        iBlocService.createBlocWithFoyer(capaciteBloc, nomBloc, idFoyer);

        return ResponseEntity.ok("Bloc created successfully.");
    }


    @GetMapping("/blocsbyfoyer/{nomFoyer}")
    List<Bloc> getBlocParNomFoyer(@PathVariable String nomFoyer) {
        return iBlocService.getBlocParNomFoyer(nomFoyer);
    }


    @DeleteMapping("/delete/{id}")
    void deleteBloc(@PathVariable("id") Long id){
        iBlocService.deleteById(id);
    }

    @GetMapping("/{id}")
    Bloc findById(@PathVariable("id") Long id){
        return iBlocService.findById(id);
    }

            @PutMapping("affecterBlocAFoyer/{nomBloc}/{nomFoyer}")
    Bloc affecterBlocAFoyer(@PathVariable("nomBloc") String nomBloc,
                            @PathVariable("nomFoyer") String nomFoyer){
        return iBlocService.affecterBlocAFoyer(nomBloc,nomFoyer);
    }
    @PutMapping("affectuerChambresABloc/{nomBloc}")
    Bloc affecterChambresABloc(@PathVariable("nomBloc") String nomBloc,
                               @RequestBody List<Long> numChambre){
        return iBlocService.affecterChambresABloc(numChambre,nomBloc);
    }

    @PutMapping("update")
    Bloc update(@RequestBody Bloc b){
        return iBlocService.editBloc(b);
    }

   /* @PostMapping("/ajouter")
    public ResponseEntity<String> createBlocWithchambres(@RequestBody Bloc bloc) {
        Set<Chambre> chambres = bloc.getChambres();
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        iBlocService.addBloc(bloc);
        return ResponseEntity.ok("Bloc with chambres created successfully.");
    }

    @DeleteMapping("/blocChambres/{id}")
    public ResponseEntity<String> deleteBlocWithChambres(@PathVariable("id") long id) {
        Optional<Bloc> optionalBloc = Optional.ofNullable(iBlocService.findById(id));
        if (!optionalBloc.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Bloc bloc = optionalBloc.get();

        Set<Chambre> chambres = bloc.getChambres();
        for (Chambre chambre : chambres) {
            iChambreService.delete(chambre);
        }

        iBlocService.delete(bloc);

        return ResponseEntity.ok("Bloc and its associated chambres have been deleted.");
    }*/
}