package service;

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

    public List<Utilisateur> listUser(){return userdao.listUser();}

    public void addUser(Utilisateur utilisateur) {
        userdao.addUser(utilisateur);
    }

    public void deleteUser(String User){userdao.deleteUser(User);}

    public int getNameById(String User, String Nom, String Prenom){return userdao.getByIdName(User, Nom, Prenom);}

    public boolean checkIfExist(String User){return userdao.checkIfExist(User);}

    public void PromoteUser(String User){  userdao.PromoteUser(User);}

}
