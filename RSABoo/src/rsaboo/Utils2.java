package rsaboo;

public class Utils2
{
    private static String  digits = "0123456789abcdef";
    
    /**
     * Zwraca length bajtów z przekazanej tablicy bajtów jako ciąg szesnastkowy.
     * @param data tablica bajtów do konwersji.
     * @param length liczba bajtów do konwersji w bloku danych.
     * @return szesnastkowy zapis length bajtów danych.
     */
    public static String toHex(byte[] data, int length)
    {
        StringBuffer buf = new StringBuffer();
        
        for (int i = 0; i != length; i++)
        {
            int v = data[i] & 0xff;
            
            buf.append(digits.charAt(v >> 4));
            buf.append(digits.charAt(v & 0xf));
        }
        
        return buf.toString();
    }
    
    /**
     * Zwraca przekazaną tablicę bajtów jako ciąg szesnastkowy.
     * @param data tablica bajtów do konwersji.
     * @return szesnastkowy zapis bajtów danych.
     */
    public static String toHex(byte[] data)
    {
        return toHex(data, data.length);
    }
}