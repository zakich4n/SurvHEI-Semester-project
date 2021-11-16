package entity;

import java.time.LocalDateTime;

public class Utilisateur {
    private int IDUser;
    private String User;
    private String Password;
    private String email;
    private String nom;
    private String prenom;
    private LocalDateTime DateNaissance;
    private String Sexe;
    private boolean IsAdmin;

    public Utilisateur(final int IDUser, String User,String Password, String email, String nom, String prenom, LocalDateTime DateNaissance, String Sexe){
        this.IDUser=IDUser;
        this.User=User;
        this.Password=Password;
        this.email=email;
        this.nom=nom;
        this.prenom=prenom;
        this.DateNaissance=DateNaissance;
        this.Sexe=Sexe;
    }

    public Utilisateur(String user, String password){
        this.User=user;
        this.Password=password;
    }

    public String getUser(){ return User;}
    public String getPassword(){return Password;}
    public String getEmail(){return email;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public LocalDateTime getDateNaissance(){return DateNaissance;}
    public String getSexe(){return Sexe;}


    public void setUser(String utilisateur){this.User=utilisateur;}
    public void setPassword(String password){this.Password=password;}




}