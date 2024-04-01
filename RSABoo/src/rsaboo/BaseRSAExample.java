package rsaboo;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Locale;
import java.util.Scanner;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Podstawowy przykład RSA.
 * Wielkość danych szyfrowanych uzależniona od długości klucza!!!
 */
public class BaseRSAExample extends Utils1
{
    static { Security.addProvider(new BouncyCastleProvider());  }
    
    public static void main(String[] args) throws Exception
    {
        Scanner inI = new Scanner(System.in, "windows-1250");// polskie znaki w konsoli
        System.out.println("Podaj dane do szyfrowania: ");
        String nazwa1 = inI.nextLine();
        
        //System.out.println("Wpisano: " + nazwa1);
        
        byte[] input = nazwa1.getBytes("windows-1250");
        
        //byte[] input = Utils1.toByteArray(nazwa);// nie wykorzystuje metody toByteArray z Utils1
        
        //byte[] input = new byte[] { (byte)0xbe, (byte)0xef };
        
        Cipher cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
        
        // Tworzenie kluczy

        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(
                new BigInteger("d46f473a2d746537de2056ae3092c451", 16),
                new BigInteger("11", 16));
        RSAPrivateKeySpec privKeySpec = new RSAPrivateKeySpec(
                new BigInteger("d46f473a2d746537de2056ae3092c451", 16),  
                new BigInteger("57791d5430d593164082036ad8b29fb1", 16));
        
        RSAPublicKey pubKey = (RSAPublicKey)keyFactory.generatePublic(pubKeySpec);
        RSAPrivateKey privKey = (RSAPrivateKey)keyFactory.generatePrivate(privKeySpec);

        System.out.println("\nDane wejściowe: " + new String(input, "windows-1250"));

        // Szyfrowanie
        
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);

        byte[] cipherText = cipher.doFinal(input);

        System.out.println("Dane zaszyfrowane: " + Utils.toHex(cipherText));
        
        // Deszyfrowanie

        cipher.init(Cipher.DECRYPT_MODE, privKey);

        byte[] plainText = cipher.doFinal(cipherText);
        
        System.out.println("Dane odszyfrowane: " + new String(plainText, "windows-1250"));// moja wersja, zamiana na String
    }
}