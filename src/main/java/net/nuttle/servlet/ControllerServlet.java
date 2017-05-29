package net.nuttle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerServlet extends HttpServlet {

  private static final Logger LOG = LoggerFactory.getLogger(ControllerServlet.class);
  /**
   * 
   */
  private static final long serialVersionUID = -464794457541905051L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    LOG.debug("Received request in ControllerServlet at " + req.getServletPath());
    String path = req.getServletPath();
    try {
      switch (path) {
      case "/login.web":
        LOG.debug("Redirecting to /login-success");
        getServletContext().getRequestDispatcher("/login-success").forward(req, res);
        break;
      default:
        res.setStatus(HttpStatus.SC_NOT_FOUND);
      }
    } catch (IOException | ServletException e) {
      e.printStackTrace();
    }
  }
}
