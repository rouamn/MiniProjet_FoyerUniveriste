package com.example.foyerrouamnissi.Services.Foyer;


import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;

import com.example.foyerrouamnissi.DAO.Entities.Universite;
import com.example.foyerrouamnissi.DAO.Repositories.BlocRepository;
import com.example.foyerrouamnissi.DAO.Repositories.FoyerRepository;
import com.example.foyerrouamnissi.DAO.Repositories.UniversiteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {

    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;
    BlocRepository blocRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer); //on aj
    }

    @Override
    public List<Foyer> addFoyer(List<Foyer> foyer) {
        return foyerRepository.saveAll(foyer);
    }

    @Override
    public Foyer editFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);

    }

    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

  /*  @Override
    public Foyer findById(long id) {
        return foyerRepository.findById(id).get();
    }
*/
    @Override
    public void deleteById(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void delete(Foyer foyer) {
        foyerRepository.delete(foyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        //foyer child
        Universite u = universiteRepository.findById(idUniversite).get();
        u.setFoyer(foyer);
        universiteRepository.save(u);
        return foyer;
    }

    // hethi chne5dmo beha
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversiteByname(Foyer foyer, String universiteNom) {
        Universite universite = universiteRepository.findByNomUniversite(universiteNom);

        if (universite != null) {
            if (universite.getFoyer() != null) {
                throw new IllegalArgumentException("This university is already affected by another foyer.");
            }

            universite.setFoyer(foyer);
            universiteRepository.save(universite);

            // Set the universiteName property in the foyer
            foyer.setUniversiteName(universiteNom);
        } else {
            throw new NotFoundException("Universite not found with name: " + universiteNom);
        }

        return foyer;
    }
    @Override
    public Foyer ajouterFoyerEtAffecterUniversiteEtBlocByname(Foyer foyer, String universiteNom, String nomBloc) {
        Universite universite = universiteRepository.findByNomUniversite(universiteNom);
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);

        if (universite != null && bloc != null) {
            foyerRepository.save(foyer); // Save the foyer entity first

            universite.setFoyer(foyer);
            universiteRepository.save(universite);

            bloc.setFoyer(foyer);
            blocRepository.save(bloc);

            Set<Bloc> blocs = blocRepository.getBlocsByFoyer(foyer); // Retrieve existing blocs for the foyer
            blocs.add(bloc); // Add the new bloc to the set of blocs
        } else {
            if (universite == null) {
                throw new NotFoundException("Universite not found with name: " + universiteNom);
            } else {
                throw new NotFoundException("Bloc not found with name: " + nomBloc);
            }
        }

        return foyer;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterBlocAfoyerByname(Foyer foyer, String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);

        if (bloc != null) {
            foyerRepository.save(foyer); // Save the foyer entity first
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);

            Set<Bloc> blocs = blocRepository.getBlocsByFoyer(foyer); // Retrieve existing blocs for the foyer
            blocs.add(bloc); // Add the new bloc to the set of blocs
        } else {
            throw new NotFoundException("Bloc not found with name: " + nomBloc);
        }

        return foyer;
    }

    /*   @Override
       public Foyer ajouterFoyerEtAffecterBlocAfoyerByname(String nomBloc) {
           Foyer foyer = new Foyer();

           Bloc bloc = blocRepository.findByNomBloc(nomBloc);

           if (bloc != null) {
               foyer.setBloc(Collections.singleton(bloc));
               bloc.setFoyer(foyer);

               foyerRepository.save(foyer);
           } else {
               throw new NotFoundException("Bloc not found with name: " + nomBloc);
           }

           return foyer;
       }*/
    public List<Foyer> searchFoyers(String nom, Integer capacite) {
        return foyerRepository.findByNomFoyerContainingIgnoreCaseAndCapaciteFoyer(nom, capacite);
    }

    @Override
    public void supprimerFoyerEtDesaffecterUniversite(long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(() -> new NotFoundException("Foyer not found"));

        // Remove the association with Universite
        Universite universite = foyer.getUniversite();
        if (universite != null) {
            universite.setFoyer(null);
            universiteRepository.save(universite);
        }

        // Delete the Foyer
        foyerRepository.delete(foyer);
    }

    public int getFoyerCount() {
        return (int) foyerRepository.count();
    }

    @Override
    public List<Foyer> getAllFoyersWithUniversites() {

        return foyerRepository.findAll();
    }

    @Override

    public List<Foyer> findAllFoyersWithUniversiteAndBlocs() {
        List<Foyer> foyers = foyerRepository.findAllFoyersWithUniversiteAndBlocs();

        for (Foyer foyer : foyers) {
            Universite universite = foyer.getUniversite();
            if (universite != null) {
                String universiteName = universite.getNomUniversite();
                // Access other attributes of the Universite entity

                // Perform any necessary operations with the Universite entity

                // For example, you can set the universiteName in the Foyer entity
                foyer.setUniversiteName(universiteName);
            }
        }

        return foyers;
    }
//ajout
/*@Override
public Foyer ajouterFoyerEtAffecterABlocEtUniversite(Foyer foyer, String universiteNom, String blocNom) {
    Universite universite = universiteRepository.findByNomUniversite(universiteNom);
    Bloc bloc = blocRepository.findByNomBloc(blocNom);

    if (universite == null) {
        throw new NotFoundException("Universite not found with name: " + universiteNom);
    }

    if (bloc == null) {
        throw new NotFoundException("Bloc not found with name: " + blocNom);
    }

    foyer.setUniversite(universite);
    foyerRepository.save(foyer);

    foyer.getBlocs().add(bloc);
    bloc.setFoyer(foyer);
    blocRepository.save(bloc);

    return foyer;
}
*/

 /*   @Override
    public Foyer getFoyerAndUniversity(Long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        if (foyer != null) {
            Universite universite = universiteRepository.findByFoyerId(idFoyer);
            foyer.setUniversite(universite);
        }
        return foyer;
    }  */


    @Override
    public Foyer updateFoyerEtAffecterUniversiteByname(long foyerId, String universiteNom, Foyer updatedFoyer) {
        Foyer foyer = foyerRepository.findById(foyerId)
                .orElseThrow(() -> new NotFoundException("Foyer not found with ID: " + foyerId));

        Universite universite = universiteRepository.findByNomUniversite(universiteNom);

        if (universite != null) {
            if (universite.getFoyer() != null && !universite.getFoyer().equals(foyer)) {
                throw new IllegalArgumentException("This university is already affected by another foyer.");
            }

            universite.setFoyer(updatedFoyer);
            universiteRepository.save(universite);

            updatedFoyer.setUniversiteName(universite.getNomUniversite()); // Set universiteName from nomUniversite
        } else {
            throw new NotFoundException("Universite not found with name: " + universiteNom);
        }

        updatedFoyer.setIdFoyer(foyerId); // Set the ID of the updated foyer

        return foyerRepository.save(updatedFoyer);}

    public Foyer findById(long id) {
        Foyer foyer = foyerRepository.findById(id).orElse(null);
        if (foyer != null) {
            String universiteNom = universiteRepository.findNomUniversiteByFoyer(foyer);
            foyer.setUniversiteName(universiteNom);
        }
        return foyer;
    }


    public Map<String, long[]> getFoyerStatistics() {
        List<Foyer> foyers = foyerRepository.findAll();
        Map<String, long[]> statistics = new HashMap<>();

        for (Foyer foyer : foyers) {
            int numberOfBlocs = foyer.getBloc().size();
            long  capacity = foyer.getCapaciteFoyer();

            String statisticKey = "Foyer " + foyer.getIdFoyer();
            long[] statisticValue = new long []{+3266




                    , capacity};

            statistics.put(statisticKey, statisticValue);
        }

        return statistics;
    }
    public List<Foyer> searchFoyersByNameFoyer(String foyerName) {
        List<Foyer> foyers = foyerRepository.searchFoyersByFoyerName(foyerName);
        for (Foyer foyer : foyers) {
            Universite universite = foyer.getUniversite();
            if (universite != null) {
                String universiteNom = universite.getNomUniversite();
                foyer.setUniversiteName(universiteNom);
            }
        }
        return foyers;
    }
    public List<Foyer> searchFoyersByNomUniversite(String universityName) {
        List<Foyer> foyers = foyerRepository.searchFoyersByUniversite(universityName);
        for (Foyer foyer : foyers) {
            Universite universite = foyer.getUniversite();
            if (universite != null) {
                String universiteNom = universite.getNomUniversite();
                foyer.setUniversiteName(universiteNom);
            }
        }
        return foyers;
    }
    public List<Foyer> searchFoyersByBloc(String bloc) {
        List<Foyer> foyers = foyerRepository.searchFoyersByBloc(bloc);
        for (Foyer foyer : foyers) {
            Universite universite = foyer.getUniversite();
            if (universite != null) {
                String universiteNom = universite.getNomUniversite();
                foyer.setUniversiteName(universiteNom);
            }
        }
        return foyers;
    }

}