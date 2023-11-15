package com.example.foyerrouamnissi.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name="Etudiant")
public class Etudiant implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    @Column(name="nomEt")
    private  String nomEt;
    @Column(name="prenomEt")
    private  String  prenomEt;
    @Column(name="cin")
    private long cin;
    @Column(name="ecole")
    private String ecole;
    @Column(name="dateNaissance")
    private Date dateNaissance;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "passwordDecoder")
    private String passwordDecoder;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    //association
    //child
    @ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservation = new HashSet<>();


    @OneToMany(mappedBy = "etudiant")
    private List<Token> tokens ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
