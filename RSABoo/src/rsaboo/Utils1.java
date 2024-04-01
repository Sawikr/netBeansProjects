package rsaboo;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Utils1 extends Utils2
{
    /**
     * Tworzy klucz dla algorytmu AES.
     * 
     * @param bitLength długość klucza w bitach
     * @param random źródło losowości
     * @return klucz AES
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     */
    public static SecretKey createKeyForAES(
        int bitLength, SecureRandom random)
        throws NoSuchAlgorithmException, NoSuchProviderException
    {
        KeyGenerator generator = KeyGenerator.getInstance("AES", "BC");
        
        generator.init(256, random);
        
        return generator.generateKey();
    }
    
    /**
     * Tworzy IV dla szyfrowania AES w trybie CTR.
     * <p>
     * IV składa się z 4-bajtowego numeru wiadomości, 4 bajtów losowych danych
     * i 8-bajtowego licznika.
     * 
     * @param messageNumber numer wiadomości
     * @param random źródło losowości
     * @return inicjalizowany obiekt IvParameterSpec
     */
    public static IvParameterSpec createCtrIvForAES(
        int messageNumber, SecureRandom random)
    {
        byte[] ivBytes = new byte[16];
        
        // losowa inicjalizacja
        
        random.nextBytes(ivBytes);
        
        // ustawienie bajtów numeru wiadomości
        
        ivBytes[0] = (byte)(messageNumber >> 24);
        ivBytes[1] = (byte)(messageNumber >> 16);
        ivBytes[2] = (byte)(messageNumber >> 8);
        ivBytes[3] = (byte)(messageNumber >> 0);
        
        // ustawienie bajtów licznika na 1
        
        for (int i = 0; i != 7; i++)
        {
            ivBytes[8 + i] = 0;
        }
        
        ivBytes[15] = 1;
        
        return new IvParameterSpec(ivBytes);
    }
    
    /**
     * Konwertuje tablicę bajtową 8-bitowych znaków na obiekt String.
     * @param bytes tablica zawierajaca znaki
     * @param length liczba bajtów do przetworzenia
     * @return obiekt String odpowiadający znakom z tablicy
     */
    public static String toString(byte[] bytes, int length)
    {
        char[] chars = new char[length];
        
        for (int i = 0; i != chars.length; i++)
        {
            chars[i] = (char)(bytes[i] & 0xff);
        }
        
        return new String(chars);
    }
    
    /**
     * Konwertuje tablicę bajtową 8-bitowych znaków na obiekt String.
     * @param bytes tablica zawierająca znaki
     * @return obiekt String odpowiadający znakom z tablicy
     */
    public static String toString(byte[] bytes)
    {
        return toString(bytes, bytes.length);
    }
    
    /**
     * Konwertuje przekazany obiekt String na tablicę bajtów biorąc
     * pod uwagę 8 mniej znaczących bitów każdego znaku.
     * 
     * @param string napis do konwersji
     * @return tablica bajtów odpowiadająca przekazanemu ciągowi
     */
    public static byte[] toByteArray(String string)
    {
        byte[] bytes = new byte[string.length()];
        char[] chars = string.toCharArray();
        
        for (int i = 0; i != chars.length; i++)
        {
            bytes[i] = (byte)chars[i];
        }
        
        return bytes;
    }
}