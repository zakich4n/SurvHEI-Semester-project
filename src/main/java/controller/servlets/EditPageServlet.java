package controller.servlets;

import DAO.FormsDAO;
import Formulaire.Formulaire;
import managers.FormsList;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/Formulaire/Page/edit")
public class EditPageServlet extends SurvHEISurvlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int NbForms= new FormsDAO().getAllFormulaireFromDB();
        String UserType=(String) req.getSession().getAttribute("typeuser");
        WebContext context = new WebContext(req, resp, req.getServletContext());
        Collection<Formulaire> formList = FormsList.getInstance().getFormsList().values();

        context.setVariable("formList", formList);
        context.setVariable("NbForms",NbForms);
        context.setVariable("action","edit");
        TemplateEngine engine = createTemplateEngine(req.getServletContext());
        engine.process("NewFormulaire", context, resp.getWriter());

    }
}
