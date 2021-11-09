package Connexion;

import entities.Utilisateur;
import impl.DataSourceProvider;
import utils.MotDePasseUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private MotDePasseUtils motDePasseUtils = new MotDePasseUtils();

    public boolean valider(Utilisateur utilisateur){
        boolean res = false;

        try {
            DataSource dataSource = DataSourceProvider.getDataSource();


            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement("select * from survhei_user where User=?")) {
                    statement.setString(1, utilisateur.getUser());
                    try (ResultSet results = statement.executeQuery()) {
                        while (results.next()){
                            String mdphash = results.getString("Password");
                            if (motDePasseUtils.validerMotDePasse(utilisateur.getPassword(),mdphash) ){
                                res = true;
                            }
                        }
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
