package rsaboo;

import java.security.Security;

/**
 * Prosta klasa sprawdzaj�ca, czy dostawca Bouncy Castle jest zainstalowany.
 */
public class SimpleProviderTest
{
    public static void main(String[] args)
    {
        String providerName = "BC";
        
        if (Security.getProvider(providerName) == null)
        {
            System.out.println("Dostawca " + providerName + " nie jest zainstalowany");
        }
        else
        {
            System.out.println("Dostawca " + providerName + " jest zainstalowany");
        }
    }
}