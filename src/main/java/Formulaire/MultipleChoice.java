package Formulaire;

import java.util.ArrayList;

public class MultipleChoice extends Page  {
    public ArrayList<String> ListeChoix= new ArrayList<>();

    public MultipleChoice(int num, String Q, boolean obl) {
        super(num, Q, obl, "MultipleChoices", "Question");
    }

    public void addChoice(String Choix) {
        ListeChoix.add(Choix);
    }

    @Override
    public String getChoices() {return String.valueOf(ListeChoix);}
}
