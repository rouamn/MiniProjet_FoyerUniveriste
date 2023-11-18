package com.example.foyerrouamnissi.Services.Chambre;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import com.example.foyerrouamnissi.DAO.Entities.TypeChambre;
import com.example.foyerrouamnissi.DAO.Repositories.BlocRepository;
import com.example.foyerrouamnissi.DAO.Repositories.ChambreRepository;
import com.example.foyerrouamnissi.DAO.Repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService{
ChambreRepository chambreRepository;
BlocRepository blocRepository;
FoyerRepository foyerRepository;
    @Override
    public Chambre addChambre(Chambre b) {
        return chambreRepository.save(b);
    }

    @Override
    public List<Chambre> addChambre(List<Chambre> b) {
        return  chambreRepository.saveAll(b);
    }

    @Override
    public Chambre editChambre(Chambre b) {
        return chambreRepository.save(b);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findById(long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        chambreRepository.deleteById(id);

    }

    @Override
    public void delete(Chambre b) {
        chambreRepository.delete(b);

    }

    public void createChambreWithBloc(long numeroChambre, TypeChambre typeC, long blocId) {
        // Create a new Chambre object
        Chambre chambre = new Chambre();
        chambre.setNumeroChambre(numeroChambre);
        chambre.setTypeC(typeC);

        // Retrieve the corresponding Bloc object from the database
        Bloc bloc = blocRepository.findById(blocId).orElse(null);
        if (bloc != null) {
            // Set the bloc property of the Chambre object
            chambre.setBloc(bloc);
        }

        // Save the Chambre object to the database
        chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        return chambreRepository.findByBloc_NomBloc(nomBloc);
    }

    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return chambreRepository.countByTypeCAndBloc_IdBloc(type, idBloc);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {
        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);
        return chambreRepository.findNonReservedRoomsByFoyerAndType(foyer, type, getCurrentAcademicYear());
    }

    private String getCurrentAcademicYear() {
        // Implement logic to get the current academic year (e.g., 2023-2024)
        // You can use java.time.LocalDate or other methods to determine the current academic year.
        // For simplicity, you can return a hardcoded value for now.
        return "2023-2024";
    }


}
