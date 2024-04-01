/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Danuta
 */
public class ComparatorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Nauczyciel[] empArr = new Nauczyciel[5];
        empArr[0] = new Nauczyciel(1, "Agnieszka Sawicka", 1, 7);
        empArr[1] = new Nauczyciel(2, "Agnieszka Helwig", 3, 2);
        empArr[2] = new Nauczyciel(3, "Dorota Pruch", 10, 3);
        empArr[3] = new Nauczyciel(4, "Monika Walikonia", 5, 5);
        empArr[4] = new Nauczyciel(5, "Agnieszka Bąk", 3, 10);
        
        
        //sort employees array using Comparator by Salary
        Arrays.sort(empArr, Nauczyciel.LiczbaGodzinComparator);
        System.out.println("Employees list sorted by liczbaGodzin:\n");
        
        int matematyka = 10;
        
        if (matematyka <= 10){
            for (int i = 0; i < empArr.length; i++) {
                    if (Nauczyciel.liczbaGodzinNauczyciela(empArr[i]) > 0){
                        System.out.println(empArr[i]);
                        Nauczyciel.liczbaGodzinNauczycielaMinus(empArr[i]);
                        matematyka--;
                    }
                }
            System.out.println(" ");
            System.out.println("Zostało " + matematyka + " lekcji matematyki.\n"); 
        }
        
        Arrays.sort(empArr, Nauczyciel.LiczbaNadgodzinComparator);
        if (matematyka <= 5){
            for (int i = 0; i < empArr.length; i++) {
                    if (Nauczyciel.liczbaGodzinNauczyciela(empArr[i]) > 0){
                        System.out.println(empArr[i]);
                        Nauczyciel.liczbaGodzinNauczycielaMinus(empArr[i]);
                        matematyka--;
                    } 
                }     
        }
        
        Arrays.sort(empArr, Nauczyciel.LiczbaNadgodzinComparator);
        if (matematyka <= 5){
            for (int i = 0; i < empArr.length; i++) {
                    if (Nauczyciel.liczbaGodzinNauczyciela(empArr[i]) > 0){
                        System.out.println(empArr[i]);
                        Nauczyciel.liczbaGodzinNauczycielaMinus(empArr[i]);
                        matematyka--;
                        break;
                    } 
                }
            
            System.out.println(" ");
            System.out.println("Zostało " + matematyka + " lekcji matematyki.\n");         
        }
        
       
        // Losowanie
        for (int i = 0; i < empArr.length; i++) {
                int idxR = new Random().nextInt(empArr.length);
                System.out.println(empArr[idxR]);
                }
        
        System.out.println(" ");
        for (int i = 0; i < empArr.length; i++) {
                int zakres = empArr.length-1;
                int szczesliwynumerek = (int)Math.round(Math.random()*zakres);
                System.out.println(empArr[szczesliwynumerek]);
                }
        
        System.out.println(" ");
        TabliceSortowanie.main(args);
        System.out.println(" ");
        
        
        
        
        
        
        
    
        //sorting employees array using Comparable interface implementation
//        Arrays.sort(empArr);
//        System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr)+"\n");
        
//        //sort employees array using Comparator by Age
//        Arrays.sort(empArr, Nauczyciel.LiczbaNadgodzinComparator);
//        System.out.println("\nEmployees list sorted by liczbaNadgodzin:\n\n"+Arrays.toString(empArr)+"\n");
//        
//        //sort employees array using Comparator by Name
//        Arrays.sort(empArr, Nauczyciel.NameComparator);
//        System.out.println("Employees list sorted by Name:\n\n"+Arrays.toString(empArr)+"\n");
//        
//        //Employees list sorted by ID and then name using Comparator class
//        empArr[0] = new Nauczyciel(1, "Agnieszka Sawicka", 17, 2);
//        Arrays.sort(empArr, new CompareOsobna());
//        System.out.println("Employees list sorted by ID and Name:\n\n"+Arrays.toString(empArr)+"\n");
//        
//        //Tablica wielowymiarowa
//        Nauczyciel[][] nowaTabela = new Nauczyciel[8][5];
//        nowaTabela[0][0] = empArr[4];
//        nowaTabela[1][0] = empArr[0];
//             
//        //Tworzenie tablicy wielowymiarowej
//        for (int i = 0; i < nowaTabela.length; i++) {
//            for (int j = 0; j < nowaTabela[i].length; j++) {
//                System.out.print(nowaTabela[i][j]);
//            }
//            System.out.println();
//        }
//        
//        System.out.println();
//        
//        for (int i = 0; i < nowaTabela.length; i++) {
//            for (int j = 0; j < nowaTabela[i].length; j++) {
//                System.out.print(nowaTabela[i][j]);
//            }
//            System.out.println();
//        }
//        Arrays.deepToString(nowaTabela);
    }
}