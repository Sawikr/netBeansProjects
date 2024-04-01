/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.za.tutorial.java.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 *
 * @author Danuta
 */
public class ZaCallbackHandler implements CallbackHandler{

    @Override
    public void handle(Callback[] callbackArray) throws IOException, UnsupportedCallbackException {
        
        NameCallback nameCallback = null;
        PasswordCallback passwordCallback = null;
        
        int counter = 0;
        while (counter < callbackArray.length){
            if(callbackArray[counter] instanceof NameCallback){
                nameCallback = (NameCallback) callbackArray[counter++];
                System.out.println(nameCallback.getPrompt());// get podpowiedź
                nameCallback.setName((new BufferedReader(new InputStreamReader(System.in))).readLine());
            }else if(callbackArray[counter] instanceof PasswordCallback){
                passwordCallback = (PasswordCallback) callbackArray[counter++];
                System.out.println(passwordCallback.getPrompt());// get podpowiedź
                passwordCallback.setPassword((new BufferedReader(new InputStreamReader(System.in))).readLine().toCharArray());// zamiana na znaki
            }
        }
    } 
}