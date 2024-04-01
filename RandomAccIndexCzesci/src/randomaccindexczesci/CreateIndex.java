package randomaccindexczesci;

// Program P7.8

import java.io.*;
import java.util.*;

public class CreateIndex {
    
   static final int StringFixedLength = 20;
   static final int PartNumSize = 6;
   static final int PartRecordSize = 64;
   static final int MaxRecords = 100;
   static final String EndOfData = "END";

   public static void main(String[] args) throws IOException {
       
      RandomAccessFile fp = new RandomAccessFile("parts.bin", "rw");
      Index[] index = new Index[MaxRecords + 1];

      createMasterIndex(index, fp);
      saveIndex(index);
      printIndex(index);
      fp.close();
   } //koniec main

   public static void createMasterIndex(Index[] index, RandomAccessFile f) throws IOException {
       
      Scanner in = new Scanner(new FileReader("parts.txt"));
      
      int numRecords = 0;
      Part part = getPartData(in);
      
      while (part != null) {
         int searchResult = search(part.partNum, index, numRecords);
          System.out.println("Pierwsza: " + searchResult);
         
         if (searchResult > 0)
            System.out.printf("Powtórzona część... ignorujemy część %s.\n", part.partNum);
         else { //to nowy numer części; wstawiamy location -searchResult
            if (numRecords == MaxRecords) {
               System.out.printf("Zbyt wiele rekordów: dopuszczalna liczba to %d.\n", MaxRecords);
               System.exit(1);
            }
            //jest miejsce w tablicy index; przesuwamy wpisy by wstawić nową część
            for (int h = numRecords; h >= -searchResult; h--)
                    index[h + 1] = index[h];
            index[-searchResult] = new Index(part.partNum, ++numRecords);
                System.out.println("Druga: " + -searchResult);
            writePartToFile(part, f);
         }
         part = getPartData(in);
      } //koniec while
      index[0] = new Index("NOPART", numRecords);
      in.close();
   } //koniec createMasterIndex

   public static Part getPartData(Scanner in) {
       
      String pnum = in.next();
      if (pnum.equals(EndOfData)) return null;
      return new Part(pnum, in.next(), in.nextInt(), in.nextDouble());
   } //koniec getPartData

   public static void writePartToFile(Part part, RandomAccessFile f) throws IOException {
       
      for (int h = 0; h < PartNumSize; h++) f.writeChar(part.partNum.charAt(h));
      int n = Math.min(part.name.length(), StringFixedLength);
      for (int h = 0; h < n; h++) f.writeChar(part.name.charAt(h));
      for (int h = n; h < StringFixedLength; h++) f.writeChar(' ');
      f.writeInt(part.amtInStock);
      f.writeDouble(part.price);
   } //koniec writePartToFile

   public static void saveIndex(Index[] index) throws IOException {
       
      RandomAccessFile f = new RandomAccessFile("index.bin", "rw");
      int numRecords = index[0].recNum;
      //wypełniamy nieużywane pozycje indeksu fikcyjnymi wpisami
      for (int h = numRecords+1; h <= MaxRecords; h++)
         index[h] = new Index("NOPART", 0);
      f.writeInt(MaxRecords);
      for (int h = 0; h <= MaxRecords; h++) {
         for (int i = 0; i < PartNumSize; i++)
               f.writeChar(index[h].partNum.charAt(i));
         f.writeInt(index[h].recNum);
      }
      f.close();
   } //koniec saveIndex

   public static int search(String key, Index[] list, int n) {
   //funkcja przegląda tablicę list[1..n] w poszukiwaniu klucza; jeśli go 
   //znajdzie, to zwraca jego lokalizację; w przeciwnym razie zwraca ujemną 
   //wartość określającą miejsce gdzie dany klucz powinien został wstawiony.
      int lo = 1, hi = n;
      while (lo <= hi) {   // dopóki są jakieś elementy do sprawdzenia
         int mid = (lo + hi) / 2;
         System.out.println("Mid: " + mid);// moja
         int cmp = key.compareToIgnoreCase(list[mid].partNum);
         if (cmp == 0) return mid;  // udało się znaleźć klucz // zwraca tylko to lub -lo (poniżej)
         if (cmp < 0) hi = mid - 1;   // klucz jest 'mniejszy' od list[mid].partNum
         else lo = mid + 1;     // klucz jest 'większy' od list[mid].partNum
      }
      return -lo;         // nie zaleziono klucza; należy go wstawić w miejscu lo
   } //koniec search

   public static void printIndex(Index[] index) {
       
      System.out.printf("\nZawartość indeksu: \n\n");
      int numRecords = index[0].recNum;
      for (int h = 1; h <= numRecords; h++)
         System.out.printf("%s %2d\n", index[h].partNum, index[h].recNum);
   } //koniec printIndex
} //koniec klasy CreateIndex
         
class Part {
    
   String partNum, name;
   int amtInStock;
   double price;

   public Part(String pn, String n, int a, double p) {
       
      partNum = pn;
      name = n;
      amtInStock = a;
      price = p;
   }

   public void printPart() {
       
      System.out.printf("Numer części: %s\n", partNum);
      System.out.printf("Nazwa części: %s\n", name);
      System.out.printf("Liczba dostępnych części: %d\n", amtInStock);
      System.out.printf("Cena: %3.2f zł\n", price);
   }
} //koniec klasy Part

class Index {
    
   String partNum;
   int recNum;

   public Index(String p, int r) {
       
      partNum = p;
      recNum = r;
   }
} //koniec klasy Index