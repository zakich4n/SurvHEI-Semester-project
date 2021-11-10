package Formulaire;

import Codage.Encode;

import java.util.ArrayList;

public class Formulaire {
    public boolean Anonyme;
    public ArrayList<Page> pages;

    public Formulaire(boolean anon, ArrayList<Page> pages) {
        this.Anonyme=anon;
        this.pages=pages;
    }

    public ArrayList<Page> getPages() {return pages;}

    public boolean getAnonState() {return Anonyme;}
}
