package com.example.foyerrouamnissi.Services;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Repositories.BlocRepository;
import com.example.foyerrouamnissi.DAO.Repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
  EtudiantRepository etudiantRepository ;


    @Override
    public Etudiant addEtudiant(Etudiant b) {
        return etudiantRepository.save(b);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> b) {
        return  etudiantRepository.saveAll(b);//on ajoute des lignes dans la bd
    }

    @Override
    public Etudiant editEtudiant(Etudiant b) {
        return etudiantRepository.save(b);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(long id) {
        return etudiantRepository.findById(id).orElse(Etudiant.builder().idEtudiant(0).nomEt("pas de bloc").build());
    }

    @Override
    public void deleteById(long id) {
        etudiantRepository.deleteById(id);

    }

    @Override
    public void delete(Etudiant b) {
        etudiantRepository.delete(b);

    }
}
