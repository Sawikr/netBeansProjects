/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Radosław Sawicki
 */
public class ExternExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Car car = new Car("Shubham", 1995, "Radek Sawicki", "brak"); 
        Car newcar = null; 
  
        // Serialize the car 
        try { 
            
            ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("gfg.txt")); 
            so.writeObject(car); 
            so.flush(); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
  
        // Deserializa the car 
        try { 

            ObjectInputStream si = new ObjectInputStream(new FileInputStream("gfg.txt")); 
            newcar = (Car)si.readObject(); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
  
        System.out.println("The original car is:\n" + car); 
        System.out.println("\nThe new car is:\n" + newcar); 
    }
    
}
