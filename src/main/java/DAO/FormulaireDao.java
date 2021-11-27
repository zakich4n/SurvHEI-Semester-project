package DAO;

import entity.Formulaire;

import javax.sql.DataSource;
import java.sql.*;

public class FormulaireDao {


    public void AddFormulaire(Formulaire formulaire){
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql = "INSERT INTO dbsurvhei.formulaire (nom_formulaire, nombre_de_question, temps_moyen, actif, anonyme, id_user_createur) VALUES(?,?,?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, formulaire.getTitle());
                    preparedStatement.setInt(2,formulaire.getNb_questions() );
                    preparedStatement.setInt(3, formulaire.getTemps());
                    preparedStatement.setBoolean(4, formulaire.getActif());
                    preparedStatement.setBoolean(5, formulaire.getAnonyme());
                    preparedStatement.setInt(6, formulaire.getId_createur());

                    preparedStatement.executeUpdate();
                    ResultSet ids = preparedStatement.getGeneratedKeys();
                }

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
