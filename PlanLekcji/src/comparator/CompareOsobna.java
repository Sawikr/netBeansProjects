/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import java.util.Comparator;

/**
 *
 * @author Danuta
 */
public class CompareOsobna implements Comparator<Nauczyciel>{
    
    @Override
    public int compare(Nauczyciel o1, Nauczyciel o2) {
        int flag = o1.getId() - o2.getId();
        
        if(flag==0) {
            flag = o1.getName().compareTo(o2.getName());
            
            System.out.println(flag);
                        
        }
        if(flag==0) {
            flag = o2.getLiczbaGodzin() - o1.getLiczbaGodzin(); 
            
        }
        if(flag==0) {
            flag = (int) (o2.getLiczbaNadgodzin()- o1.getLiczbaNadgodzin()); 
            
        }
        return flag;
    }
}