package managers;

import Formulaire.Page;
import DAO.*;
import Reponse.Reponse;

import java.util.TreeMap;

public class PageList {

    private static class PageListHolder {
        private final static PageList instance = new PageList();
    }

    public static PageList getInstance() {
        return managers.PageList.PageListHolder.instance;
    }

    static TreeMap<Integer, Page> PageList= new TreeMap<>();

    public TreeMap<Integer, Page> getPageList() {return PageList;}

    public int init() {
        return new FormsDAO().getAllFormulaireFromDB();
    }


    public boolean addPage(Page page) {
       int result= new FormsDAO().addPageToDB(page);
       boolean success= false;
       switch (result) {
           case 0:
               break;
           default :
               PageList.put(result, page);
               success=true;
               break;
       }
       return success;
    }

    public void editPage(Page page) {
        new FormsDAO().editPagesFromForm(page.getId_formulaire_correspondant(), page);
    }





}
