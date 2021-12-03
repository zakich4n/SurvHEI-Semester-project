package controller.servlets;


import DAO.Forms;
import Formulaire.Formulaire;
import Formulaire.Page;
import Formulaire.YesOrNO;
import managers.FormsList;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/forms")
public class FormsServlet extends SurvHEISurvlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        FormsList frm=new FormsList().getInstance();
        int IDForm = Integer.parseInt(req.getParameter("id"));
        frm.init();
        webContext.setVariable("pagesList", frm.getFormsByID(IDForm).getPages());

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("forms", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        int IDForm = Integer.parseInt(req.getParameter("id"));


    }
}
