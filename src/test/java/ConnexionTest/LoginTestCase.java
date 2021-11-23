package ConnexionTest;

import DAO.LoginDao;
import entity.Utilisateur;
import org.junit.Assert;
import org.junit.Test;

public class LoginTestCase {
    private LoginDao login = new LoginDao();


    @Test
    public void ShouldReturnTrueIfExists(){
        //GIVEN
        int resultat1;
        int resultat2;
        Utilisateur utilisateurExists = new Utilisateur("JT", "ghb2cx4f");
        Utilisateur utilisateurDoesntExist = new Utilisateur("notExist", "password1");
        //WHEN
        resultat1 = login.valider(utilisateurExists);
        resultat2 = login.valider(utilisateurDoesntExist);
        //THEN
        Assert.assertEquals(2,resultat1);
        Assert.assertEquals(1, resultat2);

    }



}
