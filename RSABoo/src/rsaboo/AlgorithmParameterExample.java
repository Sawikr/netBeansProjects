package rsaboo;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.DHParameterSpec;

/**
 * Szyfrowanie algorytmem El Gamala z generowaniem losowego klucza i obiektem AlgorithmParameters.
 */
public class AlgorithmParameterExample
{
    public static void main(
        String[]    args)
        throws Exception
    {
        byte[]           input = new byte[] { (byte)0xbe, (byte)0xef };
        Cipher          cipher = Cipher.getInstance("ElGamal/None/NoPadding", "BC");
        SecureRandom     random = Utils.createFixedRandom();
        
        // Tworzenie parametr�w
        AlgorithmParameterGenerator a = AlgorithmParameterGenerator.getInstance("ElGamal", "BC");
        
        a.init(256, random);
        
        AlgorithmParameters   params = a.generateParameters();
        AlgorithmParameterSpec   dhSpec = params.getParameterSpec(DHParameterSpec.class);
        
        // Tworzenie kluczy
        KeyPairGenerator generator = KeyPairGenerator.getInstance("ElGamal", "BC");
        
        generator.initialize(dhSpec, random);

        KeyPair          pair = generator.generateKeyPair();
        Key              pubKey = pair.getPublic();
        Key              privKey = pair.getPrivate();

        System.out.println("dane wej�ciowe: " + Utils.toHex(input));
        
        // Szyfrowanie
        
        cipher.init(Cipher.ENCRYPT_MODE, pubKey, random);

        byte[] cipherText = cipher.doFinal(input);

        System.out.println("dane zaszyfrowane: " + Utils.toHex(cipherText));
        
        // Deszyfrowanie

        cipher.init(Cipher.DECRYPT_MODE, privKey);

        byte[] plainText = cipher.doFinal(cipherText);
        
        System.out.println("dane odszyfrowane: " + Utils.toHex(plainText));
    }
}
