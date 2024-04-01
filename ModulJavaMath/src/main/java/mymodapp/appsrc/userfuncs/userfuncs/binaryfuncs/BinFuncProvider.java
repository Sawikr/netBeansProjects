// Ten interfejs definiuje postać dostawcy usługi 
// pobierającego instancje typu BinaryFunc
package userfuncs.binaryfuncs; 
 
import userfuncs.binaryfuncs.BinaryFunc; 
 
public interface BinFuncProvider { 
 
  // Pobiera instację BinaryFunc 
  public BinaryFunc get(); 
}
