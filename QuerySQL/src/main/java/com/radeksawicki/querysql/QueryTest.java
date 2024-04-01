package com.radeksawicki.querysql;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

/**
 * Program wykonujący kilka złożonych operacji na bazie danych.
 * Program wykorzystujący polcenia przygotowane z parametrem '?'.
 * @version 1.30 2012-06-05
 * @author Radosław Sawicki
 */
public class QueryTest
{
   private static final String allQuery = "SELECT Books.Price, Books.Title FROM Books";

   private static final String authorPublisherQuery = "SELECT Books.Price, Books.Title"
         + " FROM Books, BooksAuthors, Authors, Publishers"
         + " WHERE Authors.Author_Id = BooksAuthors.Author_Id AND BooksAuthors.ISBN = Books.ISBN"
         + " AND Books.Publisher_Id = Publishers.Publisher_Id AND Authors.Name = ?"
         + " AND Publishers.Name = ?";

   private static final String authorQuery = "SELECT Books.Price, Books.Title FROM Books, BooksAuthors, Authors"
         + " WHERE Authors.Author_Id = BooksAuthors.Author_Id AND BooksAuthors.ISBN = Books.ISBN"
         + " AND Authors.Name = ?";

   private static final String publisherQuery = "SELECT Books.Price, Books.Title FROM Books, Publishers"
         + " WHERE Books.Publisher_Id = Publishers.Publisher_Id AND Publishers.Name = ?";


   private static final String priceUpdate = "UPDATE Books " + "SET Price = Price + ? "
         + " WHERE Books.Publisher_Id = (SELECT Publisher_Id FROM Publishers WHERE Name = ?)";

   private static Scanner in;
   private static Connection conn;
   private static final ArrayList<String> authors = new ArrayList<>();
   private static final ArrayList<String> publishers = new ArrayList<>();
   
   public static void main(String[] args) throws IOException
   {
      try
      {
         conn = getConnection();
         in = new Scanner(System.in);
         authors.add("Any");
         publishers.add("Any");
         try (Statement stat = conn.createStatement())
         {
            // Wypełnia listę autorów
            String query = "SELECT Name FROM Authors";
            try (ResultSet rs = stat.executeQuery(query))
            {
               while (rs.next())
                  authors.add(rs.getString(1));
            }
   
            // Wypełnia listę wydawców
            query = "SELECT Name FROM Publishers";
            try (ResultSet rs = stat.executeQuery(query))
            {
               while (rs.next())
                  publishers.add(rs.getString(1));
            }
         }
         boolean done = false;
         while (!done)
         {
            System.out.print("Q)uery C)hange prices E)xit: ");// fajne manu
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
               executeQuery();
            else if (input.equals("C"))
               changePrices();
            else 
               done = true;// wyjście z pętli while, tym samym koniec programu
         }
      }
      catch (SQLException e)
      {
         for (Throwable t : e)
            System.out.println(t.getMessage());
      }
   }

   /**
    * Wykonuje wybrane zapytanie.
    */
   private static void executeQuery() throws SQLException
   {
      String author = select("Authors:", authors);
      String publisher = select("Publishers:", publishers);
      PreparedStatement stat;
      if (!author.equals("Any") && !publisher.equals("Any"))
      {
         stat = conn.prepareStatement(authorPublisherQuery);
         stat.setString(1, author);// ustawia zmienną 1 - pierwsze wystąpienie '?' w zapytaniu SQL
         stat.setString(2, publisher);// ustawia zmienną 2 - drugie wystąpienie '?' w zapytaniu SQL
      }
      else if (!author.equals("Any") && publisher.equals("Any"))
      {
          stat = conn.prepareStatement(authorQuery);
          stat.setString(1, author);
      }
      else if (author.equals("Any") && !publisher.equals("Any"))
      {
          stat = conn.prepareStatement(publisherQuery);
          stat.setString(1, publisher);
      }
      else
         stat = conn.prepareStatement(allQuery);
      
      try (ResultSet rs = stat.executeQuery())
      {
         while (rs.next())
            System.out.println(rs.getString(1) + ", " + rs.getString(2));// wypisuje zmienną 1 i 2
      }
   }

   /**
    * Wykonuje polecenie aktualizacji cen.
    */
   public static void changePrices() throws SQLException
   {
      String publisher = select("Publishers:", publishers.subList(1, publishers.size()));
      System.out.print("Change prices by (double): ");
      double priceChange = in.nextDouble();
      PreparedStatement stat = conn.prepareStatement(priceUpdate);
      stat.setDouble(1, priceChange);
      stat.setString(2, publisher);
      int r = stat.executeUpdate();
      System.out.println(r + " records updated.");
   }
   
   /**
    * Prosi użytkownika o wprowadzenie łańcucha
    * @param prompt łańcuch zajęty
    * @param options opcje, z których może wybierać użytkownik
    * @return wybrana opcja
    */
   public static String select(String prompt, List<String> options)
   {
      while (true)
      {
         System.out.println(prompt);     
         for (int i = 0; i < options.size(); i++)
            System.out.printf("%2d) %s%n", i + 1, options.get(i));
         
         System.out.println("\nWybierz opcje (1 lub 2): ");
         int sel = in.nextInt();
         
         if (sel > 0 && sel <= options.size())
            return options.get(sel - 1);
      }      
   }

   /**
    * Nawiązuje połąńczenie z bazą danych,
    * korzystając z własciwości
    * zapisanych w pliku database.properties
    * @return połączenie z bazą danych
    */
   public static Connection getConnection() throws SQLException, IOException
   {
      Properties props = new Properties();
      try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
      {
         props.load(in);
      }

      String drivers = props.getProperty("jdbc.drivers");
      if (drivers != null) System.setProperty("jdbc.drivers", drivers);
      String url = props.getProperty("jdbc.url");
//      String username = props.getProperty("jdbc.username");
//      String password = props.getProperty("jdbc.password");

      return DriverManager.getConnection(url);
   }
}