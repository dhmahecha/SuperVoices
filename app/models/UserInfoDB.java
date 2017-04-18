package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides an in-memory repository for UserInfo.
 * Storing credentials in the clear is kind of bogus.
 * @author Philip Johnson
 */
public class UserInfoDB {
  
  private static Map<String, User> userinfos = new HashMap<String, User>();
  
  /**
   * Adds the specified user to the UserInfoDB.
   * @param name Their name.
   * @param email Their email.
   * @param password Their password. 
   */
  /*public static void addUserInfo(String name, String email, String password) {
    userinfos.put(email, new User(name, email, password));
  }*/
  
  /**
   * Returns true if the email represents a known user.
   * @param email The email.
   * @return True if known user.
   */
  public static boolean isUser(String username) {
    return userinfos.containsKey(username);
  }

  /**
   * Returns the UserInfo associated with the email, or null if not found.
   * @param email The email.
   * @return The UserInfo.
   */
  public static User getUser(String username) {
    return userinfos.get((username == null) ? "" : username);
  }

  /**
   * Returns true if email and password are valid credentials.
   * @param email The email. 
   * @param password The password. 
   * @return True if email is a valid user email and password is valid for that email.
   */
  public static boolean isValid(String username, String password) {
    return ((username != null) 
            &&
            (password != null) 
            &&
            isUser(username) 
            &&
            getUser(username).getPassword().equals(password));
  }
}
