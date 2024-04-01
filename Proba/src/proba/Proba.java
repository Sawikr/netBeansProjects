/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Radosław Sawicki
 */
public class Proba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[][] myArr = new String[5][5];
        for (int i=0; i<myArr.length; i++) {
            myArr[i][0] = "Agnieszka";//wypełnia kolumnę
            myArr[i][1] = "Monika";
            myArr[i][2] = "Karolina";
            myArr[i][3] = "Bożena";
            myArr[i][4] = "Dagmara";
        
            for(int j=0; j<myArr[i].length; j++){
                myArr[0][j] = "Agnieszka";//wypełnia wiersz
                myArr[1][j] = "Monika";
                myArr[2][j] = "Karolina";
                myArr[3][j] = "Bożena";
                myArr[4][j] = "Dagmara";
             
                System.out.print(" "+myArr[i][j]);
            }
            System.out.println(" ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        for (int i=myArr.length-1; i>=0; i--) {
            map.put(myArr[i][0], myArr[i]);
        }

        List<String> keyList = new ArrayList<String>(map.keySet());

        Collections.sort(keyList);

        String[][] myNewArray = new String[5][5];
        int a = 0;
        for (String s : keyList) {
            myNewArray[a++] = (String[])(map.get(s));
            System.out.println(keyList);
            
        }
        System.out.println(" ");
        
//        Collections.reverse(keyList);
//        
//        String[][] myNewArray1 = new String[5][5];
//        a = 0;
//        for (String s : keyList) {
//            myNewArray1[a++] = ((String[])map.get(s));
//            System.out.println(keyList);
//        }
    }
}
