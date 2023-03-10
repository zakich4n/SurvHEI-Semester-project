package controller.servlets;

import DAO.FormsDAO;
import Formulaire.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/NewFormulaire")
public class NewFormulaireServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeuser =(String) req.getSession().getAttribute("typeuser");
        String login = (String) req.getSession().getAttribute("login");
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("typeuser", typeuser);
        context.setVariable("login", login);
        engine.process("NewFormulaire", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Récupération de l'id du user connecté
        int iduser =(Integer) request.getSession().getAttribute("iduser");

        //Récupération des informations sur le nouveau formulaire
        String title = request.getParameter("nameform");
        String StringTemps = request.getParameter("timeform");
        int temps = Integer.parseInt(StringTemps);
        boolean anonyme;
        if (request.getParameter("cnameform")==null){
            anonyme = false;
        }else{
            anonyme = true;
        }
                                            //title, 3, temps, true, anonyme, iduser
        Formulaire formulaire = new Formulaire(anonyme, title,new ArrayList<Page>(),temps, true,iduser);
        int NewFormulaireId = new FormsDAO().addFormulaireToDB(formulaire);
        request.getSession().setAttribute("NewFormulaireId", NewFormulaireId);

        response.sendRedirect("CreateFormulaire?idFormulaire="+NewFormulaireId);

    }
}
