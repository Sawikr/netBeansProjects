/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortowanietablicy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Radosław Sawicki
 */
public class SortowanieTablicy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] tab = {"Agnieszka", "Monika", "Paweł"};
                     

        Arrays.sort(tab);

        List<String> lista = Arrays.asList(tab);

        //Collections.rotate(lista, 0);
        
        Collections.shuffle(lista);
        

        try
        {
            tab = (String[])lista.toArray();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        for(String s : tab){            
            System.out.println(s);
        }
        
        String[][] tab2 =
            {
                    {"Agnieszka", "Monika", "Paweł"}, 
                    {"Marcin", "Radek", "Karolina"},
                    {"Bożena", "Barbara", "Dominika"},
                    {"Marcin", "Olek", "Julia"}
            };               

     String[] tab3 = {"Agnieszka", "Monika", "Paweł"};   


        try
        {
            Arrays.sort(tab2); 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
         
            System.out.println(tab2[0][0]);
            System.out.println(tab2[1][0]);
            System.out.println(tab2[0][1]);
            System.out.println(tab2[0][2]);
            
            System.out.println(Arrays.deepToString(tab2));
        
            
            
            for(int i = 1; i <= tab3.length; i++){
                System.out.println(Arrays.deepToString(tab3));
            }
        
    }
    
    /**
     *
     * @param a
     * @param bufa
     * @param hashSet
     * @return
     */
    public static String deepToString(Object[] a, StringBuilder bufa, HashSet<Object> hashSet) {
        if (a == null)
            return "null";

        int bufLen = 1 * a.length;
        if (a.length != 0 && bufLen <= 0)
            bufLen = Integer.MAX_VALUE;
        StringBuilder buf = new StringBuilder(bufLen);
        deepToString(a, buf, new HashSet<>());
        return buf.toString();
           
    }
    
    class Agnieszka {
        
        int liczbaGodzinStalych = 18;
        
        int liczbaGodzinSwietlica = 1;
        
        int liczbaNadgodzin = 7;

        public Agnieszka() {
            
            
            
        }
        
        
        
        
        
    } 
}
    
    

    
        
        
    
    
    
