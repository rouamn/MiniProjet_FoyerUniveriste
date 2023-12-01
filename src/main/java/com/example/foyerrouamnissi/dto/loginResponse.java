package com.example.foyerrouamnissi.dto;

public class loginResponse {


    private  String jwtToken ;

    public loginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}

