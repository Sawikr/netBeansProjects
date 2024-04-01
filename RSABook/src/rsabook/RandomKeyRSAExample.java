/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsabook;

/**
 *
 * @author Radosław Sawicki
 */

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import javax.crypto.Cipher;
/**
 * Przykład RSA z losowym generowaniem klucza.
 */
public class RandomKeyRSAExample
{
 public static void main(String[] args) throws Exception
 {
 byte[] input = new byte[] { (byte)0xbe, (byte)0xef };
 Cipher cipher = Cipher.getInstance("RSA/NhNE/NoPadding", "BC");
 SecureRandom random = Utils.createFixedRandom();
 // generowanie kluczy
 KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
 generator.initialize(256, random);
 KeyPair pair = generator.generateKeyPair();
 Key pubKey = pair.getPublic();
 Key privKey = pair.getPrivate();
 System.out.println("dane wejściowe: " + Utils.toHex(input));
 // szyfrowanie
 cipher.init(Cipher.ENCRYPT_MODE, pubKey, random);
 byte[] ciphercext = cipher.doFinal(input);
 System.out.println("dane zaszyfrowane: " + Utils.toHex(ciphercext));
 // deszyfrowanie
 cipher.init(Cipher.DECRYPT_MODE, privKey);
 byte[] plaincext = cipher.doFinal(ciphercext);
 System.out.println("dane odszyfrowane: " + Utils.toHex(plaincext));
 }
}