package net.nuttle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiveServlet extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = -1224359589498249915L;
  
  private static Logger LOG = LoggerFactory.getLogger(ReceiveServlet.class);
  
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
    String in = req.getParameter("in");
    try {
      PrintWriter writer = res.getWriter();
      if (StringUtils.isEmpty(in)) {
        res.setStatus(HttpStatus.SC_BAD_REQUEST);
        res.flushBuffer();
        return;
      }
      res.setContentType("text/html");
      writer.write("Request received");
      writer.write(" (in=" + in + ")");
      LOG.debug("Request received");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
