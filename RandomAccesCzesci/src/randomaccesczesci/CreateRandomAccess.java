package randomaccesczesci;

// Program P7.6

import java.io.*;
import java.util.*;

public class CreateRandomAccess {
    
   static final int StringFixedLength = 20;
   static final int PartNumSize = 6;
   static final int PartRecordSize = 64;
   static final String EndOfData = "END";
  
   public static void main(String[] args) throws IOException {
       
      Scanner in = new Scanner(new FileReader("parts.txt"));
      RandomAccessFile fp = new RandomAccessFile("parts.bin", "rw");
      Part part = getPartData(in);
      
      while (part != null) {
         writePartToFile(part, fp);
         part = getPartData(in);
      }
   } //koniec main
  
     public static Part getPartData(Scanner in) {
         
      String pnum = in.next();
      if (pnum.equals(EndOfData)) return null;
      return new Part(pnum, in.next(), in.nextInt(), in.nextDouble());
   } //koniec getPartData
  
     public static void writePartToFile(Part part, RandomAccessFile f) throws IOException {
      // -15 to przesunięcie w lewo   
      System.out.printf("%s %-15s %2d %5.2f %3d\n", part.partNum, part.name, part.amtInStock, part.price, f.getFilePointer());
      
      for (int h = 0; h < PartNumSize; h++) f.writeChar(part.partNum.charAt(h));
      int n = Math.min(part.name.length(), StringFixedLength);
      for (int h = 0; h < n; h++) f.writeChar(part.name.charAt(h));
      for (int h = n; h < StringFixedLength; h++) f.writeChar(' ');
      f.writeInt(part.amtInStock);
      f.writeDouble(part.price);
   } //koniec writePartToFile
} //koniec klasy CreateRandomAccess

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
}