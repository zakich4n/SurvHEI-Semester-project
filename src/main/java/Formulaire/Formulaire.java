package Formulaire;

import Codage.Encode;

public class Formulaire {
    public boolean Anonyme;
    public Formulaire formulaire;

    public Formulaire(boolean anon, Formulaire form) {
        this.Anonyme=anon;
        this.formulaire=form;
    }


}
