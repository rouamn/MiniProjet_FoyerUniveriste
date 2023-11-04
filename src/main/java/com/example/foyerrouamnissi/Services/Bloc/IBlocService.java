package com.example.foyerrouamnissi.Services;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc b);
    List< Bloc > addBlocs (List<Bloc> b);
    Bloc editBloc(Bloc b);
    List<Bloc> findAll();
    Bloc findById(long id);
    void deleteById(long id);
    void delete(Bloc b);


}
