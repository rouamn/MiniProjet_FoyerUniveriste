package com.example.foyerrouamnissi.Services.Chambre;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.TypeChambre;

import java.util.List;

public interface IChambreService {
  Chambre addChambre(Chambre b);
    List<Chambre> addChambre(List<Chambre> b);
    Chambre editChambre(Chambre b);
    List<Chambre> findAll();
    Chambre findById(long id);
    void deleteById(long id);
    void delete(Chambre b);
  public void createChambreWithBloc(long numeroChambre, TypeChambre typeC, long blocId);
  List<Chambre> getChambresParNomBloc(String nomBloc);
  long nbChambreParTypeEtBloc(TypeChambre type, long idBloc);

  List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type);




}
