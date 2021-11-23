package controller.servlets;


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

        int IDForm = Integer.parseInt(req.getParameter("id"));



        //Creation de 3 question/page
        Page une=new YesOrNO(1,"Etes vous beau ?",true);
        Page deux=new YesOrNO(2,"Etes vous sur ??",true);
        Page trois=new YesOrNO(3,"Mentez vous un tout petit peu ??",true);
        ArrayList<Page> pages=new ArrayList<>();
        pages.add(une); pages.add(deux); pages.add(trois);


 //       Formulaire form=new Formulaire(true,pages);
 //       FormsList.getInstance().addForm(form);
        webContext.setVariable("pagesList", pages);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("forms", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
