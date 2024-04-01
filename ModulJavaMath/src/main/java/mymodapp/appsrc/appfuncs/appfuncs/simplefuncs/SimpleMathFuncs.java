// Kilka prostych funkcji matematycznych 
 
package appfuncs.simplefuncs; 
 
public class SimpleMathFuncs { 
  
  // Określa, czy a jest dzielnikiem b 
  public static boolean isFactor(int a, int b) { 
    if((b%a) == 0) return true; 
    return false; 
  } 
 
  // Zwraca najmniejszy większy od zera wspólny dzielnik liczb a i b
  public static int lcf(int a, int b) { 
    // Operujemy na liczbach dodatnich 
    a = Math.abs(a); 
    b = Math.abs(b); 
 
    int min = a < b ? a : b;
 
    for(int i = 2; i <= min/2; i++) { 
      if(isFactor(i, a) && isFactor(i, b))
        return i; 
    } 
 
    return 1;
  } 
 
  // Zwraca największy większy od zera wspólny dzielnik liczb a i b
  public static int gcf(int a, int b) { 
    // Operujemy na liczbach dodatnich 
    a = Math.abs(a); 
    b = Math.abs(b); 
 
    int min = a < b ? a : b; 
 
    for(int i = min/2; i >= 2; i--) { 
      if(isFactor(i, a) && isFactor(i, b)) 
        return i; 
    } 
 
    return 1;
  } 
}
