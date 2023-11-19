package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Entities.Reservation;
import com.example.foyerrouamnissi.DAO.Entities.Universite;
import com.example.foyerrouamnissi.Services.Reservation.IReservationService;
import com.example.foyerrouamnissi.Services.Universite.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universite")
@AllArgsConstructor
@CrossOrigin("*")
public class UniversiteRestController {
    IUniversiteService iUniversiteService;

    @GetMapping("/findAll")
    List<Universite> findAll(){
        return iUniversiteService.findAll();
    }
    @PostMapping("/add")
    Universite add(@RequestBody Universite b){
        return iUniversiteService.addUniversite(b);
    }

    //@PutMapping("update/{id}")
    //Bloc updateBloc(@PathVariable("id") Long id, @RequestBody Bloc b){
    // return iBlocService.editBloc(id, b);
    //}

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id){
        iUniversiteService.deleteById(id);
    }

    @GetMapping("/{id}")

    Universite findById(@PathVariable("id") Long id){
        return iUniversiteService.findById(id);
    }

    @PutMapping("update")
    Universite update(@RequestBody Universite b){
        return iUniversiteService.editUniversite( b);
    }
    @PutMapping("/{idFoyer}/{nomUniversite}")
    Universite affecterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer,
                                        @PathVariable("nomUniversite") String nomUniversite){
        return  iUniversiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }
    @PutMapping("/{idUniversite}")
    Universite desaffecterFoyerAUniversite(@PathVariable("idUniversite") long idUniversite){
        return  iUniversiteService.desaffecterFoyerAUniversite(idUniversite);
    }

}
