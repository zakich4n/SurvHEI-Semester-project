package classe;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/servlet/Membres")
public class Membres extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        /* NE PAS MODIFIER (Sauf indication)*/
        out.println("<!DOCTYPE html><html lang='fr'>");
        out.println("<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>");

        /* Titre de la page HTML */
        out.println("<title>Chat</title>");
        /* **************** */

        out.println("<link href='../style.css' rel='stylesheet'>");

        out.println("</head>");
        out.println("<body>");

        // authentifie ?
        HttpSession session = req.getSession(true);
        Personne p = (Personne)session.getAttribute("login");
        if (p==null) res.sendRedirect("Deconnect");

        Connection con=null;
        try {

            DS ds = new DS();

            // enregistrement du driver
            Class.forName(ds.getDriver());

            // connexion a la base
            con = DriverManager.getConnection(ds.getUrl(),ds.getName(),ds.getMdp());
            out.println("<nav id=membre>");

            out.println("<h1>Liste Membre</h1>");

            Statement stmt = con.createStatement();

            String query3 = "select * from users";
            ResultSet rs2 = stmt.executeQuery(query3);

            while (rs2.next()) {
                String login = rs2.getString("Login");
                if(!p.login.equals(login)) {
                    out.println("<div id=listm><a href='ChatPrive?receiver="+login+"'>"+login+"</a></div>");
                }
            }
            out.println("<br></br>");
            out.println("<a href='Menu'><button class='btn btn-default'>Retour au menu</button></a>");
            out.println("</nav>");

        }
        catch (Exception e){
            out.println("<div class='alert alert-warning' role='alert'>Erreur "+e.getClass()+" : "+e.getMessage()+"</div>");
        }
        finally{
            try{
                con.close();
            } catch (Exception e){

            }
        }
        out.println("</body></html>");

    }

}
