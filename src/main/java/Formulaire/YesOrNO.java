package Formulaire;

import java.util.ArrayList;

public class YesOrNO extends Page {
    public ArrayList<String> ListeChoix=null;
    public YesOrNO(int num, String Question,boolean obl) {
        super(num,Question, obl, "YesOrNo","Question");
    }

    @Override
    public String getChoices() {
        return "";
    }
}