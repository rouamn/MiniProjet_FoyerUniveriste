package com.example.foyerrouamnissi.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Bloc;
import com.example.foyerrouamnissi.DAO.Entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoyerRepository  extends JpaRepository<Foyer,Long > {
}
