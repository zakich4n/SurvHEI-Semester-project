package service;

import DAO.FormsDAO;
import Formulaire.Formulaire;
import exception.FormulaireNotFoundException;

import java.lang.reflect.Array;
import java.util.*;

public class FormsListService {

    private static class FormsListHolder {
        private final static FormsListService instance = new FormsListService();
    }

    public static FormsListService getInstance() {
        return FormsListHolder.instance;
    }

    static TreeMap<Integer, Formulaire> FormsList= new TreeMap<>();

    public TreeMap<Integer, Formulaire> getFormsList() {return FormsList;}

    public Formulaire getFormsByID(int id) {
        return FormsList.get(id);
    }

    public void addFormulaireToList(int id, Formulaire form) {
        FormsList.put(id, form);
    }
    public int addFormulaire(Formulaire form) {
        int id=new FormsDAO().addFormulaireToDB(form);
       addFormulaireToList(id, form);
       return id;
    }

    public List<Integer> getAllIDs() {
        return new ArrayList<>(FormsList.keySet());
    }

    public int randomID() {
        Random r = new Random();
        return getAllIDs().get(r.nextInt(FormsList.size()));
    }

    public void deleteFromFormsList(Formulaire form) {
        FormsList.remove(form.getID());
    }
    public void deleteFromFormsList(int idform) {
        FormsList.remove(idform);
    }


}
