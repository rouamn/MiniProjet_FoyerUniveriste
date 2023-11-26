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
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);}
    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        if (etudiantRepository.existsById(etudiant.getIdEtudiant())) {
            return etudiantRepository.save(etudiant);
        }
        return null ;
    }
    @Override
    public void deleteEtudiant(Integer id) { etudiantRepository.deleteById(id); }
}
