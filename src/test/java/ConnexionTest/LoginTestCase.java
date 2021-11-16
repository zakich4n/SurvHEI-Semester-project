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
        boolean resultat1;
        boolean resultat2;
        Utilisateur utilisateurExists = new Utilisateur("User2", "password");
        Utilisateur utilisateurDoesntExist = new Utilisateur("notExist", "password1");
        //WHEN
        resultat1 = login.valider(utilisateurExists);
        resultat2 = login.valider(utilisateurDoesntExist);
        //THEN
        Assert.assertTrue(resultat1);
        Assert.assertFalse(resultat2);

    }



}
