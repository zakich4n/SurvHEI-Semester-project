package service;

import DAO.LoginDao;
import entity.Utilisateur;

public class LoginService {

    private LoginDao logindao = new LoginDao();

    private static class LoginServiceHolder{
        private static LoginService instance = new LoginService();
    }
    public static LoginService getInstance(){return LoginServiceHolder.instance;}

    private LoginService(){}

    public int[] valider(Utilisateur utilisateur){return logindao.valider(utilisateur);}

    public void addUser(Utilisateur utilisateur) {
        logindao.addUser(utilisateur);
    }

    public void deleteUser(String User){logindao.deleteUser(User);}

    public int getByIdName(String User, String Nom, String Prenom){return logindao.getByIdName(User, Nom, Prenom);}

    public boolean checkIfExist(String User){return logindao.checkIfExist(User);}

}
