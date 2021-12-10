package controller.servlets;

import DAO.FormsDAO;
import Formulaire.Formulaire;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import service.FormsListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
@WebServlet("/FormulaireEdit")
public class EditFormulaireServlet extends SurvHEISurvlet{
    //     FormulaireEdit?id=53
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int NbForms= new FormsDAO().getAllFormulaireFromDB();
        int IDForm= Integer.parseInt(req.getParameter("id"));
        Formulaire form=FormsListService.getInstance().getFormsByID(IDForm);
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
        //nameform=pitie&cnameform=on&timeform=4444
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data = br.readLine();
        System.out.println(data);
        String[] data2= data.split("&");
        ArrayList<String[]> parameter= new ArrayList<>();
        for(int i=0; i<3; i++) {
            parameter.add(data2[i].split("="));
        }
        System.out.println(parameter.get(0)[1]);
        System.out.println(parameter.get(1)[1]);
        System.out.println(parameter.get(2)[1]);
        String title=parameter.get(0)[1];
        String anonS=parameter.get(1)[1];
        Boolean anon=true;
        switch (anonS) {
            case "on" :
                anon=true;
            case "off" :
                anon=false;
            default:
                anon=false;
        }
        int Temps=Integer.parseInt(parameter.get(2)[1]);
        FormsListService.getInstance().getFormsByID(IDForm).setTitle(title);
        FormsListService.getInstance().getFormsByID(IDForm).setAnonyme(false);
        FormsListService.getInstance().getFormsByID(IDForm).setTemps(Temps);
        new FormsDAO().editFormInDB(FormsListService.getInstance().getFormsByID(IDForm));
        new FormsDAO().getAllFormulaireFromDB();
        Formulaire form=FormsListService.getInstance().getFormsByID(IDForm);
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("form", form);
        context.setVariable("action","changed");
        //context.setVariable("UserType",UserType);

        TemplateEngine engine = createTemplateEngine(req.getServletContext());
        engine.process("NewFormulaire", context, resp.getWriter());


    }
}
