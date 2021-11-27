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

    public void AddFormulaire(Formulaire formulaire){ formulairedao.AddFormulaire(formulaire);}
}
