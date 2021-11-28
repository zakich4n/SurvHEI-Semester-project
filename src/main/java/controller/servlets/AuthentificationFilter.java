package controller.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/prive/*")
public class AuthentificationFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String identifiant = (String) httpRequest.getSession().getAttribute("login");
    if (identifiant == null || "".equals(identifiant)) {
      HttpServletResponse httpResponse = (HttpServletResponse) response;
      httpResponse.sendRedirect("../connexion");
      return;
    }
    chain.doFilter(request, response);

  }

  @Override
  public void destroy() {

  }
}
