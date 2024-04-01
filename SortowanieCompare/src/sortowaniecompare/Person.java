/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortowaniecompare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Radosław Sawicki
 */

public class Person {

    private String LastName;
    private String FirstName;
    private String PESEL;
    private String City;
    private String Street;
    private int nr;

    public Person(String LastName, String FirstName, String PESEL, String City, String Street, int nr) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.PESEL = PESEL;
        this.City = City;
        this.Street = Street;
        this.nr = nr;
    }

    public String toString() {
        return (LastName + "\t" + FirstName + "\t" + PESEL + "\t"+ City + "\t"+Street +"\t"+ nr + "\n");
    }

    public static class PersonComp implements Comparator<Person> {

        private final List<Comparator<Person>> _child = new ArrayList<Comparator<Person>> ();
        private int wynik = 0;

        public void add( int i, Comparator<Person> arg1 ) {
            _child.add(i, arg1);
        }

        @Override
        public int compare(Person o1, Person o2) {
            for (int i=0; i<_child.size(); i++) {
                wynik = _child.get(i).compare(o1, o2);
                if (wynik != 0) return wynik;
                
                System.out.println(wynik);
            }
            return 0;
        }

    }

    public static class LastName implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.LastName.compareToIgnoreCase(o2.LastName);            
        }

    }

    public static class FirstName implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.FirstName.compareToIgnoreCase(o2.FirstName);
        }

    }

    public static class City implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.City.compareToIgnoreCase(o2.City);
        }

    }

    public static class Street implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.Street.compareToIgnoreCase(o2.Street);
        }

    }

    public static class PESEL implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.PESEL.compareToIgnoreCase(o2.PESEL);
        }

    } 

    public static class nr implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            if (o1.nr > o2.nr) return 1;
            if (o1.nr == o2.nr) return 0;
            if (o1.nr < o2.nr) return -1;
            return 0;
        }

    }
} 
