package controller.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public abstract class SurvHEISurvlet extends HttpServlet {

    protected TemplateEngine createTemplateEngine(ServletContext servletContext) {
        // Création du resolver pour récupérer les templates
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");

        // Création du moteur de template auquel on assigne le resolver
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        // ajout du dialect java8Time pour gérer les dates java8
        templateEngine.addDialect(new Java8TimeDialect());

        // on retourne le moteur de template pour que chaque servlet appelante puisse positionner le context
        // et appeler la méthode process sur le bon template
        return templateEngine;
    }
}
