package controller.servlets;

import DAO.SignUp;
import entity.Utilisateur;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import controller.webservices.MotDePasseUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/forms")
public class FormsServlet extends SurvHEISurvlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idForms= Integer.parseInt(req.getParameter("id"));
        TemplateEngine templateEngine=createTemplateEngine(req.getServletContext());

        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        // on récupère le film via la méthode getFilm de la classe FilmService
        // et on stocke le film dans le contexte dans la variable film
        //webContext.setVariable("forms", );

        // on génère la page à partir du template film et du contexte, on écrit le résultat dans le flux de la réponse http
        templateEngine.process("forms", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
