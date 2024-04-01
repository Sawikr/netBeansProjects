// Klasa AbsMinus udostępnia konkretną implementację interfejsu 
// BinaryFunc, która zwraca wartość  abs(a) - abs(b) 
 
package userfuncsimp.binaryfuncsimp; 
 
import userfuncs.binaryfuncs.BinaryFunc; 
 
public class AbsMinus implements BinaryFunc { 
 
  // Zwraca nazwę tej funkcji
  public String getName() { 
    return "absMinus"; 
  } 
 
  // Implementacja funkcji AbsMinus
  public int func(int a, int b) { return Math.abs(a) - Math.abs(b); } 
}
