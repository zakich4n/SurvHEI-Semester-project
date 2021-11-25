package Formulaire;

import java.util.ArrayList;

public class Formulaire {
    public boolean Anonyme;
    public ArrayList<Page> pages;
    public int id;


    public Formulaire(boolean anon, ArrayList<Page> pages) {
        this.Anonyme=anon;
        this.pages=pages;
    }

    public ArrayList<Page> getPages() {return pages;}

    public void setID(int id) {this.id=id;}

    public int getID() {return id;}

    public boolean getAnonState() {return Anonyme;}



}
