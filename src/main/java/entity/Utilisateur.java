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

    public Utilisateur(String user, String email, String nom, String prenom,boolean role){
        this.User=user;
        this.email=email;
        this.nom=nom;
        this.prenom=prenom;
        this.IsAdmin=role;
    }

    public String getUser(){ return this.User;}
    public String getPassword(){return this.Password;}
    public String getEmail(){return this.email;}
    public String getNom(){return this.nom;}
    public String getPrenom(){return this.prenom;}
    public LocalDateTime getDateNaissance(){return this.DateNaissance;}
    public String getSexe(){return this.Sexe;}
    public boolean getRole(){return this.IsAdmin;}



    public void setUser(String utilisateur){this.User=utilisateur;}
    public void setPassword(String password){this.Password=password;}




}