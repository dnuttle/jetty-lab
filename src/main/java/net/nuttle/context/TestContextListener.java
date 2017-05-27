package net.nuttle.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.nuttle.service.TimeService;

public class TestContextListener implements ServletContextListener {


  @Override
  public void contextInitialized(ServletContextEvent evt) {
    TimeService svc = new TimeService();
    evt.getServletContext().setAttribute(TimeService.SERVICE_NAME, svc);
    System.out.println("Registered test service");
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent evt) {
    TimeService svc = (TimeService) evt.getServletContext().getAttribute(TimeService.SERVICE_NAME);
    if (svc != null) {
      svc.cleanup();
    }
  }
}
