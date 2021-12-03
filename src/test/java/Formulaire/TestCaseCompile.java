package Formulaire;
import Formulaire.*;
import Formulaire.Compile;
import Codage.*;
import managers.FormsList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestCaseCompile {

    @Test
    public void shouldEncodeAndReturnSingleString() {
        Page ouinon=new YesOrNO(1,"As tu perdu ?",true);
        ArrayList<Page> pages=new ArrayList<>();
        pages.add(ouinon);
        Formulaire form= new Formulaire(true,pages);
        Compile test= new Compile();
        String result=test.encode(form);
        System.out.println(result);
    }

    @Test
    public void shouldEncodeAndReturnMultipleStrings() {
        YesOrNO Une=new YesOrNO(1,"As tu perdu ?",true);
        MultipleChoice Deux=new MultipleChoice(2,"Selectionne 2 pays :",true);
        Deux.addChoice("France");
        Deux.addChoice("Allemagne");
        Deux.addChoice("Italie");
        ArrayList<Page> pages=new ArrayList<>();
        pages.add(Une);
        pages.add(Deux);
        Formulaire form= new Formulaire(true,pages);
        Compile compile= new Compile();
        String firstLine=compile.encode(form);
        System.out.println(firstLine);
    }

    @Test
    public void shouldDecodeAndReturnForm() {
        String rawData="true#Question#1#YesOrNo#As tu perdu ?##@true#Question#1#YesOrNo#As tu perdu ?##@" +
                "true#Question#2#MultipleChoices#Selectionne 2 pays :#[France, Allemagne, Italie]#@true@";
        Compile comp=new Compile();
        Formulaire form= comp.decode(rawData);
        Assert.assertTrue(form.getAnonState());
    }

    @Test
    public void shouldAddForm() {
        YesOrNO Une=new YesOrNO(1,"As tu perdu ?",true);
        MultipleChoice Deux=new MultipleChoice(2,"Selectionne 2 pays :",true);
        Deux.addChoice("France");
        Deux.addChoice("Allemagne");
        Deux.addChoice("Italie");
        ArrayList<Page> pages=new ArrayList<>();
        pages.add(Une);
        pages.add(Deux);
        Formulaire form= new Formulaire(true,pages);
        FormsList.getInstance().addForm(1,form);
        System.out.print(form.id);
        Assert.assertNotNull(form.getID());
    }


}
