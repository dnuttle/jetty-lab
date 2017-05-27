package net.nuttle.service;

/**
 * Just a very simple example service that returns current time
 * @author Dan
 *
 */
public class TimeService {

  public static final String SERVICE_NAME = "test_service";

  public long getTime() {
    return System.currentTimeMillis();
  }
  
  public void cleanup() {
    //Could be any necessary steps to cleanup/stop a service
  }
}
