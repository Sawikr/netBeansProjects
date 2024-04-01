/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

/**
 *
 * @author Danuta
 */
public class TabliceSortowanie {
    
    public static void main(String[] args) {
    
        int[] arr = {4,3,4,3,6,7,4,8,2,9};
        int[] brr = {2,3,6,8,1,5};

        /*System.out.println("Tablica 1 przed posortowaniem:");
        for(int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
        System.out.println("\n");

        System.out.println("Tablica 2 przed posortowaniem:");
        for(int i=0; i<m; i++)
            System.out.print(brr[i]+" ");
        System.out.println("\n");*/

        //sortuje tablice metodą quicksort
        quicksort(arr,0, arr.length-1);
        quicksort(brr,0, brr.length-1);

        /*System.out.println("Tablica 1 po posortowaniu:");
        for(int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
        System.out.println("\n");

        System.out.println("Tablica 2 po posortowaniu:");
        for(int i=0; i<m; i++)
            System.out.print(brr[i]+" ");
        System.out.println("\n");*/


        int loopCounter, jcounter ;
        //Inicjalizacja zmiennych
        //za pomocą loopCounter przechodze po 1 tablicy
        //za pomocą jcounter przechodze po 2 tablicy
        loopCounter = arr.length;
        jcounter = brr.length;

        //W lostOut przechowuje informację o tym jaka wartość została ostatnio zwrócona
        int lastOut = -1;
        //pętla for przechodzi po elementach tablict arr
        for (int i = 0, j=0; i < loopCounter ; i++) {

            //dopóki i wskazuje na większą wartość w tablicy arr niż j w tablicy brr
            //zwiększaj j;
            while (arr[i] > brr[j] && jcounter > j+1){
                j++;
            }
            //sprawdzam czy wartości z tablic arr i brr są równe
            //jeżeli są równe to pomijam dalszą część pętli
            if(arr[i] == brr[j]){
                continue;
            }
            //sprawdzam czy wartości z tablic arr i ostatnio wypisana wartość są równe
            //jeżeli są równe to pomijam dalszą część pętli
            if(arr[i]==lastOut){
                continue;
            }
            //wypisuje wartości
            System.out.print(arr[i]+"\t");
            //przekazuje do przechowania ostatnio wypisaną wartość
            lastOut = arr[i];
            //System.out.println(lastOut);
        }
    }

    private static void quicksort(int tablica[], int x, int y) {

        int i,j,v,temp;

        i=x;
        j=y;
        v=tablica[(x+y) / 2];
        do {
            while (tablica[i]<v)
                i++;
            while (v<tablica[j])
                j--;
            if (i<=j) {
                temp=tablica[i];
                tablica[i]=tablica[j];
                tablica[j]=temp;
                i++;
                j--;
            }
        }
        while (i<=j);
        if (x<j)
            quicksort(tablica,x,j);
        if (i<y)
            quicksort(tablica,i,y);
    }
}