package com.example.foyerrouamnissi.DAO.AUTH;

import com.example.foyerrouamnissi.DAO.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nomEt;

    private String prenomEt;

    private long cin;

    private String ecole;

    private Date dateNaissance; //JJ/MM/YYYY

    private String email;

    private String password;

    private Role role;
}
