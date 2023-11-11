package com.example.foyerrouamnissi.Services.Bloc;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Repositories.BlocRepository;
import com.example.foyerrouamnissi.DAO.Repositories.ChambreRepository;
import com.example.foyerrouamnissi.DAO.Repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    BlocRepository  blocRepository ;
    ChambreRepository chambreRepository;
    FoyerRepository foyerRepository;

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

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        //Cascade
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        //creation ensembre vide pour stocker les instances de chambres
        Set<Chambre> chambres= new HashSet<>();
        for (long numC : numChambre){
            Chambre c = chambreRepository.findByNumeroChambre(numC);
            chambres.add(c);
            //affecter child (chambre) au parent (bloc)
            c.setBloc(bloc);
            //sauvegarde
            chambreRepository.save(c);
        }
        bloc.setChambres(chambres);
        //mise à jour et sauvegarde
        blocRepository.save(bloc);
        return bloc;
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        //Recuperation des entity by noms
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);
        //Set foyer to bloc
        bloc.setFoyer(foyer);
        //Set bloc to foyer
        Set<Bloc> blocs = foyer.getBlocs();
        blocs.add(bloc);
        foyer.setBlocs(blocs);
        //save to base
        blocRepository.save(bloc);
        foyerRepository.save(foyer);
        return bloc;
    }
    }



