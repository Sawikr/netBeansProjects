package serializacjaobiektow;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Towar implements Serializable
{
    public Towar()
    {
        this.cena = 0.0;
        this.nazwa = " ";
        this.dataWydania = new GregorianCalendar().getTime();
        this.wartosc = 100;
    }
    public Towar(double cena, String nazwa)
    {
        this();
        this.cena = cena;
        this.nazwa = nazwa;
    }
    public Towar(double cena, String nazwa, int rok, int m, int dz)
    {
        this(cena, nazwa);
        GregorianCalendar kalendarz = new GregorianCalendar(rok, m-1, dz);
        this.dataWydania = kalendarz.getTime();
    }
    public double pobierzCene()
    {
        return this.cena;
    }
    public String pobierzNazwe()
    {
        return this.nazwa;
    }
    public Date pobierzDate()
    {
        return dataWydania;
    }
    public void ustawCene(double cena)
    {
        this.cena = cena;
    }
    public void ustawNazwe(String nazwa)
    {
        this.nazwa = nazwa;
    }
    public void ustawDate(int r, int m, int dz)
    {
        GregorianCalendar kalendarz = new GregorianCalendar(r, m-1, dz);
        this.dataWydania = kalendarz.getTime();
    }
    public void ustawDate(Date data)
    {
        this.dataWydania = data;
    }
    public String pobierzHaslo()
    {
        return this.haslo;
    } 
    
    public int ustawWartosc()
    {
        return this.wartosc;
    }
                
    @Override
    public String toString()
    {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena+" zł; nazwa: "+this.nazwa+" "+kalendarz.get(Calendar.YEAR)+" rok "+(kalendarz.get(Calendar.MONTH)+1)+" m "+kalendarz.get(Calendar.DAY_OF_MONTH)+" dz ";
    }

    private void readObject(ObjectInputStream inS) throws IOException, ClassNotFoundException
    {
        inS.defaultReadObject();
        if (haslo != null)
         if (!haslo.equals("tajne"))
            throw new IOException("Dane są nieprawidłowe");
        
        //System.out.println("ja teraz wywoluje sie z metody readobject");
              
    }
    private void writeObject(ObjectOutputStream outS) throws IOException
    {
        outS.defaultWriteObject();
        outS.writeInt(wartosc);
    }
    
    public static final int DLUGOSC_NAZWY = 30;
    public static final int DLUGOSC_REKORDU = (Character.SIZE * DLUGOSC_NAZWY + Double.SIZE + 3 * Integer.SIZE)/8;
    private double cena; //8 bajtow
    private String nazwa; //DLUGOSC_NAZWY * 2 bajtów
    private Date dataWydania; //4 bajty + 4 + 4 = 12 bajtow RAZEM 80
    private int wartosc;
    
    @SuppressWarnings("FieldMayBeFinal")
    private transient String haslo = "tajne"; //ulotny

}
