/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userfuncs.binaryfuncs;

import userfuncs.binaryfuncs.BinaryFunc;


/**
 *
 * @author Danuta
 */
public interface BinFuncProvider {
    
    // Pobiera instancję BinaryFunc
    public BinaryFunc get();
}