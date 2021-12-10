package controller.servlets;

import DAO.FormsDAO;
import Formulaire.Formulaire;
import managers.FormsList;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/Formulaire")
public class GetFormulaireServlet extends SurvHEISurvlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int NbForms= new FormsDAO().getAllFormulaireFromDB();
        String UserType=(String) req.getSession().getAttribute("typeuser");
        String login = (String) req.getSession().getAttribute("login");

        WebContext context = new WebContext(req, resp, req.getServletContext());
        Collection<Formulaire> formList = FormsList.getInstance().getFormsList().values();
        context.setVariable("typeuser", UserType);
        context.setVariable("login", login);
        context.setVariable("formList", formList);
        context.setVariable("NbForms",NbForms);
        context.setVariable("UserType",UserType);
        TemplateEngine engine = createTemplateEngine(req.getServletContext());
        engine.process("Formulaires", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int IDForm = Integer.parseInt(req.getParameter("id"));
        new FormsDAO().DeleteFormulaire(FormsList.getInstance().getFormsByID(IDForm));
    }



}
