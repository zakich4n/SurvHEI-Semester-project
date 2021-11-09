package classes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;


@WebServlet("/servlet/New2")
public class New2 extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        /* NE PAS MODIFIER (Sauf indication)*/
        out.println("<!DOCTYPE html><html lang='fr'>");
        out.println("<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>");

        /* Titre de la page HTML */
        out.println("<title>Menu</title>");
        /* **************** */

        out.println("<link href='../style.css' rel='stylesheet'>");


        out.println("</head>");
        out.println("<body>");
        out.println("<div class='login-box2'>");
        out.println("<h2>Inscription</h2");

        Connection con=null;
        try
        {

            DS ds = new DS();

            // enregistrement du driver
            Class.forName(ds.getDriver());

            // connexion a la base
            con = DriverManager.getConnection(ds.getUrl(),ds.getName(),ds.getMdp());

            String login = req.getParameter("login");
            String mdp = ""/*Hash.toHexString(Hash.getSHA(req.getParameter("mdp")))*/;
            String nom = req.getParameter("nom");
            String prenom = req.getParameter("prenom");

            // Verification du login
            Statement stmt = con.createStatement();
            String query = "select * from users where login='"+ login + "'";
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()) {
                //out.println("<pre>Query : "+query+"</pre>");
                out.println("<div class='alert alert-danger' role='alert'>Le login "+ login +" est d�ja utilis�, veuillez en choisir un autre.");
                out.println("<a href='New'><button type='button' class='btn btn-default btn-lg'>Retour</button></a></div>");
                out.println("</div>");
            }
            else {
                String query2 = "insert into users values (";
                query2 += ("'"+login+"',");
                query2 += ("'"+mdp+"',");
                query2 += ("'"+nom+"',");
                query2 += ("'"+prenom+"',");
                query2 += ("'user')");

                //out.println("<pre>Query : "+query2+"</pre>");

                stmt.executeUpdate(query2);

                out.println("<div class='alert alert-success' role='alert'>Bienvenue " + prenom + ", ! Votre compte � bien �t� cr�� !");
                out.println("<a href='../login.html'><button type='button' class='btn btn-default btn-lg'>Connexion</button></a></div>");
                out.println("</div>");
            }
        }
        catch (Exception e) {
            out.println("<div class='alert alert-warning' role='alert'>Erreur "+e.getClass()+" : "+e.getMessage()+"</div>");
        }
        finally{
            try {
                con.close();
            } catch (Exception e){

            }
        }

        out.println("</body></html>");

    }
}