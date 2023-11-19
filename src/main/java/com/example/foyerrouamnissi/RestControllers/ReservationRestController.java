package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Reservation;
import com.example.foyerrouamnissi.Services.Foyer.IFoyerService;
import com.example.foyerrouamnissi.Services.Reservation.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
@CrossOrigin("*")
 public class ReservationRestController {
    @Autowired
    IReservationService iReservationService;

    @GetMapping("/findAll")
    List<Reservation> findAll() {
        return iReservationService.findAll();
    }

    @PostMapping("/add")
    Reservation add(@RequestBody Reservation b) {
        return iReservationService.addReservation(b);
    }

    @PutMapping("update/{id}")
    Reservation updateReservation(@PathVariable("id") String id, @RequestBody Reservation b) {
        return iReservationService.editReservation(b);

        //Reservation update(@RequestBody Reservation b){
        //return iReservationService.editReservation( b);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") long id) {
        iReservationService.deleteById(id);
    }

    @GetMapping("/{id}")
    Reservation findById(@PathVariable("id") long id) {
        return iReservationService.findById(id);
    }

   /* @PostMapping("/ajouterReservationEtAssignerAChambreEtAEtudiant/{numChambre}/{cin}")
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(@PathVariable("numChambre") Long numChambre,
                                                                @PathVariable("cin") Long cin) {
        return iReservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(numChambre, cin);

    } */
}