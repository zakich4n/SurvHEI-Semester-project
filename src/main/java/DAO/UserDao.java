package DAO;

import controller.webservices.MotDePasseUtils;
import entity.Utilisateur;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private MotDePasseUtils motDePasseUtils = new MotDePasseUtils();

    public List<Utilisateur> listUser(){
        List<Utilisateur> result = new ArrayList<>();
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSelect = statement.executeQuery("SELECT * FROM survhei_user ")) {
                while(resultSelect.next()) {
                    result.add(new Utilisateur(
                            resultSelect.getString("User"),
                            resultSelect.getString("Email"),
                            resultSelect.getString("Nom"),
                            resultSelect.getString("Prenom"),
                            resultSelect.getBoolean("IsAdmin")
                            ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int[] valider(Utilisateur utilisateur) {
        int[] resultat = new int[2];
        int res = 0;
        int id=0;
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement("select * from survhei_user where User=?")) {
                    statement.setString(1, utilisateur.getUser());
                    try (ResultSet results = statement.executeQuery()) {
                        while (results.next()) {
                            String mdphash = results.getString("Password");
                            if (motDePasseUtils.validerMotDePasse(utilisateur.getPassword(), mdphash)) {
                                res = 1;
                                id= results.getInt("IDUser");

                                if (results.getInt("isAdmin")==1){
                                    res=2;
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resultat[0]=res;
        resultat[1]=id;
        return resultat;
    }

    public static void addUser(Utilisateur user) {
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql = "INSERT INTO dbsurvhei.survhei_user (User, Password, Email, Nom, Prenom, Sexe, DateNaissance) VALUES(?,?,?,?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, user.getUser());
                    preparedStatement.setString(2, user.getPassword());
                    preparedStatement.setString(3, user.getEmail());
                    preparedStatement.setString(4, user.getNom());
                    preparedStatement.setString(5, user.getPrenom());
                    preparedStatement.setString(6, user.getSexe());
                    preparedStatement.setTimestamp(7, Timestamp.valueOf(user.getDateNaissance()));

                    preparedStatement.executeUpdate();
                    ResultSet ids = preparedStatement.getGeneratedKeys();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(String User){
        try{
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "delete from dbsurvhei.survhei_user where User=?")) {
                    statement.setString(1, User);
                    statement.executeUpdate();
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getByIdName(String User, String Nom, String Prenom){
        int IdUsertodelete = 0;
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "select IDUser from dbsurvhei.survhei_user where User=? and Nom=? and Prenom=?")) {
                    statement.setString(1, User);
                    statement.setString(2, Nom);
                    statement.setString(3, Prenom);
                    try (ResultSet results = statement.executeQuery()) {
                       IdUsertodelete = results.getInt("IDUser");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return IdUsertodelete;
    }


    public boolean checkIfExist(String User){
        boolean exists = true;
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement("select * from dbsurvhei.survhei_user where User=?")) {
                    statement.setString(1, User);
                    try (ResultSet results = statement.executeQuery()) {
                        if (!results.next()) {
                            exists = false;
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Ce nom d'utilisateur est pris ? " +exists);
        return exists;
    }
}


