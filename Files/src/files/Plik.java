/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author Radosław Sawicki
 */
public class Plik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // Nowy plik tworzymy poprzez obiekt File, ale też możemy przez obiekt Files
        File nowy =  new File("./plik.txt");// nie ma potrzeby ./
        if(!(nowy.exists()))
            nowy.createNewFile();
        
        // create object of Path 
        Path pathOfFile = Paths.get("plik.txt");
            
        Path pathOfFileNowyPlik = Paths.get("plik1.txt");
        
        // WAŻNE: prosta metoda tworzenia nowego pliku
        Path nowyPlik = Paths.get("plikNowy.txt");
        
        // jeżeli obiekt Path nie istnieje to..
        if(Files.notExists(nowyPlik)){
            Files.createFile(nowyPlik);// jeżeli nie istnieje, jak istnieje to trzeba to zrobić jako wyjątek błędu
        }   
        //Files.deleteIfExists(nowyPlik);
        
        // tworzenie nowego katalogu
        Path nowyKatalog = Paths.get("Nowy_Katalog");
        if(Files.notExists(nowyKatalog)){
            Files.createDirectory(nowyKatalog);
            }
        
        Path dodajKatalog1 = nowyKatalog.resolve("Nowy");// metoda <code>resolve</code> dodaje nowy katalog
        Files.createDirectories(dodajKatalog1);
        
        Path nowyKatalog2 = Paths.get("Nowy_Katalog/Nowy");
        Path dodajKatalog2 = nowyKatalog2.resolve("NowyRadek");
        Files.createDirectories(dodajKatalog2);
        
        Path nowyPlikKatalog = Paths.get("plikNowyKatalog.txt");
        Path dodajPlikdoKatalogu = dodajKatalog2.resolve(nowyPlikKatalog);
        if(Files.notExists(dodajPlikdoKatalogu)){// musisz sprawdzić, czy ten obiekt Path istnieje
            Files.createFile(dodajPlikdoKatalogu);
            }
        
        Path copyS = Paths.get("Nowy_Katalog/Nowy/NowyRadek/plikNowyKatalog.txt");
        Path copyD = Paths.get("Nowy_Katalog/Nowy/katalog.txt");// na końcu podajemy nazwę pliku, do którego kopiujemy, np. katalog.txt
        
        if(Files.notExists(copyD))
            Files.copy(copyS, copyD, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);// lub bez opcji
        
        //Files.deleteIfExists(copyD);
        
        Path nowyPrzenoszonyPlik = Paths.get("Nowy_Katalog/przenoszonyPlik.txt");
        if(Files.notExists(nowyPrzenoszonyPlik))
            Files.move(copyD, nowyPrzenoszonyPlik, StandardCopyOption.REPLACE_EXISTING);// metoda przenosząca plik
        
        // właściwości pliku
        BasicFileAttributes properties = Files.readAttributes(copyD, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        System.out.println(properties.toString());
        
        // przeszukiwanie katalogów
        System.out.println("----------------------------------");
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(dodajKatalog1))
        {
            for (Path iterator: entries)
                System.out.println(iterator);
        }
        System.out.println("----------------------------------");
        
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(nowyKatalog, "*.txt"))
        {
            for (Path iterator: entries)
                System.out.println(iterator);
        }
        System.out.println("----------------------------------");
        
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(nowyKatalog, "*"))// wyświetla wszystkie pliki w katalogu
        {
            for (Path iterator: entries)
                System.out.println(iterator);
        }
        System.out.println("----------------------------------");
        
        // wyświetlanie wszystkich podkatalogów danego katalogu
        Files.walkFileTree(nowyKatalog, new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes atts) throws IOException
            {
                if(!(atts.isDirectory()))// '!' bo w katalogach znajdują się pliki txt
                   System.out.println(path);
                return FileVisitResult.CONTINUE;
            }
            
            @Override
            public FileVisitResult visitFileFailed(Path path, IOException es) throws IOException
            {
                return FileVisitResult.CONTINUE;
            }   
        });
        System.out.println("----------------------------------");
       
        Path p = Paths.get("/Files/files/plik.txt", args);
        Path parents = p.getParent();
        Path file = p.getFileName();
        Path root = p.getRoot();
        
        Path absolute = Paths.get("/files", "plik.txt");
        Path relative = Paths.get("/files", "plik.txt");
        Path abosul = p.toAbsolutePath();
        
        int porownaj = pathOfFile.compareTo(pathOfFileNowyPlik);
       
        System.out.println(parents);
        System.out.println(file);
        System.out.println(absolute);
        System.out.println(relative);
        System.out.println(abosul);
        System.out.println(root);
        System.out.println(p);
        
        if(porownaj < 0)
            System.out.println("Ścieżka " + pathOfFile + " jest leksykograficznie mniejsza niż " + pathOfFileNowyPlik);
        
        byte[] nowyPlikByte = Files.readAllBytes(pathOfFile);// zapisanie danych pliku w bajtach
        
        /**
         * Linia wczytująca zawartość pliku w bajtach na obiekt String
         * @param charset - defaultCharset - wczytuje typowy dla obiektu typ danych 
         */
        String zawartoscPliku = new String(nowyPlikByte, Charset.defaultCharset());
        System.out.println(zawartoscPliku);
       
        // delete both Files 
        try { 
            
            System.out.println(Files.isWritable(pathOfFile));
            
            Files.write(pathOfFileNowyPlik, zawartoscPliku.getBytes());// zapisanie danych w nowym pliku, może być bez arg...
            
            Files.write(pathOfFileNowyPlik, zawartoscPliku.getBytes(), StandardOpenOption.CREATE);// tworzy nowy plik, jeżeli nie istnieje
            
            Files.write(pathOfFileNowyPlik, zawartoscPliku.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.SPARSE);// dodaje teks na koniec pliku
            
            //Files.deleteIfExists(pathOfFile);
            
        } 
        catch (IOException e) {   
            e.getStackTrace();
        } 
    }     
}
