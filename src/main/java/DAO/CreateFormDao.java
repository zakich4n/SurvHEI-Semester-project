package DAO;

import Formulaire.*;

import javax.sql.DataSource;
import java.sql.*;

public class CreateFormDao {

    public void AddQuestion(Page question){
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql = "INSERT INTO question (question, ordre_question, id_formulaire_correspondant, obligatoire) VALUES(?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, question.getQuestion());
                    preparedStatement.setInt(2,question.getOrdre_question() );
                    preparedStatement.setInt(3, question.getId_formulaire_correspondant());
                    preparedStatement.setBoolean(4, question.getObligatoire());

                    preparedStatement.executeUpdate();
                    ResultSet ids = preparedStatement.getGeneratedKeys();
                }

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

}
