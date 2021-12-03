package controller.servlets;

import DAO.CreateFormDao;
import entity.Question;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import service.CreateFormService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/CreateFormulaire")
public class CreateFormulaireServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("createform", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Récupération de l'id du formulaire
        int NewformulaireId =(int) request.getSession().getAttribute("NewFormulaireId");

        //Récupération des informations pour la question 1
        String q1 = request.getParameter("Q1");
        boolean cq1;
        if (request.getParameter("cQ1") == null) {
            cq1 = false;
        } else {
            cq1 = true;
        }

        Question Q1 = new Question(q1, 1, NewformulaireId, cq1);
        CreateFormService.getInstance().AddQuestion(Q1);

        //Récupération des informations de la question 2
        String q2 = request.getParameter("Q2");
        boolean cq2;
        if (request.getParameter("cQ2") == null) {
            cq2 = false;
        } else {
            cq2 = true;
        }

        Question Q2 = new Question(q2, 2, NewformulaireId, cq2);
        CreateFormService.getInstance().AddQuestion(Q2);

        //Récupération des informations de la question 3
        String q3 = request.getParameter("Q3");
        boolean cq3;
        if (request.getParameter("cQ3") == null) {
            cq3 = false;
        } else {
            cq3 = true;
        }

        Question Q3 = new Question(q3, 3, NewformulaireId, cq3);
        CreateFormService.getInstance().AddQuestion(Q3);

    }
}
