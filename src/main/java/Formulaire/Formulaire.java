package Formulaire;

import managers.FormsList;

import java.util.ArrayList;

public class Formulaire {
    public boolean Anonyme;
    public ArrayList<Page> pages;
    public int id;
    public String title;
    private int temps;
    private boolean actif;
    private int id_createur;


    public Formulaire(boolean anon, String title, ArrayList<Page> pages, int tps, int idcrea) {
        this.actif=true;
        this.title=title;
        this.temps=tps;
        this.id_createur=idcrea;
        this.Anonyme=anon;
        this.pages=pages;
    }


    public ArrayList<Page> getPages() {return pages;}

    public void setID(int id) {this.id=id;}

    public int getID() {return id;}

    public boolean getAnonState() {return Anonyme;}

    public int GetNumberOfPage() {
        return pages.size();
    }

    public Page getPageNumber(int id) {
        return pages.get(id);
    }

    public int getTemps(){return this.temps;}
    public boolean getActif(){return this.actif;}
    public boolean getAnonyme(){return this.Anonyme;}
    public int getId_createur(){return this.id_createur;}
    public String getTitle(){return this.title;}

    public void addQuestionsThroughFormulaire(Page page) {
        pages.add(page);
    }

    public int getNb_questions() {
        return pages.size();
    }

}
