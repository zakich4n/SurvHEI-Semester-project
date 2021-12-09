package DAO;

import Formulaire.Formulaire;
import javax.sql.DataSource;
import java.sql.*;
import DAO.*;
import Formulaire.*;
import Reponse.Reponse;
import managers.FormsList;
import managers.PageList;
import managers.ReponseList;

import java.util.ArrayList;
import java.util.TreeMap;
public class ReponseDAO {


    public int addReponseToDB(Reponse reponse) {
        int rowsAffedted=0;
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql = "INSERT INTO reponse (id_question, id_user, reponse_oui_non) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setInt(1, reponse.getIDQuestion());
                    preparedStatement.setInt(2, reponse.getIDUer());
                    preparedStatement.setBoolean(3, reponse.getReponse());
                    preparedStatement.executeUpdate();
                    ResultSet ids = preparedStatement.getResultSet();
                    if (ids.next()) {
                        rowsAffedted = ids.getInt(1);

                        return rowsAffedted;
                    }
                }
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rowsAffedted;
    }
        public void getAllReponseFromDB() {
            ReponseList rep=ReponseList.getInstance();
            PageList page=PageList.getInstance();
            try {
                DataSource dataSource = DataSourceProvider.getDataSource();
                try (Connection connection = dataSource.getConnection()) {
                    PreparedStatement statement  = connection.prepareStatement("SELECT COUNT(id_question) as NombreReponse FROM reponse;");
                    try (ResultSet result = statement.executeQuery()) {
                        while(result.next()) {
                            int NombreReponse= result.getInt("NombreReponse");
                            statement  = connection.prepareStatement("SELECT * FROM reponse;");
                            try(ResultSet result2 = statement.executeQuery()) {
                                while(result2.next()) {
                                    rep.getReponseList().put(
                                            page.getPageList().get(result2.getInt("id_question")),
                                            new Reponse(result2.getInt("id_user"),result2.getInt("id_question"),result2.getBoolean("reponse_oui_non") )
                                    );
                                }
                            }
                        }
                    }

                }
            } catch (SQLException e) {

                e.printStackTrace();
            }

        }


    }

