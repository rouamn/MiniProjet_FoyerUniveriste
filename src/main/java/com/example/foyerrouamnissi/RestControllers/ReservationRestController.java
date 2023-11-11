package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.Reservation;
import com.example.foyerrouamnissi.Services.Foyer.IFoyerService;
import com.example.foyerrouamnissi.Services.Reservation.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
 class ReservationRestController {
    IReservationService iReservationService;

    @GetMapping("/findAll")
    List<Reservation> findAll(){
        return iReservationService.findAll();
    }
    @PostMapping("/add")
    Reservation add(@RequestBody Reservation b){
        return iReservationService.addReservation(b);
    }

    @PutMapping("update")
    Reservation update(@RequestBody Reservation b){
        return iReservationService.editReservation( b);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id){
        iReservationService.deleteById(id);
    }

    @GetMapping("/{id}")
    Reservation findById(@PathVariable("id") Long id){
        return iReservationService.findById(id);
    }
}
