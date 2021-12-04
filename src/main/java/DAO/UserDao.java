package DAO;

import entity.Utilisateur;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

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

    public static void deleteUser(int IDUser){
        try{
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "delete from dbsurvhei.survhei_user where IDUser=?")) {
                    statement.setInt(1, IDUser);
                    statement.executeUpdate();
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
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


    public List<Utilisateur> listAllUser() {
        List<Utilisateur> listOfUser = new ArrayList<>();
        try{
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                try (Statement statement = connection.createStatement()) {
                    try (ResultSet results = statement.executeQuery("select * from survhei_user")) {
                        while (results.next()) {
                            Utilisateur user = new Utilisateur(
                                    results.getInt("IDUser"),
                                    results.getString("User"),
                                    results.getString("Nom"),
                                    results.getString("Prenom"),
                                    results.getBoolean("IsAdmin"),
                                    results.getString("email"));
                            listOfUser.add(user);
                        }
                    }
                }
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return listOfUser;
    }
}
