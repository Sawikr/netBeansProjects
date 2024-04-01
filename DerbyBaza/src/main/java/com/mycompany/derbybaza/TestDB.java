package com.mycompany.derbybaza;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * Program sprawdzający poprawność konfiguracji
 * bazy danych i sterownika JDBC.
 * @version 1.02 2013-06-05
 * @author Radosław Sawicki
 */
public class TestDB
{   
   public static void main(String args[]) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
   {
       
      try
      {
         runTest();
         runTestNowaTabela();
      }
      catch (SQLException ex)
      {
         for (Throwable t : ex)
            t.printStackTrace();
      }
   }

   /**
    * Wykonuje test polegający na utworzeniu tabeli, wstawieniu do niej wartości,
    * prezentacji zawartości, usunięciu tabeli.
    */
   public static void runTest() throws SQLException, IOException, ClassNotFoundException
   {
       
      try (Connection conn = getConnection())
      {
         Statement stat = conn.createStatement();
         
         String sql = "INSERT INTO books (title, author, price) VALUES"
                    + "('Java Method III', 'R. Sawicki', 165)";// wpis musi być nowy, jak istnieje to wyjątek
         
         stat.executeUpdate(sql);
         
         Statement statD = conn.createStatement();
         
         String sqlD = "DELETE FROM books WHERE title = 'Java Method III'";
         
         statD.executeUpdate(sqlD);
         System.err.println("Usunięto dodaną pozycję\n");

         try (ResultSet result = stat.executeQuery("SELECT * FROM books"))
         {
            while (result.next()){
               String title = result.getString("title");
               String author = result.getString("author");
               int price = result.getInt("price");
            
            System.err.printf("%s, %s, %s.00\n", title, author, price);
            }
         }
         conn.close();
      }
   }
   
   public static void runTestNowaTabela() throws SQLException, IOException, ClassNotFoundException
   {
       
      try (Connection conn = getConnection())
      {
         Statement stat1 = conn.createStatement();

         stat1.executeUpdate("CREATE TABLE tabela (Wiadomość CHAR(200))");
         stat1.executeUpdate("INSERT INTO tabela VALUES 'Dane wpisane: Radek jest Mistrzem!'");

         try (ResultSet result = stat1.executeQuery("SELECT * FROM tabela"))
         {
            while (result.next()){
                System.err.println("\nPoniżej tekst wpisany do usuniętej tabeli:");
                System.err.println(result.getString(1));
            }
            stat1.executeUpdate("DROP TABLE tabela");
            System.err.println("\nTabela została usunięta");
         }
         conn.close();
      }
    }
   
   /**
    * Nawiązuje połączenie, korzystając z własciwości w pliku database.properties
    * @return połączenie do bazy danych
    */
   public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException
   {
       
      Properties props = new Properties();
      try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
      {
         props.load(in);
      }
      
      String drivers = props.getProperty("jdbc.drivers");
      if (drivers != null) System.setProperty("jdbc.drivers", drivers);
      String url = props.getProperty("jdbc.url");
      //String username = props.getProperty("jdbc.username");
      //String password = props.getProperty("jdbc.password");

      return DriverManager.getConnection(url);
   }
}