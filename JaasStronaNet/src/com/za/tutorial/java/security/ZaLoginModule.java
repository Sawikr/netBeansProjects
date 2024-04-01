/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.za.tutorial.java.security;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

/**
 *
 * @author Danuta
 */
public class ZaLoginModule implements LoginModule{

    public static final String TEST_USERNAME = "sawikr";
    public static final String TEST_PASSWORD = "kasjan";
    private CallbackHandler callbackHandler = null;
    private boolean authenticationSuccesFlag = false;
    
    @Override
    public void initialize(Subject arg0, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean login() throws LoginException {
        
        Callback[] callbackArray = new Callback[2];
        callbackArray[0] = new NameCallback("Nazwa użytkownika: "); 
        callbackArray[1] = new PasswordCallback("Hasło użytkownika: ", false); 
        
        try {         
            callbackHandler.handle(callbackArray);
        } catch (IOException ex) {
            Logger.getLogger(ZaLoginModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedCallbackException ex) {
            Logger.getLogger(ZaLoginModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String name = ((NameCallback) callbackArray[0]).getName();
        String password = new String(((PasswordCallback) callbackArray[1]).getPassword());
        
        if(TEST_USERNAME.equals(name) && TEST_PASSWORD.equals(password)){
            System.out.println("Autoryzacja poprawna!");
            authenticationSuccesFlag = true;
        }else{
            authenticationSuccesFlag = false;
            throw new FailedLoginException("Autoryzacja niepoprawna!");// fajny wyjątek
        }
        return authenticationSuccesFlag;// zwraca true lub false
    }

    @Override
    public boolean commit() throws LoginException {
        return authenticationSuccesFlag;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        return false;
    }
}