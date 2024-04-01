// Ta klasa jest dostawcą funkcji AbsMinus

package userfuncsimp.binaryfuncsimp; 
 
import userfuncs.binaryfuncs.*; 
 
public class AbsMinusProvider implements BinFuncProvider { 
 
  // Udostępnia obiekt AbsMinus
  public BinaryFunc get() { return new AbsMinus(); }  
}
