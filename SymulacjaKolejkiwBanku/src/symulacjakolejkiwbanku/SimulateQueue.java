package symulacjakolejkiwbanku;

// Program P6.6

import java.util.*;

public class SimulateQueue {
    
   public static void main(String[] args) {
       
      Scanner in = new Scanner(System.in);
      System.out.printf("\nIle jest stanowisk obsługi? ");
      int numCounters = in.nextInt();
      System.out.printf("\nIle będzie klientów? ");
      int numCustomers = in.nextInt();

      doSimulation(numCounters, numCustomers);
   }

   public static void doSimulation(int counters, int customers) {
       
      int m, arriveTime, startServe, serveTime, waitTime;
      // czas zwolnienia danego stanowiska, depart[1] - 1 minuta
      int[] depart = new int[counters + 1];// jest 1 ponieważ zaczynamy pętlę for od 1
      
      for (int h = 1; h <= counters; h++) depart[h] = 0;
      System.out.printf("\n       Czas      Początek              Czas     Koniec  Czas\n");
      System.out.printf("Klient przybycia obsługi   Stanowisko  obsługi  obsługi oczekiwania\n\n");
      
      arriveTime = 0;
      for (int h = 1; h <= customers; h++) {
         arriveTime += random(1, 5);// tutaj jest +=
         m = smallest(depart, 1, counters);
         startServe = Math.max(arriveTime, depart[m]);
         serveTime = random(3, 10);
         depart[m] = startServe + serveTime;
         waitTime = startServe - arriveTime;
         System.out.printf("%4d %8d %7d %8d %11d %8d %7d\n",
            h, arriveTime, startServe, m, serveTime, depart[m], waitTime);
      } //koniec for h
   } //koniec doSimulation

   public static int smallest(int list[], int lo, int hi) {
   //funkcja zwraca indeks najmniejszej wartości z zakresu 
   //tablicy list[lo ... hi]
      int h, k = lo;
      for (h = lo + 1; h <= hi; h++)
         if (list[h] < list[k]) k = h;
      return k;
   }

   public static int random(int m, int n) {
   //funkcja zwraca liczbę losową z zakresu od m do n, włącznie
      return (int) (Math.random() * (n - m + 1)) + m;
   }
}