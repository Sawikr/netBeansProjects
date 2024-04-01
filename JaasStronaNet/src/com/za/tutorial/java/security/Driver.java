/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.za.tutorial.java.security;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 *
 * @author Radosław Sawicki
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.setProperty("java.security.auth.login.config", "jaastutorial.config");
        LoginContext loginContext = null;
        try {
            loginContext = new LoginContext("ZaJaasTutorial", new ZaCallbackHandler());
        } catch (LoginException ex) {
            //Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        while (true){
            try {
                loginContext.login();
                System.exit(0);
            } catch (LoginException ex) {
                //Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
    }
}