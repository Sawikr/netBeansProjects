/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortowaniecompare;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Radosław Sawicki
 */
public class SortowanieCompare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Person> arr = new ArrayList<Person>();

        arr.add(new Person("Kowalski", "Jan", "8511030788", "Kraków", "Karmelicka", 15));
        arr.add(new Person("Kowalski", "Grzegorz", "8510030788", "Kraków", "Karmelicka", 15));
        arr.add(new Person("Nowak", "Jan", "8511030789", "Kraków", "Karmelicka", 16));
        arr.add(new Person("Dudek", "Marian", "8609030008", "Poznań", "św. Marcina", 10));
        arr.add(new Person("Nowak", "Jan", "7509030008", "Poznań", "św. Marcina", 15));
        arr.add(new Person("Wiśniewska", "Justyna", "7001430008", "Poznań", "św. Marcina", 10));
        arr.add(new Person("Dudek", "Marian", "8609031111", "Warszawa", "Marszałkowska", 11));
        arr.add(new Person("Dudek", "Marian", "8609040008", "Poznań", "św. Marcina", 10));

        Person.PersonComp Comparator = new Person.PersonComp();
        Comparator.add(0, new Person.LastName());
        Comparator.add(1, new Person.FirstName());
        Comparator.add(2, new Person.PESEL());
        Comparator.add(3, new Person.City());
        Comparator.add(4, new Person.Street());
        Comparator.add(5, new Person.nr());

        System.out.println("Dane nieposortowane:");

        for (Person e :arr) 
            System.out.println(e);

        Collections.sort(arr, Comparator);
        System.out.println("\nDane posortowane:");
        for (Person e :arr) 
            System.out.println(e);
    }
    
}
