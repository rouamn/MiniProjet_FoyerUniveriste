package com.example.foyerrouamnissi.Services.Chambre;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Chambre;
import com.example.foyerrouamnissi.DAO.Repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreService implements IChambreService{
ChambreRepository chambreRepository;
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
}
