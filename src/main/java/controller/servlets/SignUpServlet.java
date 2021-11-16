package controller.servlets;

import entity.Utilisateur;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import controller.webservices.MotDePasseUtils;
import service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("SignUp", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("User");
        String email = request.getParameter("Email");
        String lastName = request.getParameter("Nom");
        String firstName = request.getParameter("prenom");
        String dateBirthString = request.getParameter("DateNaissance");
        String genre = request.getParameter("genre");
        String password = request.getParameter("Password");
        String passwordc = request.getParameter("Passwordc");

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateBirth  = LocalDate.parse(dateBirthString, dateFormat).atStartOfDay();

        if(!passwordc.equals(password)){
            response.sendRedirect("SignUp");
        } else {
            password = MotDePasseUtils.genererMotDePasse(passwordc);
            Utilisateur user = new Utilisateur(1, login, password, email, lastName, firstName, dateBirth, genre );
            LoginService.getInstance().addUser(user);
            response.sendRedirect("connexion");
        }
    }
}
