package entity;

public class Formulaire {
    private String title;
    private int nb_questions;
    private int temps;
    private boolean actif;
    private boolean anonyme;
    private int id_createur;

    public Formulaire (String title, int nb_questions, int temps, boolean actif, boolean anonyme, int id_createur){
        this.title = title;
        this.nb_questions = nb_questions;
        this.temps = temps;
        this.actif = actif;
        this.anonyme = anonyme;
        this.id_createur = id_createur;
    }

    public String getTitle(){return this.title;}
    public int getNb_questions(){return this.nb_questions;}
    public int getTemps(){return this.temps;}
    public boolean getActif(){return this.actif;}
    public boolean getAnonyme(){return this.anonyme;}
    public int getId_createur(){return this.id_createur;}
}
