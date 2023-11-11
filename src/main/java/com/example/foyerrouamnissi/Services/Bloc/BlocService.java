package com.example.foyerrouamnissi.Services.Bloc;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    BlocRepository  blocRepository ;

    @Override
    public Bloc addBloc(Bloc b) {
     return    blocRepository.save(b);
    }

    @Override
    public List<Bloc> addBlocs(List<Bloc> b) {
       return  blocRepository.saveAll(b);//on ajoute des lignes dans la bd

    }

    @Override
    public Bloc editBloc(Bloc b) {
       return blocRepository.save(b); // pour faire la edit
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(long id) {
        return blocRepository.findById(id).get();
        //objet ou objet vide+novalue present
        //oubien
        //return blocRepository.findById(id).orElse(Bloc.builder().idBloc(0).nomBloc("pas de bloc").build());

    }

    @Override
    public void deleteById(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public void delete(Bloc b) {
        blocRepository.delete(b);
    }


}
