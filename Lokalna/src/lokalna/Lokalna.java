/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lokalna;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalAdjusters.firstInMonth;

/**
 *
 * @author Radosław Sawicki
 */
public class Lokalna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LocalDate now1 = LocalDate.now();
        int todayNext = now1.getMonthValue();
        
        LocalDate now = now1.plusMonths(todayNext);
        
        LocalDate firstWtorek = now.with(firstInMonth(DayOfWeek.TUESDAY));
        LocalDate firstCzwartek = now.with(firstInMonth(DayOfWeek.THURSDAY));
        LocalDate firstSobota = now.with(firstInMonth(DayOfWeek.SATURDAY));
        LocalDate firstNiedziela = now.with(firstInMonth(DayOfWeek.SUNDAY));
        
        boolean resultWtorek = jestPrawdaWtorek (firstWtorek, firstCzwartek, firstSobota, firstNiedziela);
        boolean resultCzwartek = jestPrawdaCzwartek (firstCzwartek, firstSobota, firstNiedziela);
        boolean resultSobota = jestPrawdaSobota (firstSobota, firstNiedziela);
        boolean resultNiedziela = jestPrawdaNiedziela (firstNiedziela, firstWtorek);
        
        /**
         * Kontrola obliczeń
         */
        
//        System.out.println(firstWtorek);
//        System.out.println(firstCzwartek);
//        System.out.println(firstSobota);
//        System.out.println(firstNiedziela);
//        
//        System.out.println(resultWtorek);
//        System.out.println(resultCzwartek);
//        System.out.println(resultSobota);
//        System.out.println(resultNiedziela);
        
        wykonajRuch(resultWtorek, resultCzwartek, resultSobota, resultNiedziela);
                    
    }
    
    static boolean jestPrawdaWtorek (LocalDate resultWtorek, LocalDate resultCzwartek, LocalDate resultSobota, LocalDate resultNiedziela){
            
        if((resultWtorek.isBefore(resultCzwartek)) && (resultWtorek.isBefore(resultSobota)) && (resultWtorek.isBefore(resultNiedziela))){    
            return true;
        } 
        return false;
    }
    
    static boolean jestPrawdaCzwartek (LocalDate resultCzwartek, LocalDate resultSobota, LocalDate resultNiedziela){
            
        if((resultCzwartek.isBefore(resultSobota)) && (resultCzwartek.isBefore(resultNiedziela))){    
            return true;
        }
        else
        return false;
    }   
    
    static boolean jestPrawdaSobota (LocalDate resultSobota, LocalDate resultNiedziela){
            
        if((resultSobota.isBefore(resultNiedziela))){    
            return true;
        }         
        return false;
    }   
    
    static boolean jestPrawdaNiedziela (LocalDate resultNiedziela, LocalDate resultWtorek){
            
        if((resultNiedziela.isBefore(resultWtorek))){    
            return true;
        }         
        return false;
    }   
   
    static void wykonajRuch (boolean resultWtorek, boolean resultCzwartek, boolean resultSobota, boolean resultNiedziela){
            
        if(resultWtorek == true) {
            
           LocalDate now1 = LocalDate.now();
           int todayNext = now1.getMonthValue();
           LocalDate now = now1.plusMonths(todayNext);
           LocalDate firstWtorek = now.with(firstInMonth(DayOfWeek.TUESDAY)); 
           String nextWtorek = firstWtorek.format(DateTimeFormatter.ofPattern("d MMMM yyyy"));       
           System.out.println("Pierwsza zbiórka we wtorek: " + nextWtorek);
           System.out.println(" ");
           wtorek();
        }
        else if(resultCzwartek == true){
           
           LocalDate now1 = LocalDate.now();
           int todayNext = now1.getMonthValue();
           LocalDate now = now1.plusMonths(todayNext);
           LocalDate firstCzwartek = now.with(firstInMonth(DayOfWeek.THURSDAY)); 
           String nextCzwartek = firstCzwartek.format(DateTimeFormatter.ofPattern("d MMMM yyyy"));  
           System.out.println("Pierwsza zbiórka we czwartek: " + nextCzwartek);
           System.out.println(" ");
           czwartek();
                      
        }
        else if(resultSobota == true){
           
           LocalDate now1 = LocalDate.now();
           int todayNext = now1.getMonthValue();
           LocalDate now = now1.plusMonths(todayNext);
           LocalDate firstSobota = now.with(firstInMonth(DayOfWeek.SATURDAY));
           String nextSobota = firstSobota.format(DateTimeFormatter.ofPattern("d MMMM yyyy"));       
           System.out.println("Pierwsza zbiórka w sobotę: " + nextSobota);
           System.out.println(" ");
           sobota();
           
        }
        else if(resultNiedziela == true){
            
           LocalDate now1 = LocalDate.now();
           int todayNext = now1.getMonthValue();
           LocalDate now = now1.plusMonths(todayNext);
           LocalDate firstNiedziela = now.with(firstInMonth(DayOfWeek.SUNDAY));
           String nextNiedziela = firstNiedziela.format(DateTimeFormatter.ofPattern("d MMMM yyyy")); 
           System.out.println("Pierwsza zbiórka w niedzielę: " + nextNiedziela);           
           System.out.println(" ");
           niedziela(); 
        }   
    }
   
    private static void sobota(){
        
        LocalDate now1 = LocalDate.now();
        int todayNext = now1.getMonthValue();
        LocalDate now = now1.plusMonths(todayNext);
        LocalDate firstSobota1 = now.with(firstInMonth(DayOfWeek.SATURDAY));
       
        String nextPlus = firstSobota1.format(DateTimeFormatter.ofPattern("d MMMM"));           
        System.out.println(nextPlus + " - Sobota");
        
        LocalDate nextPlus1L = firstSobota1.plusDays(1);
        String nextPlus1 = nextPlus1L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus1 + " - Niedziela");
        
        LocalDate nextPlus2L = firstSobota1.plusDays(3);
        String nextPlus2 = nextPlus2L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus2 + " - Wtorek");
        
        LocalDate nextPlus3L = firstSobota1.plusDays(5);
        String nextPlus3 = nextPlus3L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus3 + " - Czwartek");
        
        LocalDate nextPlus4L = firstSobota1.plusDays(7);
        String nextPlus4 = nextPlus4L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus4 + " - Sobota");
        
        LocalDate nextPlus5L = firstSobota1.plusDays(8);
        String nextPlus5 = nextPlus5L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus5 + " - Niedziela");
        
        LocalDate nextPlus6L = firstSobota1.plusDays(10);
        String nextPlus6 = nextPlus6L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus6 + " - Wtorek");
        
        LocalDate nextPlus7L = firstSobota1.plusDays(12);
        String nextPlus7 = nextPlus7L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus7 + " - Czwartek");
        
        LocalDate nextPlus8L = firstSobota1.plusDays(14);
        String nextPlus8 = nextPlus8L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus8 + " - Sobota");
        
        LocalDate nextPlus9L = firstSobota1.plusDays(15);
        String nextPlus9 = nextPlus9L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus9 + " - Niedziela");
        
        LocalDate nextPlus10L = firstSobota1.plusDays(17);
        String nextPlus10 = nextPlus10L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus10 + " - Wtorek");
        
        LocalDate nextPlus11L = firstSobota1.plusDays(19);
        String nextPlus11 = nextPlus11L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus11 + " - Czwartek");
        
        LocalDate nextPlus12L = firstSobota1.plusDays(21);
        String nextPlus12 = nextPlus12L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus12 + " - Sobota");
        
        LocalDate nextPlus13L = firstSobota1.plusDays(22);
        String nextPlus13 = nextPlus13L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus13 + " - Niedziela");
        
        LocalDate nextPlus14L = firstSobota1.plusDays(24);
        String nextPlus14 = nextPlus14L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus14 + " - Wtorek");
        
        LocalDate nextPlus15L = firstSobota1.plusDays(26);
        String nextPlus15 = nextPlus15L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus15 + " - Czwartek");
        
        LocalDate nextPlus16L = firstSobota1.plusDays(28);
        String nextPlus16 = nextPlus16L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus16 + " - Sobota");
        
        LocalDate nextPlus17L = firstSobota1.plusDays(29);
        String nextPlus17 = nextPlus17L.format(DateTimeFormatter.ofPattern("d MMMM"));
        if(nextPlus17L == now){
            System.out.println(nextPlus17 + " - Niedziela");
        }
        LocalDate nextPlus18L = firstSobota1.plusDays(31);
        String nextPlus18 = nextPlus18L.format(DateTimeFormatter.ofPattern("d MMMM"));
        if(nextPlus18L == now){
            System.out.println(nextPlus18 + " - Wtorek");
          }
    }

    private static void wtorek() {
        LocalDate now1 = LocalDate.now();
        int todayNext = now1.getMonthValue();
        LocalDate now = now1.plusMonths(todayNext);
        LocalDate firstSobota1 = now.with(firstInMonth(DayOfWeek.TUESDAY));// zmiana na wtorek - firstWtorek
        
        String nextPlus = firstSobota1.format(DateTimeFormatter.ofPattern("d MMMM"));           
        System.out.println(nextPlus + " - Wtorek");
        
        LocalDate nextPlus1L = firstSobota1.plusDays(2);
        String nextPlus1 = nextPlus1L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus1 + " - Czwartek");
        
        LocalDate nextPlus2L = firstSobota1.plusDays(4);
        String nextPlus2 = nextPlus2L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus2 + " - Sobota");
        
        LocalDate nextPlus3L = firstSobota1.plusDays(5);
        String nextPlus3 = nextPlus3L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus3 + " - Niedziela");
        
        LocalDate nextPlus4L = firstSobota1.plusDays(7);
        String nextPlus4 = nextPlus4L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus4 + " - Wtorek");
        
        LocalDate nextPlus5L = firstSobota1.plusDays(9);
        String nextPlus5 = nextPlus5L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus5 + " - Czwartek");
        
        LocalDate nextPlus6L = firstSobota1.plusDays(11);
        String nextPlus6 = nextPlus6L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus6 + " - Sobota");
        
        LocalDate nextPlus7L = firstSobota1.plusDays(12);
        String nextPlus7 = nextPlus7L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus7 + " - Niedziela");
        
        LocalDate nextPlus8L = firstSobota1.plusDays(14);
        String nextPlus8 = nextPlus8L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus8 + " - Wtorek");
        
        LocalDate nextPlus9L = firstSobota1.plusDays(16);
        String nextPlus9 = nextPlus9L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus9 + " - Czwartek");
        
        LocalDate nextPlus10L = firstSobota1.plusDays(18);
        String nextPlus10 = nextPlus10L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus10 + " - Sobota");
        
        LocalDate nextPlus11L = firstSobota1.plusDays(19);
        String nextPlus11 = nextPlus11L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus11 + " - Niedziela");
        
        LocalDate nextPlus12L = firstSobota1.plusDays(21);
        String nextPlus12 = nextPlus12L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus12 + " - Wtorek");
        
        LocalDate nextPlus13L = firstSobota1.plusDays(23);
        String nextPlus13 = nextPlus13L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus13 + " - Czwartek");
        
        LocalDate nextPlus14L = firstSobota1.plusDays(25);
        String nextPlus14 = nextPlus14L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus14 + " - Sobota");
        
        LocalDate nextPlus15L = firstSobota1.plusDays(26);
        String nextPlus15 = nextPlus15L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus15 + " - Niedziela");
        
        LocalDate nextPlus16L = firstSobota1.plusDays(28);
        String nextPlus16 = nextPlus16L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus16 + " - Wtorek");
        
        LocalDate nextPlus17L = firstSobota1.plusDays(30);
        String nextPlus17 = nextPlus17L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        if(nextPlus17L == now){
            System.out.println(nextPlus17 + " - Czwartek");
        }
        LocalDate nextPlus18L = firstSobota1.plusDays(32);
        String nextPlus18 = nextPlus18L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        if(nextPlus18L == now){
            System.out.println(nextPlus18 + " - Sobota");
        }
    }

    private static void czwartek() {
        
        LocalDate now1 = LocalDate.now();
        int todayNext = now1.getMonthValue();
        LocalDate now = now1.plusMonths(todayNext);
        LocalDate firstSobota1 = now.with(firstInMonth(DayOfWeek.THURSDAY));// zmiana na wtorek - firstCzwartek
        
        String nextPlus = firstSobota1.format(DateTimeFormatter.ofPattern("d MMMM"));   
        System.out.println(nextPlus + " - Czwartek");
        
        LocalDate nextPlus1L = firstSobota1.plusDays(2);
        String nextPlus1 = nextPlus1L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus1 + " - Sobota");
        
        LocalDate nextPlus2L = firstSobota1.plusDays(3);
        String nextPlus2 = nextPlus2L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus2 + " - Niedziela");
        
        LocalDate nextPlus3L = firstSobota1.plusDays(5);
        String nextPlus3 = nextPlus3L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus3 + " - Wtorek");
        
        LocalDate nextPlus4L = firstSobota1.plusDays(7);
        String nextPlus4 = nextPlus4L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus4 + " - Czwartek");
        
        LocalDate nextPlus5L = firstSobota1.plusDays(9);
        String nextPlus5 = nextPlus5L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus5 + " - Sobota");
        
        LocalDate nextPlus6L = firstSobota1.plusDays(10);
        String nextPlus6 = nextPlus6L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus6 + " - Niedziela");
        
        LocalDate nextPlus7L = firstSobota1.plusDays(12);
        String nextPlus7 = nextPlus7L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus7 + " - Wtorek");
        
        LocalDate nextPlus8L = firstSobota1.plusDays(14);
        String nextPlus8 = nextPlus8L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus8 + " - Czwartek");
        
        LocalDate nextPlus9L = firstSobota1.plusDays(16);
        String nextPlus9 = nextPlus9L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus9 + " - Sobota");
        
        LocalDate nextPlus10L = firstSobota1.plusDays(17);
        String nextPlus10 = nextPlus10L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus10 + " - Niedziela");
        
        LocalDate nextPlus11L = firstSobota1.plusDays(19);
        String nextPlus11 = nextPlus11L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus11 + " - Wtorek");
        
        LocalDate nextPlus12L = firstSobota1.plusDays(21);
        String nextPlus12 = nextPlus12L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus12 + " - Czwartek");
        
        LocalDate nextPlus13L = firstSobota1.plusDays(23);
        String nextPlus13 = nextPlus13L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus13 + " - Sobota");
        
        LocalDate nextPlus14L = firstSobota1.plusDays(24);
        String nextPlus14 = nextPlus14L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus14 + " - Niedziela");
        
        LocalDate nextPlus15L = firstSobota1.plusDays(26);
        String nextPlus15 = nextPlus15L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus15 + " - Wtorek");
        
        LocalDate nextPlus16L = firstSobota1.plusDays(28);
        String nextPlus16 = nextPlus16L.format(DateTimeFormatter.ofPattern("d MMMM"));
        System.out.println(nextPlus16 + " - Czwartek");
        
        LocalDate nextPlus17L = firstSobota1.plusDays(30);
        String nextPlus17 = nextPlus17L.format(DateTimeFormatter.ofPattern("d MMMM"));
        if(nextPlus17L == now){
            System.out.println(nextPlus17 + " - Sobota");
        }
        LocalDate nextPlus18L = firstSobota1.plusDays(31);
        String nextPlus18 = nextPlus18L.format(DateTimeFormatter.ofPattern("d MMMM"));
        if(nextPlus18L == now){
            System.out.println(nextPlus18 + " - Niedziela");
        }
    }

    private static void niedziela() {
        LocalDate now1 = LocalDate.now();
        int todayNext = now1.getMonthValue();
        LocalDate now = now1.plusMonths(todayNext);
        LocalDate firstSobota1 = now.with(firstInMonth(DayOfWeek.SUNDAY));//firstNiedziela
        
        String nextPlus = firstSobota1.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus + " - Niedziela");
        
        LocalDate nextPlus2L = firstSobota1.plusDays(2);
        String nextPlus2 = nextPlus2L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus2 + " - Wtorek");
        
        LocalDate nextPlus3L = firstSobota1.plusDays(4);
        String nextPlus3 = nextPlus3L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus3 + " - Czwartek");
        
        LocalDate nextPlus4L = firstSobota1.plusDays(6);
        String nextPlus4 = nextPlus4L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus4 + " - Sobota");
        
        LocalDate nextPlus5L = firstSobota1.plusDays(7);
        String nextPlus5 = nextPlus5L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus5 + " - Niedziela");
        
        LocalDate nextPlus6L = firstSobota1.plusDays(9);
        String nextPlus6 = nextPlus6L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus6 + " - Wtorek");
        
        LocalDate nextPlus7L = firstSobota1.plusDays(11);
        String nextPlus7 = nextPlus7L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus7 + " - Czwartek");
       
        LocalDate nextPlus8L = firstSobota1.plusDays(13);
        String nextPlus8 = nextPlus8L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus8 + " - Sobota");
        
        LocalDate nextPlus9L = firstSobota1.plusDays(14);
        String nextPlus9 = nextPlus9L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus9 + " - Niedziela");
        
        LocalDate nextPlus10L = firstSobota1.plusDays(16);
        String nextPlus10 = nextPlus10L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus10 + " - Wtorek");
        
        LocalDate nextPlus11L = firstSobota1.plusDays(18);
        String nextPlus11 = nextPlus11L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus11 + " - Czwartek");
        
        LocalDate nextPlus12L = firstSobota1.plusDays(20);
        String nextPlus12 = nextPlus12L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus12 + " - Sobota");
        
        LocalDate nextPlus13L = firstSobota1.plusDays(21);
        String nextPlus13 = nextPlus13L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus13 + " - Niedziela");
        
        LocalDate nextPlus14L = firstSobota1.plusDays(23);
        String nextPlus14 = nextPlus14L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus14 + " - Wtorek");
        
        LocalDate nextPlus15L = firstSobota1.plusDays(25);
        String nextPlus15 = nextPlus15L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus15 + " - Czwartek");
        
        LocalDate nextPlus16L = firstSobota1.plusDays(27);
        String nextPlus16 = nextPlus16L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        System.out.println(nextPlus16 + " - Sobota");
        
        LocalDate nextPlus17L = firstSobota1.plusDays(28);
        String nextPlus17 = nextPlus17L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        if(nextPlus17L == now){
            System.out.println(nextPlus17 + " - Niedziela");
        }
        LocalDate nextPlus18L = firstSobota1.plusDays(30);
        String nextPlus18 = nextPlus18L.format(DateTimeFormatter.ofPattern("d MMMM")); 
        if(nextPlus18L == now){
            System.out.println(nextPlus18 + " - Wtorek");
        }
    }
}
       