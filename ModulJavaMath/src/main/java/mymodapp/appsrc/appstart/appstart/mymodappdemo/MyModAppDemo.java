// Przykład prostej aplikacji korzystającej z modułów
package appstart.mymodappdemo; 
 
import appfuncs.simplefuncs.SimpleMathFuncs;
 
public class MyModAppDemo { 
  public static void main(String[] args) { 
 
    if(SimpleMathFuncs.isFactor(2, 10)) 
      System.out.println("Liczba 2 jest dzielnikiem liczby 10.");  
 
    System.out.println("Najmniejszym wspólnym dzielnikiem liczb 35 i 105 jest " + 
                       SimpleMathFuncs.lcf(35, 105) + ".");  
 
    System.out.println("Największym wspólnym dzielnikiem liczb 35 i 105 jest " + 
                       SimpleMathFuncs.gcf(35, 105) + ".");  
 
  } 
}
