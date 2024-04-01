// Przykład prostej aplikacji korzystającej z modułów po dodaniu modułu SupportFuncs
package appstart.mymodappdemo; 
 
import appfuncs.simplefuncs.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;

public class MyModAppDemo2 { 
  public static void main(String[] args) { 
 
    if(SupportFuncs.isFactor(2, 10)) 
      System.out.println("Liczba 2 jest dzielnikiem liczby 10.");  
 
    System.out.println("Najmniejszym wspólnym dzielnikiem liczb 35 i 105 jest " + 
                       SimpleMathFuncs.lcf(35, 105) + ".");  
 
    System.out.println("Największym wspólny dzielnikiem liczb 35 i 105 jest " + 
                       SimpleMathFuncs.gcf(35, 105) + ".");  
 
  } 
}
