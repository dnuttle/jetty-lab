package net.nuttle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.nuttle.model.LoginBean;
import net.nuttle.model.ModelConstants;

/**
 * Simple MVC model servlet
 * The role of this servlet is to create the model (a bean)
 * and then forward request on to a view which consumes the model.
 * @author Dan
 *
 */
public class LoginSuccessServlet extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 4737989186747359074L;
  private static final Logger LOG = LoggerFactory.getLogger(LoginSuccessServlet.class);

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    LOG.debug("Request received at LoginSuccessServlet");
    LoginBean login = new LoginBean("testuser");
    req.setAttribute(ModelConstants.LOGIN_MODEL, login);
    req.getRequestDispatcher("views/login-success.jsp").forward(req, res);
    /*
    res.setContentType("text/html");
    PrintWriter writer = res.getWriter();
    writer.write("<!DOCTYPE html><head><title>Login Success</title></head><body>");
    writer.write("<h2>Login Success</h2>");
    writer.write("</body></html>");
    */
  }
}
