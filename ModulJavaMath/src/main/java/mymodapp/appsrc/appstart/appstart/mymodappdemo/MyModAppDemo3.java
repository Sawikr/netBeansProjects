// Aplikacja modularna prezentująca zastosowanie uługi 
// oraz dostawców usług

package appstart.mymodappdemo; 
 
import java.util.ServiceLoader; 
 
import appfuncs.simplefuncs.SimpleMathFuncs; 
import userfuncs.binaryfuncs.*; 
 
public class MyModAppDemo3 { 
  public static void main(String[] args) { 
 
    // W pierwszej kolejności wypróbujemy metody wbudowane 
    if(SimpleMathFuncs.isFactor(2, 10)) 
      System.out.println("Liczba 2 jest dzielnikiem liczby 10.");  
 
    System.out.println("Najmniejszym wspólnym dzielnikiem liczb 35 i 105 jest " + 
                       SimpleMathFuncs.lcf(35, 105) + ".");  
 
    System.out.println("Największym wspólny dzielnikiem liczb 35 i 105 jest " + 
                       SimpleMathFuncs.gcf(35, 105) + ".");  
 
 
    // A teraz użyjemy operacji udostępnionych w formie usług
 
    // Pobiera obiekt wczytujący usługi operujący na funkcjach binarnych
    ServiceLoader<BinFuncProvider> ldr =  
      ServiceLoader.load(BinFuncProvider.class); 
 
    BinaryFunc binOp = null; 
 
    // Odnajduje dostawcę funkcji absPlus i pobiera tę funkcję
    for(BinFuncProvider bfp : ldr) { 
      if(bfp.get().getName().equals("absPlus")) { 
        binOp = bfp.get(); 
        break; 
      } 
    } 
 
    if(binOp != null)  
      System.out.println("Wynik wywołania funkcji absPlus: " + 
                          binOp.func(12, -4) + "."); 
    else 
      System.out.println("Nie udało sięz znaleźć funkcji absPlus."); 
 
    binOp = null; 
 
    // Ten fragment odnajduje dostawcę funkcji absMinsu i pobiera tę funkcję
    for(BinFuncProvider bfp : ldr) { 
      if(bfp.get().getName().equals("absMinus")) {  
        binOp = bfp.get(); 
        break; 
      } 
    } 
 
    if(binOp != null)  
      System.out.println("Wynik wywołania function absMinus: " + 
                          binOp.func(12, -4) + "."); 
    else 
      System.out.println("Nie udało sięz znaleźć funkcji absMinus.");
 
  } 
}
