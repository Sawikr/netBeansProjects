package rsaboo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Przykład szyfrowania RSA z dopełnieniem OAEP i generowaniem losowych kluczy.
 * Brak ograniczeń szyfrowanych danych!!!
 * WAŻNE: wczytanie polskich znaków z klawiatury!
 */
public class RSAKeyExchangeExample
{
    private static byte[] packKeyAndIv(Key key, IvParameterSpec ivSpec) throws IOException
    {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        
        bOut.write(ivSpec.getIV());
        bOut.write(key.getEncoded());
        
        return bOut.toByteArray();
    }
    
    private static Object[] unpackKeyAndIV(byte[] data)
    {
        byte[] keyD = new byte[16];
        byte[] iv = new byte[data.length - 16];
        
        return new Object[] {
             new SecretKeySpec(data, 16, data.length - 16, "AES"),
             new IvParameterSpec(data, 0, 16)
        };
    }
    
    public static void main(String[] args) throws Exception
    {
        Scanner inI = new Scanner(System.in, "windows-1250");// polskie znaki w konsoli);
        System.out.println("Podaj dane do szyfrowania: ");
        String nazwa = inI.nextLine();
        
//        byte[] input = new byte[] { 0x00, (byte)0xbe, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xbe, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xbe, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef,
//                       (byte)0xbe, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xbe, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xbe, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef, (byte)0xef };
        
        byte[] input = nazwa.getBytes("windows-1250");

        //byte[] input = Utils1.toByteArray(nazwa);// nie wykorzystuje metody toByteArray z Utils1
        
        SecureRandom random = Utils.createFixedRandom();
        
        // utworzenie klucza RSA
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
        
        generator.initialize(1024, random);

        KeyPair pair = generator.generateKeyPair();
        Key pubKey = pair.getPublic();
        Key privKey = pair.getPrivate();

        System.out.println("\nDane wejsciowe: " + Utils.toHex(input));
        
        // utworzenie klucza symetrycznego i IV
        Key sKey = Utils.createKeyForAES(256, random);
        IvParameterSpec sIvSpec = Utils.createCtrIvForAES(0, random);
        
        // opakowanie klucza symetrycznego i IV
        Cipher xCipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding", "BC");
        
        xCipher.init(Cipher.ENCRYPT_MODE, pubKey, random);
        
        byte[] keyBlock = xCipher.doFinal(packKeyAndIv(sKey, sIvSpec));
        
        // szyfrowanie
        Cipher sCipher  = Cipher.getInstance("AES/CTR/NoPadding", "BC");   
        
        sCipher.init(Cipher.ENCRYPT_MODE, sKey, sIvSpec);

        byte[] cipherText = sCipher.doFinal(input);

        System.out.println("Długość bloku klucza: " + keyBlock.length);
        System.out.println("Długość szyfrogramu: " + cipherText.length);
        
        // odpakowanie klucza symetrycznego i IV
        xCipher.init(Cipher.DECRYPT_MODE, privKey);
        
        Object[] keyIv = unpackKeyAndIV(xCipher.doFinal(keyBlock));
        
        // deszyfrowanie
        sCipher.init(Cipher.DECRYPT_MODE, (Key)keyIv[0], (IvParameterSpec)keyIv[1]);

        byte[] plainText = sCipher.doFinal(cipherText);
        
        System.out.println("\nDane odszyfrowane: \n" + new String(plainText, "windows-1250"));
    }
}