/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import java.util.Comparator;

/**
 *
 * @author Danuta
 */
public class Nauczyciel implements Comparable<Nauczyciel>{
    
    private final int id;
    private final String name;
    private int liczbaGodzin;
    private final int liczbaNadgodzin;
    ;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLiczbaGodzin() {
        return liczbaGodzin;
    }

    public long getLiczbaNadgodzin() {
        return liczbaNadgodzin;
    }

     Nauczyciel(int id, String name, int liczbaGodzin, int liczbaNadgodzin) {
        this.id = id;
        this.name = name;
        this.liczbaGodzin = liczbaGodzin;
        this.liczbaNadgodzin = liczbaNadgodzin;
    }

    @Override
    public int compareTo(Nauczyciel emp) {
        //let's sort the employee based on an id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object.
        return (this.id - emp.id);
    }
    

    @Override
    //this is required to print the user-friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", liczbaGodzin=" + this.liczbaGodzin + ", liczbaNadgodzin=" +
                this.liczbaNadgodzin + "]";
    }

    @SuppressWarnings("Convert2Lambda")
    public static Comparator<Nauczyciel> LiczbaGodzinComparator = new Comparator<Nauczyciel>() {

        @Override
        public int compare(Nauczyciel e1, Nauczyciel e2) {
            
            int wynik = (int) (e2.getLiczbaGodzin() - e1.getLiczbaGodzin());// od największej int             
            int wynik2 = (int) (e2.getLiczbaNadgodzin()- e1.getLiczbaNadgodzin());
            int wynik3 = (int) (e2.getLiczbaNadgodzin()- e1.getLiczbaNadgodzin());// od największej int
            
            return wynik * wynik2 * wynik3;                   
        }
    };
    
    public static int liczbaGodzinNauczyciela (Nauczyciel el){
        
        int wynik = (int) el.getLiczbaGodzin();
        //el.liczbaGodzin--;
        return wynik;
        
    }

    public static int liczbaGodzinNauczycielaMinus (Nauczyciel el){
        
        int wynik = (int) el.getLiczbaGodzin();
        el.liczbaGodzin--;
        return wynik;
        
    }
    
    /**
     * Comparator to sort employees list or array in order of Age
     */
    @SuppressWarnings("Convert2Lambda")
    public static Comparator<Nauczyciel> LiczbaNadgodzinComparator = new Comparator<Nauczyciel>() {

        @Override
        public int compare(Nauczyciel e1, Nauczyciel e2) {
            return (int) (e2.getLiczbaNadgodzin()- e1.getLiczbaNadgodzin());// od największej int
        }
    };

    /**
     * Comparator to sort employees list or array in order of Name
     */
    @SuppressWarnings("Convert2Lambda")
    public static Comparator<Nauczyciel> NameComparator = new Comparator<Nauczyciel>() {

        @Override
        public int compare(Nauczyciel e1, Nauczyciel e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };
}