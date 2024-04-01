package liczbylosowegranim;

// Program P6.4

import java.util.*;

public class Nim {
    
   public static void main(String[] args) {
       
      Scanner in = new Scanner(System.in);
      System.out.printf("Podaj liczbę kamieni na stole: ");
      int remain = in.nextInt();
      System.out.printf("Maksymalna liczba kamieni zdejmowanych w jednym ruchu to: ");
      int maxPick = in.nextInt();
      System.out.println("\nZaczynamy grę!");
      System.out.println("Wygrywa gracz, który przeciwnika pozostawi z 1 kamieniem na stole");
      
      playGame(in, remain, maxPick);
   }
 
   public static void playGame(Scanner in, int remain, int maxPick) {
       
      int userPick;
      System.out.printf("\nNa stole pozostaje %d kamieni.\n", remain);
      
      while (true) { //pętla wykonywana aż do zakończenia gry
         do {
            System.out.printf("Twoja kolej, ile kamieni zdejmujesz?: ");
            userPick = in.nextInt();
            if (userPick > remain)
               System.out.printf("Nie możesz zdjąć więcej niż %d kamieni.\n", Math.min(remain, maxPick));
            else if (userPick < 1 || userPick > maxPick)
               System.out.printf("Nieprawidłowa liczba: wpisz liczbę od 1 do %d.\n", maxPick);
         } while (userPick > remain || userPick < 1 || userPick > maxPick);
 
         remain = remain - userPick;
         System.out.printf("Na stole pozostaje %d kamieni.\n", remain);
         if (remain == 0) {
            System.out.printf("Gracz: wygrałeś!!\n");  return;
         }
         if (remain == 1) {
            System.out.printf("\nGracz: wygrałem!!\n");  return;
         }
         
         int compPick = bestPick(remain, maxPick);
         
         System.out.printf("Komputer: zdejmuje ze stołu %d kamieni.\n", compPick);
         remain = remain - compPick;
         System.out.printf("Na stole pozostaje %d kamieni.\n", remain);
         if (remain == 0) {
            System.out.printf("\nKomputer: wygrałeś!!\n");
            return;
         }
         if (remain == 1) {
            System.out.printf("\nKomputer: wygrałem!!\n");
            return;
         }
      } //koniec while (true)
   }
 
   public static int bestPick(int remain, int maxPick) {
       
      if (remain <= maxPick) return remain - 1; //doprowadź do sytuacji przegrywającej
      int r = remain % (maxPick + 1);
      if (r == 0) return maxPick; //doprowadź do sytuacji przegrywającej
      if (r == 1) return random(1, maxPick); //program w sytuacji przegrywającej
      return r - 1; //gracz w sytuacji przegrywającej
   } //koniec bestPick
 
   public static int random(int m, int n) {
   //funkcja zwraca liczbę losową z zakresu od m do n, włącznie
      return (int) (Math.random() * (n - m + 1)) + m;
   }
}