package com.example.foyerrouamnissi.Services.jwt;

import com.example.foyerrouamnissi.dto.SignUpRequest;

public interface AuthService {
    boolean createEtdiant(SignUpRequest signUpRequest);
}