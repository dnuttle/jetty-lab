package net.nuttle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.nuttle.service.TimeService;

public class TestServlet extends HttpServlet {
  
  /**
   * 
   */
  private static final long serialVersionUID = 7844133669185091054L;
  private static final Logger LOG = LoggerFactory.getLogger(TestServlet.class);

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
    LOG.debug("Received GET in TestServlet");
    try {
      TimeService svc = (TimeService) getServletContext().getAttribute(TimeService.SERVICE_NAME);
      res.setContentType("text/html");
      PrintWriter w = res.getWriter();
      w.write("<!DOCTYPE html>");
      w.write("<head><title>Test Servlet</title></head>");
      w.write("<body>");
      w.write("<h2>Test Servlet Page</h2>");
      w.write("</body>");
      w.write("<html>");
      w.write("<p>Time: " + svc.getTime() + "</p>");
      w.write("</htmml>");
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

}
