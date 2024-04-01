// Ta klasa jest dostawcą funkcji AbsPlus 
 
package userfuncsimp.binaryfuncsimp; 
 
import userfuncs.binaryfuncs.*; 
 
public class AbsPlusProvider implements BinFuncProvider { 
 
  // Udostępnia obiekt AbsPlus
  public BinaryFunc get() { return new AbsPlus(); }   
}
