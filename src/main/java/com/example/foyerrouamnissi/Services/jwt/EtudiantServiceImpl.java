package com.example.foyerrouamnissi.Services.jwt;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class EtudiantServiceImpl implements UserDetailsService {

    private  final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantServiceImpl( EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Etudiant customer = etudiantRepository.findByEmail(email)
                .orElseThrow (()-> new UsernameNotFoundException("customer not found with email " + email));

        return  new User(customer.getEmail(), customer.getPassword(), Collections.emptyList());
    }

}

