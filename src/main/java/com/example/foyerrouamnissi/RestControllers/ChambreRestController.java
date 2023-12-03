package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.TypeChambre;
import com.example.foyerrouamnissi.DTO.ChambreTypeStatistics;
import com.example.foyerrouamnissi.Services.Bloc.IBlocService;
import com.example.foyerrouamnissi.Services.Chambre.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambre")
@AllArgsConstructor
@CrossOrigin("*")

public class ChambreRestController {

    IChambreService iChambreService;

    @GetMapping("/findAll")
    List<Chambre> findAll(){
        return iChambreService.findAll();
    }
    @PostMapping("/add")
    Chambre addChambre(@RequestBody Chambre b){
        return iChambreService.addChambre(b);
    }

    @PutMapping("/update")
    Chambre updateChambre(@RequestBody Chambre updatedChambre) {
        return iChambreService.updateChambre(updatedChambre);
    }
    @DeleteMapping("/delete/{id}")
    void deleteChambre(@PathVariable("id") Long id){
        iChambreService.deleteById(id);
    }

    @GetMapping("/{id}")
    Chambre findById(@PathVariable("id") Long id){
        return iChambreService.findById(id);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<String> createChambreWithBloc(@RequestBody Chambre chambre) {
        // Extract the necessary information from the chambre entity
        long numeroChambre = chambre.getNumeroChambre();
        TypeChambre typeC = chambre.getTypeC();
        long blocId = chambre.getBloc().getIdBloc();

        // Call the ChambreService to create the Chambre entity
        iChambreService.createChambreWithBloc(numeroChambre, typeC, blocId);

        return ResponseEntity.ok("Chambre created successfully.");
    }

    @GetMapping("/chambresParBloc/{nomBloc}")
    List<Chambre> getChambresParNomBloc(@PathVariable String nomBloc) {
        return iChambreService.getChambresParNomBloc(nomBloc);
    }

    @GetMapping("/nbChambreParTypeEtBloc")
    long nbChambreParTypeEtBloc(@RequestParam TypeChambre type, @RequestParam long idBloc) {
        return iChambreService.nbChambreParTypeEtBloc(type, idBloc);
    }



    @GetMapping("/chambresNonReserveParFoyerEtType")
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(@RequestParam String nomFoyer, @RequestParam TypeChambre type) {
        return iChambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer, type);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Chambre>> searchChambre(
            @RequestParam(required = false) Long numeroChambre,
            @RequestParam(required = false) TypeChambre typeC) {

        List<Chambre> result = iChambreService.findByNumeroChambreAndTypeC(numeroChambre, typeC);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/types")
    public ResponseEntity<List<ChambreTypeStatistics>> getChambreTypeStatistics() {
        List<ChambreTypeStatistics> statistics = iChambreService.getChambreTypeStatistics();
        return ResponseEntity.ok(statistics);
    }



}
