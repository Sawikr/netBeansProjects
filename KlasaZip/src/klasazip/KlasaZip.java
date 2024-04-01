/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasazip;

import java.io.*;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.*;

/**
 *
 * @author Radosław Sawicki
 */
public class KlasaZip {

    /**
     * @param args the command line arguments
     */
    
    public static final int BUFFOR = 1024;
    
    public static void main(String[] args) throws IOException{
        
        byte[] tmpDataByte = new byte[BUFFOR];
        
        String[] pliki = new String[] {"nowyPlik.txt", "Nowy.bmp", "radek.txt"};
        
        try
        {
        
        ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("moj.zip")));
        
        for(int i = 0; i < pliki.length; i++)
            {
            BufferedInputStream zInS = new BufferedInputStream(new FileInputStream(pliki[i]), BUFFOR);// drugi parametr to <code>BUFFOR</code>

            zOutS.putNextEntry(new ZipEntry(pliki[i]));
            zOutS.setLevel(Deflater.BEST_COMPRESSION);// poziom kompresji
            zOutS.setMethod(ZipEntry.DEFLATED);// ustawia poziom kompresji dla wszystkich nieokreślonych metod

            int counter;
            while((counter = zInS.read(tmpDataByte, 0, BUFFOR)) != -1) // trzeba zwrócić int, -1 jak osiągnie się koniec streamu
                
                // teraz wczytujemy obiekty ZipEntry do archiwum
                zOutS.write(tmpDataByte, 0, counter);// ciekawostka: jak zrobię counter-1 to nie wczyta ostatniego wiersza

            zOutS.closeEntry();
            zInS.close();
            }
        
        zOutS.close();
            
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
      
        //Tworzenie katalogu przy uzyciu obiektu File
        //File nowyKatalog = new File(System.getProperty("user.dir") + File.separator + "moj");// ale może być też: new File("moj")
        //if(!nowyKatalog.exists()){
            //nowyKatalog.mkdir();
            //}
        
        Path nowyKatalog = Paths.get(System.getProperty("user.dir") + File.separator + "moj");// ale może też być Paths.get("moj")
        if(Files.notExists(nowyKatalog)){
            Files.createDirectory(nowyKatalog);
            }
        
        @SuppressWarnings("UnusedAssignment")
        ZipEntry wpis = null;
        
        try
        {
            
        ZipInputStream zzInS = new ZipInputStream(new FileInputStream("moj.zip"));
        
        while((wpis = zzInS.getNextEntry()) != null)
        {
            BufferedOutputStream fOuS = new BufferedOutputStream(new FileOutputStream(nowyKatalog + File.separator + wpis.getName()));// lub ("moj" + File.separator + wpis.getName()));
            
            int counter;
            
            while((counter = zzInS.read(tmpDataByte, 0, BUFFOR)) != -1)
                fOuS.write(tmpDataByte, 0, counter);
            
            fOuS.close();
            zzInS.closeEntry();
        }
            
        zzInS.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        // wykorzystanie klasy Paths do zip
        try
        {
        FileSystem fs = FileSystems.newFileSystem(Paths.get("moj.zip"), null);
        
        Path nowyKatalog2 = Paths.get("nowyKatalog");
        if(Files.notExists(nowyKatalog2)){
            Files.createDirectory(nowyKatalog2);
            } 
        
        Files.copy(fs.getPath("radek.txt"), nowyKatalog2);// UWAGA: coś tu nie działa
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
        // wypisanie zawartości pliku zip
        FileSystem fsa = FileSystems.newFileSystem(Paths.get("moj.zip"), null);
        
        Files.walkFileTree(fsa.getPath("/"), new SimpleFileVisitor<Path>()
        {
            public FileVisitResult visitFile(Path file, BasicFileAttributes atts)
            {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });
        
    }
}