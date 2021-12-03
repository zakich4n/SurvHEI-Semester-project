package Reponse;

import Formulaire.Formulaire;

import java.util.List;

public class Reponse {
    private Formulaire formulaire;
    private int idUser;
    private List<Boolean> reponse;

    public Reponse(Formulaire form, List<Boolean> rep) {
        this.formulaire=form;
        this.idUser=0;
        this.reponse=rep;
    }


}
