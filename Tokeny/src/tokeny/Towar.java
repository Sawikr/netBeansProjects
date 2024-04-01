package tokeny;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Towar 
{
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
    
    public static void zapiszDoPliku(Towar[] towar, PrintWriter outS)
    {
        outS.println(towar.length);
        GregorianCalendar kalendarz = new GregorianCalendar();
        for (int i = 0; i < towar.length; i++)
        {
            kalendarz.setTime(towar[i].pobierzDate());
            outS.println(towar[i].pobierzCene()+"|"+towar[i].pobierzNazwe()+"|"+kalendarz.get(Calendar.YEAR)+"|"+(kalendarz.get(Calendar.MONTH)+1)+"|"+kalendarz.get(Calendar.DAY_OF_MONTH));        
        }
    }
    public static Towar[] odczytajZPliku(BufferedReader inS) throws IOException
    {
        int dl = Integer.parseInt(inS.readLine());
        Towar[] towar = new Towar[dl];
        
        for (int i = 0; i < dl; i++)
        {
            // czyta linie, aby zobaczyć co tam jest
            String linia = inS.readLine();
            // ustawia co jest tokenem
            StringTokenizer tokeny = new StringTokenizer(linia, "|");
            
            // przechodzi przez linię i pomijają tokeny, zwraca wskazany w argumencie typ, tutaj double
            double cena = Double.parseDouble(tokeny.nextToken());
            String nazwa = tokeny.nextToken();
            int rok = Integer.parseInt(tokeny.nextToken());
            int m = Integer.parseInt(tokeny.nextToken());
            int dz = Integer.parseInt(tokeny.nextToken());
            
            towar[i] = new Towar(cena, nazwa, rok, m, dz);
        }
        
        return towar;
    }
    private double cena;
    private String nazwa;
    private Date dataWydania;
}
