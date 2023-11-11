package com.example.foyerrouamnissi.RestControllers;


import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.Services.Bloc.IBlocService;
import com.example.foyerrouamnissi.Services.Chambre.ChambreService;
import com.example.foyerrouamnissi.Services.Chambre.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("bloc")
@AllArgsConstructor

public class BlocRestController {
    @Autowired
    IBlocService iBlocService;

    IChambreService iChambreService;

    @GetMapping("/a")
    List<Bloc> findAll(){
        return iBlocService.findAll();
    }
    @PostMapping("/add")
    Bloc addBloc(@RequestBody Bloc b){
        return iBlocService.addBloc(b);
    }

    //@PutMapping("update/{id}")
    //Bloc updateBloc(@PathVariable("id") Long id, @RequestBody Bloc b){
    // return iBlocService.editBloc(id, b);
    //}

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




