// Ten interfejs definiuje funkcję, która pobiera dwa 
// argumenty typu int i zwraca wynik typu int, a zatem, 
// może on opisywać dowolną operację binarną wykonywaną 
// na dwóch liczbach typu int i zwracającą wynik typu int
 
package userfuncs.binaryfuncs; 
 
public interface BinaryFunc { 
  // Pobiera nazwę funkcji
  public String getName(); 
 
  // To jest wykonywana funkcja. Sama funkcja zostanie
  // udostępniona przez konkretną implementację interfejsu
  public int func(int a, int b); 
}
