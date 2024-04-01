/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.BinaryFunc;

/**
 *
 * @author Radosław Sawicki
 */
public class AbsPlus implements BinaryFunc{
    
    // Zwraca nazwę tej funkcji
    public String getName() {
    return "absPlus";
}
// Implementacja funkcji AbsPlus
    public int func(int a, int b) { return Math.abs(a) + Math.abs(b); }
}