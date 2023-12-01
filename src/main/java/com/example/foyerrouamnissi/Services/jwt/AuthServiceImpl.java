package com.example.foyerrouamnissi.Services.jwt;

import com.example.foyerrouamnissi.DAO.Entities.Etudiant;
import com.example.foyerrouamnissi.DAO.Repositories.EtudiantRepository;
import com.example.foyerrouamnissi.dto.SignUpRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements  AuthService {

    private EtudiantRepository etudiantRepository;

    private  PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(EtudiantRepository etudiantRepository, PasswordEncoder passwordEncoder) {
        this.etudiantRepository = etudiantRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public boolean  createEtdiant(SignUpRequest signUpRequest) {

        if(etudiantRepository.existsByEmail(signUpRequest.getEmail())){

            return  false;

        }
       Etudiant etudiant = new Etudiant();

        BeanUtils.copyProperties(signUpRequest, etudiant);

        String HashPassword= passwordEncoder.encode(signUpRequest.getPassword());
        etudiant.setPassword(HashPassword);

        etudiantRepository.save(etudiant);
        return  true;
    }
}