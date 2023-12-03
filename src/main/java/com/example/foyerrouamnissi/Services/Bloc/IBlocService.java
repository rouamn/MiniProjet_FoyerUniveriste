package com.example.foyerrouamnissi.Services.Bloc;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;


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
    public void createBlocWithFoyer(long capaciteBloc, String nomBloc, long idFoyer);
    List<Bloc> getBlocParNomFoyer(String nomFoyer);


    List<Bloc> searchBlocsByBlocName(String nomBloc);


    List<Bloc> searchBlocsByfoyer(Long idFoyer);




    List<Chambre> getChambresByBlocId(Long idBloc);



    Foyer getFoyerByBlocId(Long idBloc);

    Bloc updateBlocEtAffecterFoyerById(long blocId, long foyerId, Bloc updatedBloc);


}
