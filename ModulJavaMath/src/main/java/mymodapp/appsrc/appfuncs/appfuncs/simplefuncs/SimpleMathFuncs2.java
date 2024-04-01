// Kilka prostych funkcji matematycznych
 
package appfuncs.simplefuncs; 
import appsupport.supportfuncs.SupportFuncs;

public class SimpleMathFuncs2 { 
 
  // Zwraca najmniejszy większy od zera wspólny dzielnik liczb a i b  
  public static int lcf(int a, int b) { 
    // Operujemy na liczbach dodatnich
    a = Math.abs(a); 
    b = Math.abs(b); 
 
    int min = a < b ? a : b; 
 
    for(int i = 2; i <= min/2; i++) { 
      if(SupportFuncs.isFactor(i, a) && SupportFuncs.isFactor(i, b))  
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
      if(SupportFuncs.isFactor(i, a) && SupportFuncs.isFactor(i, b))  
        return i; 
    } 
 
    return 1;
  } 
}
