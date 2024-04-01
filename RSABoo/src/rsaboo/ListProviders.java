package rsaboo;

import java.security.Provider;
import java.security.Security;

/**
 * Wypisuje dostawców zainstalowanych w bieżącym środowisku uruchomieniowym Javy.
 */
public class ListProviders
{
    public static void main(
        String[] args)
    {
        Provider[] providers = Security.getProviders();
        
        for (int i = 0; i != providers.length; i++)
        {
            System.out.println("Nazwa: " + providers[i].getName() + UtilsFirst.makeBlankString(15 - providers[i].getName().length())+ " Wersja: " + providers[i].getVersion());
        }
    }
}