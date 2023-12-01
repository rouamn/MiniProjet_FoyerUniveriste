package com.example.foyerrouamnissi.dto;

public class SignUpRequest {

    private  String email;
    private  String nomEt;
    private  String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return nomEt;
    }

    public void setName(String name) {
        this.nomEt = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}