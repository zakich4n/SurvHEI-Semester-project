package DAO;

import entity.Utilisateur;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;

public class SignUp {


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
        }catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
