package entities;

public class Utilisateur {
    private Integer IDUser;
    private String User;
    private String Password;
    private String DateCreation;
    private String email;
    private String nom;
    private String prenom;
    private String DateNaissance;
    private char Sexe;
    private boolean IsAdmin;

    public Utilisateur(Integer IDUser, String User,String Password, String dateCreation, String email, String nom, String prenom, String DateNaissance, char Sexe, boolean IsAdmin){
        this.IDUser=IDUser;
        this.User=User;
        this.Password=Password;
        this.DateCreation=dateCreation;
        this.email=email;
        this.nom=nom;
        this.prenom=prenom;
        this.DateNaissance=DateNaissance;
        this.Sexe=Sexe;
        this.IsAdmin=IsAdmin;
    }

    public Utilisateur(String user, String password){
        this.User=user;
        this.Password=password;
    }

    public String getUser(){ return User;}
    public String getPassword(){return Password;}
    public void setUser(String utilisateur){this.User=utilisateur;}
    public void setPassword(String password){this.Password=password;}




}