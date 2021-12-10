package managers;

import Formulaire.*;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.FormsListService;

import java.util.ArrayList;

public class FormsListServiceTest extends TestCase {
    int IDForm;
    Formulaire form;
    FormsListService service= FormsListService.getInstance();
    @Before
    public void setUp() throws Exception {
        form= new Formulaire(false,"TestCompile", new ArrayList<Page>(),5,true,7);
        form.setID(service.addFormulaire(form));
        form.addQuestionsThroughFormulaire(new YesOrNO(1,"TestCompile",true, form.getID()),true);
        IDForm= form.getID();
        super.setUp();
    }
    @After
    public void tearDown() throws Exception {
        service.deleteFromFormsList(IDForm);
    }
    @Test
    public void testGetFormsList() {
        Assert.assertEquals(service.getFormsList().get(IDForm), form);
    }
    @Test
    public void testGetFormsByID() {
        Assert.assertEquals(service.getFormsByID(IDForm), form);
    }
    @Test
    public void testAddFormulaireToList() {

    }
    @Test
    public void testDeleteFromFormsList() {
        service.deleteFromFormsList(IDForm);
        Assert.assertNull(form);
    }
    @Test
    public void testTestDeleteFromFormsList() {
    }
}