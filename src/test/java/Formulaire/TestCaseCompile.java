package Formulaire;

import DAO.FormsDAO;
import managers.FormsList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

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
/*
        @Test
        public void shouldDeleteForms() {
            int IDFormToDelete=14;
            System.out.println("Added :"+new FormsDAO().getAllFormulaireFromDB());
            boolean result= new FormsDAO().DeleteFormulaire(FormsList.getInstance().getFormsByID(IDFormToDelete));
            Assert.assertNull(FormsList.getInstance().getFormsByID(IDFormToDelete));
        } */
/*
        @Test
        public void shouldEditFormInDB() {
            int IDFormToEdit=41;
            String randomTitle="Encore un testteeeeee";
            Random r = new Random();
            int rand = r.nextInt(90) + 10;
            System.out.println("Added :"+new FormsDAO().getAllFormulaireFromDB());
            String oldTitle=FormsList.getInstance().getFormsByID(IDFormToEdit).getTitle();
            int oldTime=FormsList.getInstance().getFormsByID(IDFormToEdit).getTemps();
            FormsList.getInstance().getFormsByID(IDFormToEdit).setTitle(randomTitle);
            FormsList.getInstance().getFormsByID(IDFormToEdit).setTemps(rand);
            new FormsDAO().editFormInDB(FormsList.getInstance().getFormsByID(IDFormToEdit));
            System.out.println("Updated to : "+randomTitle+"// Had : "+oldTitle);
            System.out.println("Updated to : "+rand+"// Had : "+oldTime);
            Assert.assertEquals(FormsList.getInstance().getFormsByID(IDFormToEdit).getTitle(), randomTitle);
            Assert.assertEquals(FormsList.getInstance().getFormsByID(IDFormToEdit).getTemps(), rand);
        }*/

   /*     @Test
        public void shouldChangePageFromForm() {
            int IDFormToEdit=40;
            int indexPage=1;
            boolean newObl=true;
            String newQ="Encore un testteeeeee";


            System.out.println("Added :"+new FormsDAO().getAllFormulaireFromDB());
            String oldQ=FormsList.getInstance().getFormsByID(IDFormToEdit).getPages().get(indexPage).getQuestion();
            FormsList.getInstance().getFormsByID(IDFormToEdit).getPages().get(indexPage).setQuestion(newQ);
            boolean oldObl=FormsList.getInstance().getFormsByID(IDFormToEdit).getPages().get(indexPage).getObligatoire();
            FormsList.getInstance().getFormsByID(IDFormToEdit).getPages().get(indexPage).setObligatoire(newObl);

            new FormsDAO().editPagesFromForm(IDFormToEdit,FormsList.getInstance().getFormsByID(IDFormToEdit).getPages().get(indexPage));
            System.out.println("Updated to : "+newQ+"// Had : "+oldQ);
            System.out.println("Updated to : "+newObl+"// Had : "+oldObl);
            Assert.assertEquals(FormsList.getInstance().getFormsByID(IDFormToEdit).getPages().get(indexPage).getQuestion(), newQ);
            Assert.assertEquals(FormsList.getInstance().getFormsByID(IDFormToEdit).getPages().get(indexPage).getObligatoire(), newObl);
        }*/

        @Test
        public void shouldAddReponseToDB() {

        }


}
