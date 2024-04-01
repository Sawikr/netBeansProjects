package tokeny;

import java.io.*;
import java.util.logging.Logger;

public class Main 
{
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) 
    {
        Towar[] towar = new Towar[5];
        
        towar[0] = new Towar();
        towar[1] = new Towar(29.0, "Video Kurs Java");
        towar[2] = new Towar(39.0, "Video Kurs C++", 2008, 11, 21);
        towar[3] = new Towar(25.2, "Projekt Radka", 2010, 12, 15);
        towar[4] = new Towar(28.2, "Projekt Kasjana", 2010, 12, 15);
        
        try
        {
            
            RandomAccessFile RAF = new RandomAccessFile("plikRAF", "rw");
            
            Towar.zapiszDoPliku(towar, RAF);
            
            System.out.println(RAF.getFilePointer());
            
            RAF.seek(0);
            
            Towar a = new Towar();
            a.czytajDane(RAF);
            
            System.out.println(a);
            
            // odczyt
            RAF.seek(0);
            
            Towar[] towarki = Towar.odczytajZPliku(RAF);
            
            for(int i = 0; i < towarki.length; i++)
            {
                System.out.println(towarki[i].pobierzCene());
                System.out.println(towarki[i].pobierzNazwe());
                System.out.println(towarki[i].pobierzDate());
                System.out.println("----------------------------");
            }
                
            // wczytanie pojedyńczego rekordu
            int n = 3;
            RAF.seek((n-1) * Towar.DLUGOSC_REKORDU);
            
            Towar b = new Towar();
            b.czytajDane(RAF);
            
            System.out.println(b);
            System.out.println("----------------------------");
            
            // wczytanie rekordu poprzez metodę
            try
            {
                Towar c =  new Towar();
                c.wczytajRekordPojedynczy(RAF, 5);
                
                System.out.println("Wskaźnik jest ustawiony na: " + RAF.getFilePointer() + " bajtów");// gdzie jest wskaźnik
                System.out.println(c);
                
                System.out.println("----------------------------");
                System.out.println("Program działa bez błędu!");// to się nie wykonuje jak jest błąd
                
            }catch(BladRekordu err)
                {
                    System.out.println(err.getMessage());
                }    
            
            //GregorianCalendar kal = new GregorianCalendar();
            //System.out.println(kal.get(Calendar.YEAR) + " " + kal.get(Calendar.DAY_OF_MONTH));
            
            RAF.close();
                  
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        } 
    }    
}
