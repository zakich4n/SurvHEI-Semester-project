package DAO;

import Formulaire.Formulaire;
import javax.sql.DataSource;
import java.sql.*;
import DAO.*;
import Formulaire.*;
import Reponse.Reponse;
import managers.FormsList;

import java.util.ArrayList;
import java.util.TreeMap;
public class ReponseDAO {


    public void addReponseToDB(Reponse reponse) {
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql = "INSERT INTO reponse (id_question, id_user, reponse_oui_non) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setInt(1, reponse.getIDQuestion());
                    preparedStatement.setInt(2,reponse.getIDUer());
                    preparedStatement.setBoolean(3, reponse.getReponse());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
