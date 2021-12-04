package service;

import DAO.LoginDao;
import DAO.UserDao;
import entity.Utilisateur;

import java.util.List;

public class UserService {

    private UserDao userdao = new UserDao();

    private static class UserServiceHolder{
        private static UserService instance = new UserService();
    }
    public static UserService getInstance(){return UserServiceHolder.instance;}

    private UserService(){}


    public void addUser(Utilisateur utilisateur) {
        userdao.addUser(utilisateur);
    }

    public void deleteUser(String User){userdao.deleteUser(User);}

    public boolean checkIfExist(String User){return userdao.checkIfExist(User);}

    public List<Utilisateur> listAllUser() {return userdao.listAllUser();}

}
