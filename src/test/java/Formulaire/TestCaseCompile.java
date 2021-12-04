package Formulaire;

import DAO.FormsDAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestCaseCompile {

        @Test
        public void shouldAddFormToDB() {
            Formulaire form=new Formulaire(false,"FormulaireSous Java", new ArrayList<Page>(),5,1);
            form.addQuestionsThroughFormulaire(new YesOrNO(1,"What",false, form.getID()));
            form.addQuestionsThroughFormulaire(new YesOrNO(2,"the",false, form.getID()));
            form.addQuestionsThroughFormulaire(new YesOrNO(3,"test",false, form.getID()));


            int check=new FormsDAO().addFormulaireToDB(form);
            System.out.println(check);
            Assert.assertNotNull(check);
        }

        @Test
        public void shouldAddPageToDB() {
            Page page=new YesOrNO(1,"TestDeZakiHess",true,16);
            int check=new FormsDAO().addPageToDB(page);

            System.out.println(check);
            Assert.assertNotNull(check);
        }




}
