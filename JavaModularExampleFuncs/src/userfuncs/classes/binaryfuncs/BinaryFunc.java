/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userfuncs.binaryfuncs;

/**
 *
 * @author Radosław Sawicki
 */
public interface BinaryFunc {
    
    // Pobiera nazwę funkcji
    public String getName();
    // To jest wykonywana funkcja; sama funkcja zostanie
    // udostępniona przez konkretną implementację interfejsu
    public int func(int a, int b);
}
