/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Radosław Sawicki
 */
public class MultiTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[][] myArr = new String[5][5];
        for (int i=0; i<myArr.length; i++) {
            myArr[i][0] = (i+1)+"1";//wypełnia kolumnę
            myArr[i][1] = (i+1)+"2";
            myArr[i][2] = (i+1)+"3";
            myArr[i][3] = (i+1)+"4";
            myArr[i][4] = (i+1)+"5";
        
            for(int j=0; j<myArr[i].length; j++){
                myArr[0][j] = (j+1)+"1";//wypełnia wiersz
                myArr[1][j] = (j+1)+"2";
                myArr[2][j] = (j+1)+"3";
                myArr[3][j] = (j+1)+"4";
                myArr[4][j] = (j+1)+"5";
             
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
        
        Collections.reverse(keyList);
        
        String[][] myNewArray1 = new String[5][5];
        a = 0;
        for (String s : keyList) {
            myNewArray1[a++] = ((String[])map.get(s));
            System.out.println(keyList);
        }
    }
    
}
