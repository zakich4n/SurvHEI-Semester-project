package service;

import DAO.CreateFormDao;
import entity.Question;

public class CreateFormService {

    private CreateFormDao createformulairedao = new CreateFormDao();

    private static class CreateFormServiceHolder{
        private static CreateFormService instance = new CreateFormService();
    }
    public static CreateFormService getInstance(){return CreateFormService.CreateFormServiceHolder.instance;}

    private CreateFormService(){}

    public void AddQuestion(Question question){ createformulairedao.AddQuestion(question);}



}

