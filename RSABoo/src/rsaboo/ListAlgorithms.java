package rsaboo;

import java.security.Provider;
import java.security.Security;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListAlgorithms
{
    /**
     * Wypisuje wpisy z przekazanego zbioru w osobnych wierszach z odpowiednimi wci�ciami,
     * przy czym nazwa zbioru jest wypisywana w pierwszym wierszu bez wci�cia.
     * 
     * @param setName nazwa wypisywanego zbioru.
     * @param algorithms zbi�r algorytm�w skojarzonych z podan� nazw�.
     */
    public static void printSet(
        String setName,
        Set	   algorithms)
    {
        System.out.println(setName + ":");
        
        if (algorithms.isEmpty())
        {
            System.out.println("            Brak dost�pnych algorytm�w.");
        }
        else
        {
            Iterator	it = algorithms.iterator();
            
            while (it.hasNext())
            {
                String	name = (String)it.next();
                
                System.out.println("            " + name);
            }
        }
    }
    
    /**
     * Wypisuje dost�pne algorytmy szyfrowania, uzgadniania klucza, kod�w MAC,
     * skr�t�w wiadomo�ci i podpis�w.
     */
    public static void main(
        String[]    args)
    {
        Provider[]	providers = Security.getProviders();
        Set			ciphers = new HashSet();
        Set			keyAgreements = new HashSet();
        Set			macs = new HashSet();
        Set			messageDigests = new HashSet();
        Set			signatures = new HashSet();
        
        for (int i = 0; i != providers.length; i++)
        {
            Iterator  it = providers[i].keySet().iterator();
            
            while (it.hasNext())
            {
                String	entry = (String)it.next();
                
                if (entry.startsWith("Alg.Alias."))
                {
                    entry = entry.substring("Alg.Alias.".length());
                }
                
                if (entry.startsWith("Cipher."))
                {
                    ciphers.add(entry.substring("Cipher.".length()));
                }
                else if (entry.startsWith("KeyAgreement."))
                {
                    keyAgreements.add(entry.substring("KeyAgreement.".length()));
                }
                else if (entry.startsWith("Mac."))
                {
                    macs.add(entry.substring("Mac.".length()));
                }
                else if (entry.startsWith("MessageDigest."))
                {
                    messageDigests.add(entry.substring("MessageDigest.".length()));
                }
                else if (entry.startsWith("Signature."))
                {
                    signatures.add(entry.substring("Signature.".length()));
                }
            }
        }
        
        printSet("Elementy Cipher", ciphers);
        printSet("Elementy KeyAgreement", keyAgreements);
        printSet("Elementy Mac", macs);
        printSet("Elementy MessageDigest", messageDigests);
        printSet("Elementy Signature", signatures);
    }
}
