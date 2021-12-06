package Formulaire;

import DAO.FormsDAO;
import managers.FormsList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class TestCaseCompile {

        @Test
        public void shouldAddFormToDB() {
            Formulaire form=new Formulaire(false,"FormulaireSous Java", new ArrayList<Page>(),5, true,1);
            form.addQuestionsThroughFormulaire(new YesOrNO(1,"What",false, form.getID()));
            form.addQuestionsThroughFormulaire(new YesOrNO(2,"the",false, form.getID()));
            form.addQuestionsThroughFormulaire(new YesOrNO(3,"test",false, form.getID()));


            int check=new FormsDAO().addFormulaireToDB(form);
            System.out.println(check);
            Assert.assertNotNull(check);
        }

        @Test
        public void shouldAddPageToDB() {
            Formulaire form=new Formulaire(false,"TestDuDelete", new ArrayList<Page>(),5, true,1);
            new FormsDAO().addFormulaireToDB(form);
            Page page=new YesOrNO(1,"TestDeZakiHess",true,form.getID());
            int check=new FormsDAO().addPageToDB(page);

            System.out.println(check);
            Assert.assertNotNull(check);
        }

        @Test
        public void shouldGetAllFormsFromDB() {
            int NbForms= new FormsDAO().getAllFormulaireFromDB();
            System.out.println(NbForms+" forms added :");
            Collection<Formulaire> values = FormsList.getInstance().getFormsList().values();
            //iterate values using forEach
            values.forEach( value -> {
                System.out.println( value.getTitle() );
            });
            Assert.assertEquals(NbForms, FormsList.getInstance().getFormsList().size());
        }

        @Test
    public void shouldDeleteForms() {
            System.out.println("Added :"+new FormsDAO().getAllFormulaireFromDB());
            boolean result= new FormsDAO().DeleteFormulaire(FormsList.getInstance().getFormsByID(1));
            Assert.assertTrue(result);
        }




}
