package service;

import DAO.FormulaireDao;
import entity.Formulaire;

public class FormulaireService {
    private FormulaireDao formulairedao = new FormulaireDao();

    private static class FormulaireServiceHolder{
        private static FormulaireService instance = new FormulaireService();
    }
    public static FormulaireService getInstance(){return FormulaireService.FormulaireServiceHolder.instance;}

    private FormulaireService(){}

    public int AddFormulaire(Formulaire formulaire){ return formulairedao.AddFormulaire(formulaire);}
}
