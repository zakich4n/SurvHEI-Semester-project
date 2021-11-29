package Reponse;

import Formulaire.Formulaire;

import java.util.List;

public class Reponse {
    private Formulaire formulaire;
    private int idUser;
    private List<Boolean> reponse;

    public Reponse(Formulaire form, int iduser, List<Boolean> rep) {
        this.formulaire=form;
        this.idUser=iduser;
        this.reponse=rep;
    }


}
