package com.example.foyerrouamnissi.Services.Bloc;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc b);
    List<Bloc> addBlocs (List<Bloc> b);
    Bloc editBloc(Bloc b);
    List<Bloc> findAll();
    Bloc findById(long id);
    void deleteById(long id);
    void delete(Bloc b);
    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) ; //bloc parent , chambres child
    Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer) ;

}
