package com.example.foyerrouamnissi.Services.Etudiant;


import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantService implements IEtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;


    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant editEtudiant(Integer id, Etudiant e) {
        if(etudiantRepository.findById(id).isPresent()){
            Etudiant toUpdateEtudiant = etudiantRepository.findById(id).get();
            toUpdateEtudiant.setNomEt(e.getNomEt());
            toUpdateEtudiant.setPrenomEt(e.getPrenomEt());
            toUpdateEtudiant.setCin(e.getCin());
            toUpdateEtudiant.setEcole(e.getEcole());
            toUpdateEtudiant.setDateNaissance(e.getDateNaissance());
            toUpdateEtudiant.setReservations(e.getReservations());

            return etudiantRepository.save(toUpdateEtudiant);
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(Integer id) {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        etudiantRepository.deleteById(id);

    }

    @Override
    public void delete(Etudiant e) {
        etudiantRepository.delete(e);

    }
}
