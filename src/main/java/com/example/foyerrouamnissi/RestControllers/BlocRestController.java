package com.example.foyerrouamnissi.RestControllers;


import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.Services.Bloc.IBlocService;
import com.example.foyerrouamnissi.Services.Chambre.ChambreService;
import com.example.foyerrouamnissi.Services.Chambre.IChambreService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("bloc")
@CrossOrigin("*")
@AllArgsConstructor
@RequiredArgsConstructor

@CrossOrigin("*")

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
        iBlocService.createBlocWithFoyer(capaciteBloc, nomBloc,idFoyer);

        return ResponseEntity.ok("Bloc created successfully.");
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

    @GetMapping("/search/byBlocName")
    public ResponseEntity<List<Bloc>> searchBlocsByBlocName(
            @RequestParam(required = false) String blocName
    ) {
        List<Bloc> blocs = iBlocService.searchBlocsByBlocName(blocName);
        return ResponseEntity.ok(blocs);
    }
    @GetMapping("/search/byIdFoyer")
    public ResponseEntity<List<Bloc>> searchBlocsByfoyer(
            @RequestParam(required = false) Long idfoyer
    ) {
        List<Bloc> blocs = iBlocService.searchBlocsByfoyer(idfoyer);
        return ResponseEntity.ok(blocs);
    }

    @GetMapping("/blocsbyfoyer/{nomFoyer}")
    List<Bloc> getBlocParNomFoyer(
            @PathVariable String nomFoyer) {
        return iBlocService.getBlocParNomFoyer(nomFoyer);
    }

    @GetMapping("/{idBloc}/chambres")
    public ResponseEntity<List<Chambre>> getChambresByBlocId(@PathVariable Long idBloc) {
        List<Chambre> chambres = iBlocService.getChambresByBlocId(idBloc);
        return ResponseEntity.ok(chambres);
    }

    @PutMapping("updateBlocAndAssignFoyer/{blocId}/{foyerId}")
    public ResponseEntity<Bloc> updateBlocAndAssignFoyer(
            @PathVariable("blocId") long blocId,
            @PathVariable("foyerId") long foyerId,
            @RequestBody Bloc updatedBloc
    ) {
        Bloc updatedBlocWithAssociation = iBlocService.updateBlocEtAffecterFoyerById(
                blocId,
                foyerId,
                updatedBloc
        );

        return ResponseEntity.ok(updatedBlocWithAssociation);
    }
}





