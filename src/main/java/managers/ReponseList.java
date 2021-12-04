package managers;

import Formulaire.Formulaire;
import Reponse.Reponse;

import java.util.List;
import java.util.TreeMap;

public class ReponseList {

    private static class ReponseListHolder {
        private final static ReponseList instance = new ReponseList();
    }

    public static ReponseList getInstance() {
        return managers.ReponseList.ReponseListHolder.instance;
    }

    static TreeMap<Integer, Reponse> ReponseList= new TreeMap<>();


}
