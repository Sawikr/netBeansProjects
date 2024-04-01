package tokeny;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Towar implements Serializable
{
    private static final long serialVersionUID = 0L;// dodaje serializację klasy
       
    public Towar()
    {
        this.cena = 0.0;
        this.nazwa = " ";
        this.dataWydania = new GregorianCalendar().getTime();
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
    @Override
    public String toString()
    {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena+" zł; nazwa: "+this.nazwa+" "+kalendarz.get(Calendar.YEAR)+" rok "+(kalendarz.get(Calendar.MONTH)+1)+" m "+kalendarz.get(Calendar.DAY_OF_MONTH)+" dz ";
    }
    
    public static void zapiszDoPliku(Towar[] towar, DataOutput outS) throws IOException
    {
        for (int i = 0; i < towar.length; i++)
        {
            towar[i].zapiszDane(outS);
        }
    }
    
    public static Towar[] odczytajZPliku(RandomAccessFile RAF) throws IOException
    {
        int iloscRekordow = (int)(RAF.length()/Towar.DLUGOSC_REKORDU);
        
        System.out.println(iloscRekordow + " - tyle rekordów");
        
        Towar[] towar = new Towar[iloscRekordow];
        
        for (int i = 0; i < iloscRekordow; i++)
        {
            towar[i] = new Towar();// koniecznie trzeba stworzyć nowy obiekt
            towar[i].czytajDane(RAF);
        }
        return towar;
    }
    
    public void zapiszDane(DataOutput outS) throws IOException{
        
        outS.writeDouble(this.cena);
        
        //@SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer stringB = new StringBuffer(Towar.DLUGOSC_NAZWY);
        stringB.append(this.nazwa);
        stringB.setLength(DLUGOSC_NAZWY);// przypisuje długość nazwy wszystkim nazwom
        
        outS.writeChars(stringB.toString());// zapisuje do obiektu outS
        
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        
        outS.writeInt(kalendarz.get(Calendar.YEAR));
        outS.writeInt(kalendarz.get(Calendar.MONTH)+1);// tu liczymy od 0 do 11
        outS.writeInt(kalendarz.get(Calendar.DAY_OF_MONTH));
    }
    
    public void czytajDane(DataInput inS) throws IOException{
        
        this.cena = inS.readDouble();
        
        //@SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer stringB = new StringBuffer(Towar.DLUGOSC_NAZWY);
        
        for(int i = 0; i < Towar.DLUGOSC_NAZWY; i++)
        {
            char ch = inS.readChar();// wczytuje pojedyńczy znak Char
            
            if(ch != '\0')
                stringB.append(ch);// dopisuje pojedyńczy znak do całej nazwy
        }
        this.nazwa = stringB.toString();// dopisanie do this.nazwa
        
        int rok = inS.readInt();
        int m = inS.readInt();
        int dz = inS.readInt();
            
        GregorianCalendar kalendarz = new GregorianCalendar(rok, m-1, dz);
        this.dataWydania = kalendarz.getTime();    
    }
    
    public void wczytajRekordPojedynczy(RandomAccessFile RAF, int n) throws IOException, BladRekordu
    {
        RAF.seek(0);
        if(n <= (RAF.length()/Towar.DLUGOSC_REKORDU))
        {
        RAF.seek((n-1) * Towar.DLUGOSC_REKORDU);
        this.czytajDane(RAF);// podaje, gdzie wysłać, wczytać dane, czyli do RAF
        }
        else
            throw new BladRekordu("Nie ma takiego rekordu");
    }
    
    public static final int DLUGOSC_REKORDU = (Character.SIZE * Towar.DLUGOSC_NAZWY + Double.SIZE + 3 * Integer.SIZE)/8;
    
    public static final int DLUGOSC_NAZWY = 30;
    
    private double cena;
    private String nazwa;
    private Date dataWydania;
}
