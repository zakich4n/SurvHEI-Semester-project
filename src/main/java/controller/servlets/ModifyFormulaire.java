package controller.servlets;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class ModifyFormulaire extends SurvHEISurvlet{

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        int IDForm = Integer.parseInt(req.getParameter("id"));
        boolean Anonym=Boolean.parseBoolean(req.getParameter("Anonyme"));
        String title=req.getParameter("title");
        int temps=Integer.parseInt(req.getParameter("temps"));
        boolean actif=Boolean.parseBoolean(req.getParameter("actif"));
        int id_createur=Integer.parseInt(req.getParameter("id_createur"));


    }
}
