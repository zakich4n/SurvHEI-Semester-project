package Servlets;

import DAO.Login;
import entities.Utilisateur;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/connexionfailed")
public class ConnexionFailedServlet extends HttpServlet {
    private Login login;

    public void init() {
        login = new Login();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("pageloginfailed", context, resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("login");
        String motDePasse = req.getParameter("mdp");

        if (user == null || motDePasse == null) {
            resp.sendRedirect("connexionfailed");

        } else {
            Utilisateur utilisateur = new Utilisateur(user, motDePasse);
            if (login.valider(utilisateur)) {

                resp.sendRedirect("Accueil");
            } else {
                resp.sendRedirect("connexionfailed");
            }
        }


    }
}
