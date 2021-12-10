package managers;

import Formulaire.*;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.FormsListService;

import java.util.ArrayList;

public class FormsListServiceTest extends TestCase {
    @Before
    public void setUp() throws Exception {
        Formulaire form= new Formulaire(false,"TestCompile", new ArrayList<Page>(),5,true,7);
        form.setID(FormsListService.getInstance().addFormulaire(form));
        form.addQuestionsThroughFormulaire(new YesOrNO(1,"TestCompile",true, form.getID()),true);
        super.setUp();
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testGetFormsList() {

    }
    @Test
    public void testGetFormsByID() {
    }
    @Test
    public void testAddFormulaireToList() {
    }
    @Test
    public void testDeleteFromFormsList() {
    }
    @Test
    public void testTestDeleteFromFormsList() {
    }
}