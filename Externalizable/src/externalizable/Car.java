/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalizable;

import java.io.*;
import java.util.Objects;

/**
 * Klasa <code>Car<\code> musi mieć konstruktor bezargumentowy
 * oraz wskazać jakie pola chcemy serializować
 * @author Danuta
 */
public class Car implements Externalizable
{
    static int age; 
    String name; 
    int year;
    String wlasciciel;
    String nowyWlasciciel;
  
    public Car() 
    { 
        System.out.println("Wywołano domyślny konstruktor!\n"); 
    } 
  
    Car(String n, int y, String w, String nw) 
    { 
        this.name = n; 
        this.year = y; 
        age = 10;
        this.wlasciciel = w;
        this.nowyWlasciciel = nw;    
    } 
    
    public void writeExternal(ObjectOutput out) throws IOException 
    { 
        String nowyWlasciciel = "Kasjan Sawicki";
        wlasciciel = nowyWlasciciel;
        
        out.writeObject(name); 
        out.writeInt(age); 
        out.writeInt(year);
        out.writeObject(wlasciciel);
        out.writeObject(wlasciciel);
    } 
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException   
    { 
        name = (String)in.readObject(); 
        year = in.readInt(); 
        age = in.readInt();
        wlasciciel = (String)in.readObject();
        nowyWlasciciel = (String)in.readObject();     
    } 

    @Override
    public String toString() {
        return "Nazwa = " + name + "," + "\n" +
               "Wiek = " + year + " lat," + "\n" +
               "Rok produkcji = " + age + "," + "\n" +
               "Właściciel = " + wlasciciel + "," + "\n" +
               "Nowy właściciel = " + nowyWlasciciel;
    }
}
