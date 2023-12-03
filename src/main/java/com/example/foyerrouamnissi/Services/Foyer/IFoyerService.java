package com.example.foyerrouamnissi.Services.Foyer;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;

import java.util.List;
import java.util.Map;

public interface IFoyerService {
    Foyer addFoyer(Foyer foyer);
    List<Foyer> addFoyer(List<Foyer> foyer);
    Foyer editFoyer(Foyer foyer);
    List<Foyer> findAll();
    Foyer findById(long id);
    void deleteById(long id);
    void delete(Foyer foyer);
    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
    List<Foyer> searchFoyers(String nom, Integer capacite);
     void  supprimerFoyerEtDesaffecterUniversite(long idFoyer);
    int getFoyerCount();
    //Foyer getFoyerAndUniversity(Long idFoyer);
    List<Foyer> getAllFoyersWithUniversites();
    List<Foyer> findAllFoyersWithUniversiteAndBlocs();
   // Foyer ajouterFoyerEtAffecterABlocEtUniversite(Foyer foyer, String universiteNom, String blocNom);
    Foyer ajouterFoyerEtAffecterAUniversiteByname(Foyer foyer, String universiteNom);
   // Foyer ajouterFoyerEtAffecterBlocAfoyerByname( String nomBloc);
   Foyer ajouterFoyerEtAffecterBlocAfoyerByname(Foyer foyer, String nomBloc);
    Foyer ajouterFoyerEtAffecterUniversiteEtBlocByname(Foyer foyer, String universiteNom, String nomBloc);
  //   Foyer updateFoyerEtAffecterUniversiteEtBlocByname(long foyerId, String universiteNom, String nomBloc,Foyer updatedFoye);
    Foyer updateFoyerEtAffecterUniversiteByname(long foyerId, String universiteNom, Foyer updatedFoyer);
    //List<Foyer> searchFoyersbynamefoyeranduniversite(String universityName, String foyerName);
    Map<String, long[]> getFoyerStatistics();
    List<Foyer> searchFoyersByNameFoyer(String foyerName);

    List<Foyer> searchFoyersByNomUniversite(String universityName);
    List<Foyer> searchFoyersByBloc(String bloc);
}
