/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formatter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
//import java.util.logging.XMLFormatter;

/**
 *
 * @author Radosław Sawicki
 */
public class Formatter {
    
    private static final Logger LOGGER = Logger.getLogger("Radek");
    private static final Logger LOGGER1 = Logger.getLogger("confLogger");
    private static final LogManager logManager = LogManager.getLogManager();
   
    static{
        try {
            logManager.readConfiguration(new FileInputStream("./javacodegeeks.properties.log"));
        } catch (IOException exception) {
            LOGGER1.log(Level.SEVERE, "Powstał błąd konfiguracji",exception);
        }
    } 
    
    public static void main(String[] arg){
        
        LOGGER1.fine("Poprawnie wczytano dane konfiguracyjne");
        
        System.out.println();
        
        Handler fileHandler1 = null;
        java.util.logging.Formatter simpleFormatter = null;
       
        final int ZAPIS = 2;
        
        LOGGER.log(Level.SEVERE, "Próba komentarza");
        
        try{
             
            // Creating FileHandler
            fileHandler1 = new FileHandler("./javacodegeeks.formatter.log", 0, ZAPIS); // 0, ZAPIS tworzy nowy plik i licznik zastąpienia pliku ustawionu do 1
             
            // Creating SimpleFormatter
            simpleFormatter = new SimpleFormatter();
            //simpleFormatter = new XMLFormatter();
             
            // Assigning handler to logger
            LOGGER.addHandler(fileHandler1);
            
            // Logging message of Level info (this should be publish in the default format i.e. XMLFormat)
            LOGGER.info("Finnest message: Logger with DEFAULT FORMATTER");
             
            // Setting formatter to the handler
            fileHandler1.setFormatter(simpleFormatter); 
             
            // Setting Level to ALL
            fileHandler1.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
             
            // Logging message of Level finest (this should be publish in the simple format)
            LOGGER.severe("Finnest message: Logger with SIMPLE FORMATTER");
        }catch(IOException exception){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }  
    }
}
