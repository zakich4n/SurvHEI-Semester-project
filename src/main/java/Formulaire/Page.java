package Formulaire;

public class Page {
    public int Numero;
    public String Question;
    public boolean Obligatoire;

    public Page(int num, String Q, boolean obl) {
        this.Numero=num;
        this.Question=Q;
        this.Obligatoire=obl;
    }
}
