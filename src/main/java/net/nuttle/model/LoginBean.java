package net.nuttle.model;
public class LoginBean {

  /**
   * Simple example of a bean acting as an MVC model
   */
  private String userName;
  
  public LoginBean(String userName) {
    this.userName = userName;
  }
  
  public String getUserName() {
    return userName;
  }
}
