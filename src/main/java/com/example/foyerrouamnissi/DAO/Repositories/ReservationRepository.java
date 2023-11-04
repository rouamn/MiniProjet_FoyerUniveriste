package com.example.foyerrouamnissi.DAO.Repositories;

import com.example.foyerrouamnissi.DAO.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResarvationRepository  extends JpaRepository<Reservation,Long > {
}
