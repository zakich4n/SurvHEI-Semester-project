package Formulaire;

import java.util.ArrayList;

public abstract class Page {
    public String Genre; //Si c'est une Question ou un affichage de message
    public int Numero; //repere le numero de page
    public String Question; //la question ou le texte pose
    public boolean Obligatoire; //si la question st obligatoire ou pas
    public String Type; //Quel type de question (oui/non, choix mutiple, entre un nombre, entre un texte)
    private int id_formulaire_correspondant;

    public Page(int num, String Q, boolean obl, String type, String genre, int idform) {
        this.Numero=num;
        this.Question=Q;
        this.Obligatoire=obl;
        this.Type=type;
        this.Genre=genre;
        this.id_formulaire_correspondant=idform;
    }

    public String getGenre() {return Genre;}

    public String getNumero() {return String.valueOf(Numero);}
    public int getNumeroAsInt() {return Numero;}

    public String getQuestion() {return this.Question;}

    public String getObligatoireAsString() {return String.valueOf(Obligatoire);}

    public String getType() {return Type;}


    public int getOrdre_question(){return this.Numero;}
    public int getId_formulaire_correspondant(){return this.id_formulaire_correspondant;}
    public boolean getObligatoire(){return this.Obligatoire;}



}
