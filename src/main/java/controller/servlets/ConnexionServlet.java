package controller.servlets;

import entity.Utilisateur;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import controller.tools.MotDePasseUtils;
import service.UserService;

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

        String typeuser =(String) req.getSession().getAttribute("typeuser");
        String login =(String) req.getSession().getAttribute("login");

        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        engine.addDialect(new Java8TimeDialect());

        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("login", login);
        context.setVariable("typeuser", typeuser);

        if (typeuser == null){
            engine.process("pagelogin", context, resp.getWriter());
        } else {
            engine.process("Accueil", context, resp.getWriter());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("login");
        String motDePasse = req.getParameter("mdp");

        Utilisateur utilisateur= new Utilisateur(user, motDePasse);

        if (UserService.getInstance().valider(utilisateur)[0]==1 || UserService.getInstance().valider(utilisateur)[0]==2) {
            req.getSession().setAttribute("login",user);

            req.getSession().setAttribute("iduser", UserService.getInstance().valider(utilisateur)[1]);

            req.getSession().setAttribute("typeuser", Integer.toString(UserService.getInstance().valider(utilisateur)[0]));

            resp.sendRedirect("connexion");
        }
    }
}
