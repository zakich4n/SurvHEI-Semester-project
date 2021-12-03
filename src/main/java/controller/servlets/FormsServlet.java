package controller.servlets;


import DAO.Forms;
import Formulaire.Formulaire;
import Formulaire.Page;
import Formulaire.YesOrNO;
import Reponse.Reponse;
import managers.FormsList;
import managers.ReponseList;
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
import java.util.TreeMap;

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
        FormsList frm=new FormsList().getInstance();
        Formulaire temp=frm.getFormsByID(IDForm);
        TreeMap<Integer, Boolean> rep= new TreeMap<Integer, Boolean>();
        for(int i=1; i<temp.GetNumberOfPage(); i++) {
            rep.put(
                    temp.getPageNumber(i).getNumeroAsInt(),
                    Boolean.valueOf(req.getParameter((
                                        temp.getPageNumber(i).getNumero()
                    ))));
        }
        ReponseList.getInstance().addReponse(new Reponse(temp, rep));
        resp.sendRedirect("forms?id="+req.getParameter("id"));
    }
}

//forms?id=2' \
//1=Non&2F=Oui&Envoyer=Envoyer
