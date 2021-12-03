package service;

import DAO.CreateFormDao;
import DAO.FormulaireDao;
import entity.Formulaire;
import entity.Question;

public class FormulaireService {
    private FormulaireDao formulairedao = new FormulaireDao();

    private static class FormulaireServiceHolder{
        private static FormulaireService instance = new FormulaireService();
    }
    public static FormulaireService getInstance(){return FormulaireService.FormulaireServiceHolder.instance;}

    private FormulaireService(){}

    public int AddFormulaire(Formulaire formulaire){ return formulairedao.AddFormulaire(formulaire);}

    public void deleteQuest(int FormId){ formulairedao.deleteQuest(FormId);}

    public void deleteForm(int FormId){ formulairedao.deleteForm(FormId);}
}
