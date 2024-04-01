/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafirm;

import com.javafirm.HelloPrint;

/**
 * Pierwszy program z modułami Java w Ant (nie Maven!)
 * @author Radosław Sawicki
 */
public class HelloWorld {
    
    public static void main(String[] args) {
        
        HelloPrint print = new HelloPrint();
        System.out.println("Wiadomość brzmi: " + print.printHello());
    }
}