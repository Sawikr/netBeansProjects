package rsaboo;

/**
 * Statyczne metody narz�dziowe.
 */
public class UtilsFirst
{
    /**
     * Zwraca łańcuch znaków o długości len zawierający wyłącznie spacje.
     * 
     * @param len długość łańcucha wyjściowego.
     * @return łańcuch spacji.
     */
    public static String makeBlankString(
        int len)
    {
        char[]   buf = new char[len];
        
        for (int i = 0; i != buf.length; i++)
        {
            buf[i] = ' ';
        }
        
        return new String(buf);
    }
}