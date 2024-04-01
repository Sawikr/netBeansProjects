/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.BinFuncProvider;
import userfuncs.binaryfuncs.BinaryFunc;

/**
 *
 * @author Radosław Sawicki
 */
public class AbsMinusProvider implements BinFuncProvider{
    
    // Udostępnia obiekt AbsMinus
    public BinaryFunc get() { return new AbsMinus(); }
}