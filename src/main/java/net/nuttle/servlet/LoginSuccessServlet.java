package net.nuttle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSuccessServlet extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 4737989186747359074L;
  private static final Logger LOG = LoggerFactory.getLogger(LoginSuccessServlet.class);

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    try {
      LOG.debug("Request received at LoginSuccessServlet");
      res.setContentType("text/html");
      PrintWriter writer = res.getWriter();
      writer.write("<!DOCTYPE html><head><title>Login Success</title></head><body>");
      writer.write("<h2>Login Success</h2>");
      writer.write("</body></html>");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
