package Formulaire;

import java.util.ArrayList;

public abstract class Page {
    public String Genre; //Si c'est une Question ou un affichage de message
    public int Numero; //repere le numero de page
    public String Question; //la question ou le texte pose
    public boolean Obligatoire; //si la question st obligatoire ou pas
    public String Type; //Quel type de question (oui/non, choix mutiple, entre un nombre, entre un texte)


    public Page(int num, String Q, boolean obl, String type, String genre) {
        this.Numero=num;
        this.Question=Q;
        this.Obligatoire=obl;
        this.Type=type;
        this.Genre=genre;
    }

    public abstract String getChoices() ;

    public String getGenre() {return Genre;}

    public String getNumero() {return String.valueOf(Numero);}

    public String getQuestion() {return Question;}

    public String getObligatoire() {return String.valueOf(Obligatoire);}

    public String getType() {return Type;}



}
