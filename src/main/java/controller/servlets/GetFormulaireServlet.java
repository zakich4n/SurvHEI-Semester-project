package controller.servlets;

import DAO.FormsDAO;
import Formulaire.Formulaire;
import service.FormsListService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
        Collection<Formulaire> formList = FormsListService.getInstance().getFormsList().values();
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
        new FormsDAO().DeleteFormulaire(FormsListService.getInstance().getFormsByID(IDForm));
    }



}
