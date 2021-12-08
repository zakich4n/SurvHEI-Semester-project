package DAO;

import Formulaire.Formulaire;
import javax.sql.DataSource;
import java.sql.*;
import DAO.*;
import Formulaire.*;
import managers.FormsList;

import java.util.ArrayList;
import java.util.TreeMap;

public class FormsDAO {

    public int addFormulaireToDB(Formulaire formulaire) {
        int generatedId=0;
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
                    if (ids.next()) {
                        generatedId = ids.getInt(1);
                        formulaire.setID(generatedId);
                    }


                }

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return generatedId;
    }

    public int addPageToDB(Page page) {
        int generatedId=0;
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql = "INSERT INTO dbsurvhei.question(obligatoire, question, ordre_question, id_formulaire_correspondant) VALUES(?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setBoolean(1, page.getObligatoire());
                    preparedStatement.setString(2, page.getQuestion());
                    preparedStatement.setInt(3, page.getNumeroAsInt());
                    preparedStatement.setInt(4, page.getId_formulaire_correspondant());

                    preparedStatement.executeUpdate();
                    ResultSet ids = preparedStatement.getGeneratedKeys();
                    if (ids.next()) {
                        generatedId = ids.getInt(1);
                    }
                }

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return generatedId;
    }

    public int getAllFormulaireFromDB() {
        int NbFormulaire=0;
        PreparedStatement statementPages;
        FormsList FormsList= managers.FormsList.getInstance();
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                PreparedStatement statement  = connection.prepareStatement("SELECT COUNT(id_formulaire) as NombreFormulaire FROM formulaire;");
                try (ResultSet result = statement.executeQuery()) {
                    while(result.next()) {
                        NbFormulaire= result.getInt("NombreFormulaire");
                        statement  = connection.prepareStatement("SELECT * FROM formulaire;");
                        try(ResultSet result2 = statement.executeQuery()) {
                            while(result2.next()) {
                                FormsList.addFormulaireToList(
                                        result2.getInt("id_formulaire"),
                                        new Formulaire(result2.getBoolean("anonyme"),
                                                result2.getString("nom_formulaire"),
                                                new ArrayList<Page>(), result2.getInt("temps_moyen"),
                                                result2.getBoolean("actif"),
                                                result2.getInt("id_user_createur"))
                                );
                                FormsList.getFormsByID(result2.getInt("id_formulaire")).setID(result2.getInt("id_formulaire"));

                                statementPages=connection.prepareStatement("SELECT * FROM question where id_formulaire_correspondant="+result2.getInt("id_formulaire")+";");
                                try(ResultSet resultPage= statementPages.executeQuery()) {
                                    while(resultPage.next()) {
                                        FormsList.getFormsByID(result2.getInt("id_formulaire")).addQuestionsThroughFormulaire(
                                                new YesOrNO(resultPage.getInt("ordre_question"),
                                                        resultPage.getString("question"),
                                                        resultPage.getBoolean("obligatoire"),
                                                        resultPage.getInt("id_formulaire_correspondant")));
                                    }
                                }
                                //fin recuperation de formulaire
                            }
                        }
                    }
                }

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return NbFormulaire;
    }

    public boolean DeleteFormulaire(Formulaire formulaire) {
        FormsList FormsList= managers.FormsList.getInstance();
        int IDForm=formulaire.getID();
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM question WHERE id_formulaire_correspondant=?");
                preparedStatement.setString(1,String.valueOf(IDForm));
                System.out.println("Result of statement query"+preparedStatement);
                int result = preparedStatement.executeUpdate();
                System.out.println("Result of DELETE query "+result);
                PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM formulaire WHERE id_formulaire="+IDForm+";");
                preparedStatement2.executeUpdate();

                System.out.println("Project deleted with id = " + IDForm);
                connection.close();
                FormsList.deleteFromFormsList(IDForm);
                return true;


            }
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }

    public void editFormInDB(Formulaire formulaire) {
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql = "UPDATE survhei.formulaire t SET t.nom_formulaire=?, t.nombre_de_question=?, t.temps_moyen=?, t.actif=?, t.anonyme=?, t.id_user_createur=? WHERE t.id_formulaire =?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setInt(7, formulaire.getID());
                    preparedStatement.setString(1,formulaire.getTitle());
                    preparedStatement.setInt(2,formulaire.getNb_questions());
                    preparedStatement.setInt(3, formulaire.getTemps());
                    preparedStatement.setBoolean(4, formulaire.getActif());
                    preparedStatement.setBoolean(5, formulaire.getAnonyme());
                    preparedStatement.setInt(6, formulaire.getId_createur());


                    preparedStatement.executeUpdate();
                }

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void editPagesFromForm(int IDForm, Page page) {
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                String sql   = ("UPDATE survhei.question t SET t.question =?, t.obligatoire=? WHERE t.id_formulaire_correspondant=?");
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, page.getQuestion());
                    preparedStatement.setBoolean(2,page.getObligatoire());
                    preparedStatement.setInt(3,IDForm);
                    preparedStatement.executeUpdate();
                    }
                }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


}
