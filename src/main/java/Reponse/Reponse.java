package Reponse;

import Formulaire.Formulaire;

import java.util.TreeMap;

public class Reponse {
    private Formulaire formulaire;
    private int idUser;
    private TreeMap<Integer, Boolean> reponse;

    public Reponse(Formulaire form, TreeMap<Integer, Boolean> rep) {
        this.formulaire=form;
        this.idUser=0;
        this.reponse=rep;
    }

    public Formulaire getFormulaire() {return formulaire;}
}
