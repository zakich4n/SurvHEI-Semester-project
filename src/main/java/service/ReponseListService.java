package service;

import DAO.ReponseDAO;
import Formulaire.*;
import Reponse.Reponse;

import java.util.TreeMap;

public class ReponseListService {

    private static class ReponseListHolder {
        private final static ReponseListService instance = new ReponseListService();
    }

    public static ReponseListService getInstance() {
        return ReponseListService.ReponseListHolder.instance;
    }

    static TreeMap<Page, Reponse> ReponseList= new TreeMap<>();

    public TreeMap<Page, Reponse> getReponseList() {return ReponseList;}

    public void initializeList() {
        new ReponseDAO().getAllReponseFromDB();
    }

    public boolean addReponse(Reponse rep) {
        int result=new ReponseDAO().addReponseToDB(rep);
        switch (result) {
            case 1 :
                //ReponseList.put(PAGE, rep);
                return true;
        }
        return false;
    }



}
