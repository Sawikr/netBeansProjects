package jaas;

import java.security.*;

/**
 * Wyszukuje właściwość systemową.
 */
public class SysPropAction implements PrivilegedAction<String>
{
   private String propertyName;

   /**
    * Konstruktor.
    * @param propertyName nazwa właściwości (na przykład "user.home")
    */
   public SysPropAction(String propertyName)
   {
      this.propertyName = propertyName;
   }

   public String run()
   {
      return System.getProperty(propertyName);
   }
}
