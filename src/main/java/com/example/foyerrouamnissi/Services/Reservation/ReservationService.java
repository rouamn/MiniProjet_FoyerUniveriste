package com.example.foyerrouamnissi.Services.Reservation;

import com.example.foyerrouamnissi.DAO.Entities.Reservation;
import com.example.foyerrouamnissi.DAO.Repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements  IReservationService {
    ReservationRepository reservationRepository;
    @Override
    public Reservation addReservation(Reservation b) {
        return    reservationRepository.save(b);
    }

    @Override
    public List<Reservation> addReservation(List<Reservation> b) {
        return  reservationRepository.saveAll(b);
    }

    @Override
    public Reservation editReservation(Reservation b) {
        return reservationRepository.save(b);
    }

    @Override
    public List<Reservation> findAll() {
      return  reservationRepository.findAll();

    }

    @Override
    public Reservation findById(long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void delete(Reservation b) {
        reservationRepository.delete(b);

    }
}
