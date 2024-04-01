package tokeny;

import java.io.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Towar[] towar = new Towar[3];
        
        towar[0] = new Towar();
        towar[1] = new Towar(29.0, "Video Kurs Java");
        towar[2] = new Towar(39.0, "Video Kurs C++", 2008, 11, 21);
        
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter("baza.txt"));
            
            Towar.zapiszDoPliku(towar, writer);
            
            writer.close();
            
            BufferedReader reader = new BufferedReader(new FileReader("baza.txt")); // pomijam new File()
            
            Towar[] towar2 = Towar.odczytajZPliku(reader);
            
            for (int i = 0; i < towar2.length; i++)
                System.out.println(towar2[i]);
            
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            
            //FileOutputStream outS = new FileOutputStream("nowyPlik");// zapisuje bajty
            //outS.write(50);
            
            DataOutputStream outS = new DataOutputStream(new FileOutputStream("nowyPlik"));
            
            outS.writeChar('A');// typ char ma 2 bajty
            
            outS.writeDouble(123.25);// typ double ma 8 bajtów
            
            outS.writeChars("Radek");// typ char.string ma 10 bajtów
            
            outS.close();
            
            // swobodny dostęp do plików
            
            RandomAccessFile RAF = new RandomAccessFile("nowyRaf", "rw");
            
            RAF.writeDouble(123.45);// 8 bajtów
            RAF.writeInt(222);// typ int ma 4 bajty
            RAF.writeChars("Radek");// 10 bajtów
            
            System.out.println(RAF.getFilePointer());// razem 22 bajty
            // ustawia wskaźnik na określony bajt
            RAF.seek(8);
            
            System.out.println(RAF.getFilePointer());// teraz 8
            
            System.out.println(RAF.readInt());// czyta int - 222
            
            System.out.println(Double.SIZE/8);// wychodzi ile bajtów ma typ Double (64/8)
            System.out.println(Integer.SIZE/8);
            
            RAF.close();
            
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
