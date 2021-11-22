package managers;

import Formulaire.Formulaire;

import java.util.TreeMap;

public class FormsList {

    private static class FormsListHolder {
        private final static FormsList instance = new FormsList();
    }

    public static FormsList getInstance() {
        return FormsListHolder.instance;
    }

    private TreeMap<Integer, Formulaire> FormsList;

    public Formulaire getFormsByID(int id) {return FormsList.get(id);}

    public Formulaire addFilm(Formulaire form) {
        Integer id = FormsList.lastKey() + 1;
        form.setID(id);
        FormsList.put(id, form);
        return form;
    }

}
