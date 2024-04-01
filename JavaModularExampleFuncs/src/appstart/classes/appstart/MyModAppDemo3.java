/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appstart;

import java.util.ServiceLoader;
import userfuncs.binaryfuncs.BinFuncProvider;
import userfuncs.binaryfuncs.BinaryFunc;

/**
 *
 * @author Radosław Sawicki
 */
public class MyModAppDemo3 {
    
    public static void main(String[] args) {
    
    // A teraz użyjemy operacji udostępnionych w formie usług
    // Pobiera obiekt wczytujący usługi, który operuje na funkcjach binarnych
    ServiceLoader<BinFuncProvider> ldr =
    ServiceLoader.load(BinFuncProvider.class);
    BinaryFunc binOp = null;
    
    // Odnajduje dostawcę funkcji absPlus i pobiera tę funkcję
    for(BinFuncProvider bfp : ldr) {
        if(bfp.get().getName().equals("absPlus")) {
        binOp = bfp.get();
        break;
        }
    }
    
    if(binOp != null)
        System.out.println("Wynik wywołania funkcji absPlus: " +
        binOp.func(12, -4) + ".");
        else
        System.out.println("Nie udało się znaleźć funkcji absPlus.");
        binOp = null;
        
    // Ten fragment odnajduje dostawcę funkcji absMinsu i pobiera tę funkcję
    for(BinFuncProvider bfp : ldr) {
        if(bfp.get().getName().equals("absMinus")) {
        binOp = bfp.get();
        break;
        }
    }
    
    if(binOp != null)
        System.out.println("Wynik wywołania funkcji absMinus: " +
        binOp.func(12, -4) + ".");
        else
        System.out.println("Nie udało się znaleźć funkcji absMinus.");
        }
}