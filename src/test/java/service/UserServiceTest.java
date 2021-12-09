package service;

import entity.Utilisateur;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void shouldDeleteUser() {
        //GIVEN
        Utilisateur test = new Utilisateur("test","emailtest","nomtest","prenomtest",false);
        UserService.getInstance().addUser(test);
        //WHEN
        UserService.getInstance().deleteUser(test.getUser());

        //THEN
        Assert.assertNull(test);
    }
}