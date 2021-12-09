package controller.servlets;

import DAO.FormsDAO;
import Formulaire.Formulaire;
import managers.FormsList;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
@WebServlet("/FormulaireEdit")
public class EditFormulaireServlet extends SurvHEISurvlet{
    //     FormulaireEdit?id=53
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int NbForms= new FormsDAO().getAllFormulaireFromDB();
        int IDForm= Integer.parseInt(req.getParameter("id"));
        Formulaire form=FormsList.getInstance().getFormsByID(IDForm);
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("form", form);
        context.setVariable("action","edit");
        //context.setVariable("UserType",UserType);

        TemplateEngine engine = createTemplateEngine(req.getServletContext());
        engine.process("NewFormulaire", context, resp.getWriter());

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int IDForm = Integer.parseInt(req.getParameter("id"));
        String title= req.getParameter("nameform");
        Boolean anon=Boolean.parseBoolean(req.getParameter("cnameform"));
        int Temps=Integer.parseInt(req.getParameter("timeform"));
        FormsList.getInstance().getFormsByID(IDForm).setTitle(title);
        FormsList.getInstance().getFormsByID(IDForm).setAnonyme(anon);
        FormsList.getInstance().getFormsByID(IDForm).setTemps(Temps);
        new FormsDAO().editFormInDB(FormsList.getInstance().getFormsByID(IDForm));
        new FormsDAO().getAllFormulaireFromDB();
        Formulaire form=FormsList.getInstance().getFormsByID(IDForm);
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("form", form);
        context.setVariable("action","changed");
        //context.setVariable("UserType",UserType);

        TemplateEngine engine = createTemplateEngine(req.getServletContext());
        engine.process("NewFormulaire", context, resp.getWriter());


    }
}
