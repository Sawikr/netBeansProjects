// Klasa AbsPlus udostępnia konkretną implementację interfejsu
// BinaryFunc. Implementowana przez nią funkcja zwraca wartość abs(a) + abs(b)
package userfuncsimp.binaryfuncsimp; 
 
import userfuncs.binaryfuncs.BinaryFunc; 
 
public class AbsPlus implements BinaryFunc { 
 
  // Zwraca nazwę tej funkcji
  public String getName() { 
    return "absPlus"; 
  } 
 
  // Implementacja funkcji AbsPlus
  public int func(int a, int b) { return Math.abs(a) + Math.abs(b); } 
}
