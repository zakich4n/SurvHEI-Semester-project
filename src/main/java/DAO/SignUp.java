package DAO;

import impl.DataSourceProvider;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;

public class SignUp {


    public static void addUser(String User, String Password, String Email, String Nom, String Prenom, String Sexe) {

        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql = "INSERT INTO dbsurvhei.survhei_user (User, Password, Email, Nom, Prenom, Sexe) VALUES(?,?,?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, User);
                    preparedStatement.setString(2, Password);
                    preparedStatement.setString(3, Email);
                    preparedStatement.setString(4, Nom);
                    preparedStatement.setString(5, Prenom);
                    preparedStatement.setString(6, Sexe);
                    /*preparedStatement.setTimestamp(7, Timestamp.valueOf(DateBirth));*/

                    preparedStatement.executeUpdate();
                    ResultSet ids = preparedStatement.getGeneratedKeys();
                }

            }
        }catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
