package net.nuttle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.nuttle.service.CommService;

public class SendServlet extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = -5995989411370091669L;
  private static final Logger LOG = LoggerFactory.getLogger(SendServlet.class);
  
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
    
    CommService svc = (CommService) getServletContext().getAttribute(CommService.SERVICE_NAME);
    if (svc != null) {
      try {
        String content = svc.ping(req.getParameter("in"));
        PrintWriter writer = res.getWriter();
        writer.write("<!DOCTYPE html><html><head><title>Send Servlet</title></head><body>");
        writer.write("<p>Content received: ");
        writer.write(content);
        writer.write("</p>");
        writer.write("</body></html>");
        LOG.debug("Response: " + content);
      } catch  (URISyntaxException | IOException e) {
        LOG.error("Failed to ping", e);
      }
    }
  }
}

