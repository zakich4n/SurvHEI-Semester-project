package controller.servlets;

import DAO.FormsDAO;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import service.FormsListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int temp=new FormsDAO().getAllFormulaireFromDB();

        String typeuser =(String) req.getSession().getAttribute("typeuser");
        String login = (String) req.getSession().getAttribute("login");
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        //resp.setContentType("text/html;charset=utf-8");
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        int randomID=FormsListService.getInstance().randomID();

        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("typeuser", typeuser);
        webContext.setVariable("login", login);
        webContext.setVariable("form", FormsListService.getInstance().getFormsByID(randomID));
        engine.process("Accueil", webContext, resp.getWriter());


    }

}
