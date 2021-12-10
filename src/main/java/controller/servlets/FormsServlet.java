package controller.servlets;


import Formulaire.Formulaire;
import service.FormsListService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.TreeMap;

@WebServlet("/forms")
public class FormsServlet extends SurvHEISurvlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeuser = (String) req.getSession().getAttribute("typeuser");
        String login = (String) req.getSession().getAttribute("login");
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        FormsListService frm= FormsListService.getInstance();
        int IDForm = Integer.parseInt(req.getParameter("id"));

        webContext.setVariable("pagesList", frm.getFormsByID(IDForm).getPages());
        webContext.setVariable("typeuser", typeuser);
        webContext.setVariable("login", login);
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("forms", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int IDForm = Integer.parseInt(req.getParameter("id"));
        FormsListService frm= FormsListService.getInstance();
        Formulaire temp=frm.getFormsByID(IDForm);
        TreeMap<Integer, Boolean> rep= new TreeMap<Integer, Boolean>();
        for(int i=1; i<temp.GetNumberOfPage(); i++) {
            rep.put(
                    temp.getPageNumber(i).getNumeroAsInt(),
                    Boolean.valueOf(req.getParameter((
                                        temp.getPageNumber(i).getNumero()
                    ))));
        }
        //ReponseList.getInstance().addReponse(new Reponse(temp, rep));
        resp.sendRedirect("forms?id="+req.getParameter("id"));
    }
}

