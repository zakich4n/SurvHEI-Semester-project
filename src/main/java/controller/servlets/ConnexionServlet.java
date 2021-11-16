package controller.servlets;

import entity.Utilisateur;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import controller.webservices.MotDePasseUtils;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
    private MotDePasseUtils mdp = new MotDePasseUtils();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("pagelogin", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("login");
        String motDePasse = req.getParameter("mdp");


        if (user==null || motDePasse==null){
            resp.sendRedirect("connexionfailed");

        }else{
            Utilisateur utilisateur= new Utilisateur(user, motDePasse);
            if (LoginService.getInstance().valider(utilisateur)) {
                req.getSession().setAttribute("login",user);
                resp.sendRedirect("Accueil");
            } else {
                resp.sendRedirect("connexionfailed");
            }
        }
    }
}
