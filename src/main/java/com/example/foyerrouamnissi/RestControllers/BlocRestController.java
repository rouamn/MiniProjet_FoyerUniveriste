package com.example.foyerrouamnissi.RestControllers;


import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.Services.Bloc.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("bloc")
@AllArgsConstructor

public class BlocRestController {
    @Autowired
    IBlocService iBlocService;

    @GetMapping("/findAll")
    List<Bloc> findAll(){
        return iBlocService.findAll();
    }
  @PostMapping("/add")
    Bloc addBloc(@RequestBody Bloc b){
        return iBlocService.addBloc(b);
    }

    @PutMapping("update")
    Bloc updateBloc( @RequestBody Bloc b){
       return iBlocService.editBloc( b);
    }

    @DeleteMapping("/delete/{id}")
    void deleteBloc(@PathVariable("id") Long id){
        iBlocService.deleteById(id);
    }

    @GetMapping("/{id}")
    Bloc findById(@PathVariable("id") Long id){
        return iBlocService.findById(id);
    }







}
