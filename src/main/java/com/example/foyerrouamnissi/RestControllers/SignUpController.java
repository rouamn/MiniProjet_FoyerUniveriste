package com.example.foyerrouamnissi.RestControllers;

import com.example.foyerrouamnissi.Services.jwt.AuthService;
import com.example.foyerrouamnissi.dto.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class SignUpController {

    private  final AuthService authService;

    @Autowired
    public SignUpController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")

    public ResponseEntity<String> SignUpCustomer(@RequestBody SignUpRequest signUpRequest){

        boolean isUserCreated = authService.createEtdiant(signUpRequest);

        if(isUserCreated){
            return  ResponseEntity.status(HttpStatus.CREATED).body("user Created Succefuly");
        }
        else {

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to created user");
        }
    }


}
