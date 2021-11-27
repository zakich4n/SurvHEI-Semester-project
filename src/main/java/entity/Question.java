package entity;

public class Question {
    private String question;
    private int ordre_question;
    private int id_formulaire_correspondant;
    private boolean obligatoire;

    public Question (String question, int ordre_question, int id_formulaire_correspondant, boolean obligatoire){
        this.question = question;
        this.ordre_question = ordre_question;
        this.id_formulaire_correspondant = id_formulaire_correspondant;
        this.obligatoire = obligatoire;
    }

    public String getQuestion(){return this.question;}
    public int getOrdre_question(){return this.ordre_question;}
    public int getId_formulaire_correspondant(){return this.id_formulaire_correspondant;}
    public boolean getObligatoire(){return this.obligatoire;}
}
