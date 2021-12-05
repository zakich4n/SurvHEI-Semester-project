package controller.servlets;

import DAO.FormsDAO;
import Formulaire.*;
import managers.FormsList;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/CreateFormulaire")
public class CreateFormulaireServlet extends SurvHEISurvlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        int IDForm= Integer.parseInt(req.getParameter("idFormulaire"));
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("IDForm", IDForm);

        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("createform", webContext, resp.getWriter());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new FormsDAO().getAllFormulaireFromDB();
        int IDForm= Integer.parseInt(req.getParameter("idFormulaire"));
        Formulaire form= FormsList.getInstance().getFormsByID(IDForm);
        int NbQuestions=Integer.parseInt(req.getParameter("NBQuestions"));
        String QX= "";
        for(int i=0; i<NbQuestions; i++) {
            QX=req.getParameter("Q"+(i+1));
            form.addQuestionsThroughFormulaire(new YesOrNO(i+1,QX,
                    Boolean.parseBoolean(req.getParameter("cQ"+(i+1))),IDForm));
        }
        resp.sendRedirect("forms?id="+IDForm+"&submitted=true");
    }
}
