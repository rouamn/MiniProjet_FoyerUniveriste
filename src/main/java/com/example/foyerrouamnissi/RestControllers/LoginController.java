package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.Services.jwt.EtudiantServiceImpl;
import com.example.foyerrouamnissi.dto.loginRequest;
import com.example.foyerrouamnissi.dto.loginResponse;
import com.example.foyerrouamnissi.utilis.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class LoginController {

    private  final AuthenticationManager authenticationManager;


    private   EtudiantServiceImpl etudiantServiceimpl;
    private  final JwtUtil jwtUtil;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager,  EtudiantServiceImpl etudiantServiceimpl, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.etudiantServiceimpl = etudiantServiceimpl;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<loginResponse> login(@RequestBody loginRequest loginRequest){

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch ( AuthenticationException e) {

            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserDetails userDetails;
        try {

            userDetails= etudiantServiceimpl.loadUserByUsername(loginRequest.getEmail());

        } catch ( UsernameNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return  ResponseEntity.ok(new loginResponse(jwt));



    }
}