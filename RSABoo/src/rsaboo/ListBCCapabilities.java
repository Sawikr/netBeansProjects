package rsaboo;

import java.security.Provider;
import java.security.Security;
import java.util.Iterator;

/**
 * Wypisuje udost�pniane przez dostawc� BC algorytmy szyfrowania, uzgadniania klucza, kod�w MAC,
 * skr�t�w, podpis�w i inne.
 */
public class ListBCCapabilities
{
    public static void main(String[] args)
    {
        Provider  provider = Security.getProvider("BC");
        Iterator  it = provider.keySet().iterator();
        
        while (it.hasNext())
        {
            String entry = (String)it.next();
            
            // je�li wpis odwo�uje si� do innego wpisu
            
            if (entry.startsWith("Alg.Alias."))
            {
                entry = entry.substring("Alg.Alias.".length());
            }
            
            String factoryClass = entry.substring(0, entry.indexOf('.'));
            String name = entry.substring(factoryClass.length() + 1);

            System.out.println(factoryClass + ": " + name);
        }
    }
}