package DAO;

import Formulaire.Formulaire;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Formulaire.*;
import managers.FormsList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Forms {


    public TreeMap getFormulaire(){
        ArrayList<String> ListIDForm=new ArrayList<String>();
        ArrayList<Boolean> ListAnonState=new ArrayList<Boolean>();
        ArrayList<Page> pages;
        try {
            DataSource dataSource = DataSourceProvider.getDataSource();
            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement1 = connection.prepareStatement("select * from Formualaire")) {
                    try (ResultSet results = statement1.executeQuery()) {
                        while (results.next()){
                            ListIDForm.add(results.getString("id_formulaire"));
                            ListAnonState.add(results.getBoolean("anonyme")); //A CHANGER
                        }
                        pages=new ArrayList<>();
                        for(int i=0;i<ListIDForm.size();i++) {
                            try(PreparedStatement statement2 = connection.prepareStatement("select * from Question where id_formulaire_correspondant="+ListIDForm.get(i))) {
                                try (ResultSet results2 = statement2.executeQuery()) {
                                    while(results2.next()) {
                                        pages.add(new YesOrNO(results2.getInt("ordre_question"), //A CHANGER
                                                            results.getString("Question"),//A CHANGER
                                                            results2.getBoolean("Obligatoire")));//A CHANGER
                                    } //pages full
                                    FormsList.getInstance().addForm(Integer.parseInt(ListIDForm.get(i)),new Formulaire(ListAnonState.get(i), pages));
                                }
                            }
                        } //fin creation des forms dans FormsList
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return FormsList.getInstance().getFormsList();
    }
}
