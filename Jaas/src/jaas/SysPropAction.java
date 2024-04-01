package jaas;

import java.security.*;

/**
 * Wyszukuje w³aœciwoœæ systemow¹.
 */
public class SysPropAction implements PrivilegedAction<String>
{
   private String propertyName;

   /**
    * Konstruktor.
    * @param propertyName nazwa w³aœciwoœci (na przyk³ad "user.home")
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
