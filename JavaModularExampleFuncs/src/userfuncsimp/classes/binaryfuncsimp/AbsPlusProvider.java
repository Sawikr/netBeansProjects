/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userfuncsimp.binaryfuncsimp;

// import z '*'
import userfuncs.binaryfuncs.*;

/**
 *
 * @author Radosław Sawicki
 */
public class AbsPlusProvider implements BinFuncProvider{
    
    // Udostępnia obiekt AbsPlus
    public BinaryFunc get() { return new AbsPlus(); }
}