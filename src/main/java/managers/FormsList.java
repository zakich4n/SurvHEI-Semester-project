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

    public TreeMap<Integer, Formulaire> getFormsList() {return FormsList;}

    public Formulaire getFormsByID(int id) {return FormsList.get(id);}

    public void addFormulaireToList(int id, Formulaire form) {
        FormsList.put(id, form);
    }

    public void deleteFromFormsList(Formulaire form) {
        FormsList.remove(form.getID());
    }
    public void deleteFromFormsList(int idform) {
        FormsList.remove(idform);
    }




}
