package ConnexionTest;

import DAO.Login;
import entities.Utilisateur;
import org.junit.Assert;
import org.junit.Test;

public class LoginTestCase {
    private Login login = new Login();


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
