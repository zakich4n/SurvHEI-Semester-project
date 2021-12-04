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







}
