package net.nuttle.context;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.nuttle.service.CommService;
import net.nuttle.service.TimeService;

public class TestContextListener implements ServletContextListener {

  private static final Logger LOG = LoggerFactory.getLogger(TestContextListener.class);

  @Override
  public void contextInitialized(ServletContextEvent evt) {
    TimeService svc = new TimeService();
    evt.getServletContext().setAttribute(TimeService.SERVICE_NAME, svc);
    LOG.info("Registered test service");
    CommService commSvc = new CommService(evt.getServletContext().getContextPath() + "/receive");
    evt.getServletContext().setAttribute(CommService.SERVICE_NAME, commSvc);
    LOG.info("Registered comm service");
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent evt) {
    TimeService svc = (TimeService) evt.getServletContext().getAttribute(TimeService.SERVICE_NAME);
    if (svc != null) {
      svc.cleanup();
    }
  }
}
