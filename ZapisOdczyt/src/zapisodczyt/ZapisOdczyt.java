/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zapisodczyt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;

/**
 *
 * @author Radosław Sawicki
 */
public class ZapisOdczyt {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        File plik = new File("Text.txt");
        if(!(plik.exists()))
        {
            plik.createNewFile();
        }
        
        System.out.println(new Date(plik.lastModified()));
        System.out.println(plik.length());
        
        // tworzenie katalogu        
        File katalog =  new File("Kata" + File.separator + "Kac");
        if(!(katalog.exists()))
        {
            katalog.mkdirs();
        }
        
        // inny sposób na tworzenie katalogu i zawartości katalogu
        // musi być już stworzona ścieżka
        File plik2 = new File("Kata" + File.separator + "Kac", "Plik.txt");
        if(!(plik2.exists()))
        {
            plik2.createNewFile();
        }
        
        System.out.println(System.getProperty("java.home"));
        
        System.out.println(plik.getAbsoluteFile());
        System.out.println(plik.getCanonicalPath());
        
        System.out.println();
        
        ZapisOdczyt.nazwaSciezki(new File(System.getProperty("user.dir")));
        
        System.out.println();
        
        System.out.println("Wypisujemy katalogi:");
        ZapisOdczyt.nazwaSciezki(new File(katalog.getPath()));
        
        ///////////////////////////////////////////////////////////////
        
        File nowyPlik = new File("Zapis.txt");
        
        Writer zapis = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nowyPlik)));

        ((BufferedWriter)zapis).write("Jestem plikiem");
        ((BufferedWriter)zapis).newLine();
        ((BufferedWriter)zapis).write("Nowy wpis");
        ((BufferedWriter)zapis).close();
           
    }
    
    public static void nazwaSciezki(File nazwa){
        
        String[] nazwaScieckiPath = nazwa.list();
        
        System.out.println(nazwa.getPath());
        
        for(int i = 0; i < nazwaScieckiPath.length; i++)
        {
            // podajemy najpierw nazwę ścieżki jak w pliku2 (drugi sposób), a potem jakich elementów szukamy
            File p = new File(nazwa.getPath(), nazwaScieckiPath[i]);
            
            System.out.println(p.getPath());
            
            if(p.isFile()){
                // bez wywołania metody nazwaSciezki() i new File() bo w tej metodzie jest File p, a podaje ścieżkę katalogu, którego tu nie ma.
                System.out.println(p.getPath());
                System.out.println("-----------------");
                }
            
            if(p.isDirectory()){
                nazwaSciezki(new File(p.getPath()));
                }           
        }       
    }
}
