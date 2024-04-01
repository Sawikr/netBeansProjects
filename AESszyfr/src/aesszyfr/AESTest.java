package aesszyfr;

import java.io.*;
import java.security.*;
import java.util.Scanner;
import javax.crypto.*;

/**
 * Program testujący szyfr AES. Uruchamianie:
 * java AESTest -genkey keyfile
 * java AESTest -encrypt plaintext encrypted keyfile
 * java AESTest -decrypt encrypted decrypted keyfile
 * @author Radosław Sawicki
 * @version 1.01 2013-06-10
 */
public class AESTest
{
   public static void main(String[] args) 
      throws IOException, GeneralSecurityException, ClassNotFoundException
   {
      Scanner inI = new Scanner(System.in);
      System.out.println("Podaj rodzaj operacji, generuj, szyfruj lub deszyfruj: ");
      String a = inI.nextLine();
      
      if (a.equals("generuj"))
      {
         KeyGenerator keygen = KeyGenerator.getInstance("AES");
         SecureRandom random = new SecureRandom();
         int keyBitSize = 256;
         
         keygen.init(keyBitSize, random);
         SecretKey key = keygen.generateKey();
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\plikKlucza.txt")))
         {
            out.writeObject(key);
            System.out.println("Klucz wygenerowany!");
         }
      }
      else
      {
         int mode;
         if (a.equals("szyfruj")) mode = Cipher.ENCRYPT_MODE;
         else mode = Cipher.DECRYPT_MODE;

         try (ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(".\\plikKlucza.txt"));
            InputStream in = new FileInputStream(".\\plikTekstu.txt");
            OutputStream out = new FileOutputStream(".\\plikZaszyfruj.txt"))
         {
            Key key = (Key) keyIn.readObject();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, key);
            Util.crypt(in, out, cipher);
            
            System.out.println("Operacja wykonana pomyślnie!");
         }
      }
   }
}