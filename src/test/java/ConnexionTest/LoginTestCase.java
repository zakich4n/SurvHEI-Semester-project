package ConnexionTest;

import DAO.LoginDao;
import entity.Utilisateur;
import org.junit.Assert;
import org.junit.Test;
import service.LoginService;

public class LoginTestCase {
    private LoginDao login = new LoginDao();


    @Test
    public void ShouldReturnTrueIfExists(){
        //GIVEN
        int resultat1;
        int resultat2;
        int resultat3;
        Utilisateur UserExists = new Utilisateur("user", "azerty");
        Utilisateur AdminExists = new Utilisateur("admin", "motdepasse");
        Utilisateur UserDoesntExist = new Utilisateur("notExist", "pass");
        //WHEN
        resultat1 = login.valider(UserExists);
        resultat2 = login.valider(AdminExists);
        resultat3 = login.valider(UserDoesntExist);
        //THEN
        Assert.assertEquals(1,resultat1);
        Assert.assertEquals(2, resultat2);
        Assert.assertEquals(0, resultat3);

    }



}
