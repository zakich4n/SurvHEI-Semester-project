package Reponse;


public class Reponse {
    private int IDUer;
    private int IDQuestion;
    private boolean reponse;

    public Reponse(int IDUer, int IDQuestion, boolean reponse) {
        this.IDUer = IDUer;
        this.IDQuestion = IDQuestion;
        this.reponse = reponse;
    }

    public int getIDUer() {
        return IDUer;
    }

    public void setIDUer(int IDUer) {
        this.IDUer = IDUer;
    }

    public int getIDQuestion() {
        return IDQuestion;
    }

    public void setIDQuestion(int IDQuestion) {
        this.IDQuestion = IDQuestion;
    }

    public boolean getReponse() {
        return reponse;
    }

    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }
}
