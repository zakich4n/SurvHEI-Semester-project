package managers;

import Formulaire.Formulaire;
import exception.AddingSameIDException;

import java.util.ArrayList;
import Formulaire.*;
import java.util.TreeMap;

public class FormsList {

    private static class FormsListHolder {
        private final static FormsList instance = new FormsList();
    }

    public static FormsList getInstance() {
        return FormsListHolder.instance;
    }

    static TreeMap<Integer, Formulaire> FormsList= new TreeMap<>();

    public TreeMap getFormsList() {return FormsList;}

    public Formulaire getFormsByID(int id) {return FormsList.get(id);}

    public Formulaire addForm(int id, Formulaire form) {
        //if (FormsList.get(id)==null) {
            form.setID(id);
            FormsList.put(id, form);
            return form;
       /* }
        else {
            throw new AddingSameIDException("Conflict ID");
        }*/

    }

    public Formulaire addForm(Formulaire form) {
        if (FormsList.isEmpty()) {
            form.setID(0);
            FormsList.put(0, form);
        }
        else {
            Integer id = FormsList.lastKey() + 1;
            form.setID(id);
            FormsList.put(id, form);
        }
        return form;
    }

    public void init() {
        Page une=new YesOrNO(1,"Etes vous beau ?",true);
        Page deux=new YesOrNO(2,"Etes vous sur ?",true);
        Page trois=new YesOrNO(3,"Mentez vous un tout petit peu ??",true);
        ArrayList<Page> pages=new ArrayList<>();
        pages.add(une); pages.add(deux); pages.add(trois);
        addForm(new Formulaire(true,pages));


        ArrayList<Page> pages2=new ArrayList<>();
        pages2.add(new YesOrNO(1,"Etes vous vivant ?",true)); pages2.add(new YesOrNO(2,"Etes vous sur ?",true));
        addForm(new Formulaire(true,pages2));

        ArrayList<Page> pages3=new ArrayList<>();
        pages3.add(new YesOrNO(1,"Encore un test ?",true)); pages3.add(new YesOrNO(2,"Un peu nul?",true));
        addForm(new Formulaire(true,pages3));
    }

}
