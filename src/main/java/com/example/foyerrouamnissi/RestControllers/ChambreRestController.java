package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.Services.Bloc.IBlocService;
import com.example.foyerrouamnissi.Services.Chambre.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("update")
    Chambre update( @RequestBody Chambre b){
     return iChambreService.addChambre(b);
    }

    @DeleteMapping("/delete/{id}")
    void deleteChambre(@PathVariable("id") Long id){
        iChambreService.deleteById(id);
    }

    @GetMapping("/{id}")
    Chambre findById(@PathVariable("id") Long id){
        return iChambreService.findById(id);
    }




}
