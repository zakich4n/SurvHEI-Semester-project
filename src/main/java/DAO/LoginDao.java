package DAO;

import entity.Utilisateur;
import controller.webservices.MotDePasseUtils;
import jdk.jshell.execution.Util;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
    private MotDePasseUtils motDePasseUtils = new MotDePasseUtils();

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

}


