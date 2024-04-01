package test;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * Program sprawdzaj�cy poprawno�� konfiguracji
 * bazy danych i sterownika JDBC.
 * @version 1.02 2013-06-05
 * @author Radosław Sawicki
 */
public class TestDB
{
//   static{
//       try {
//           Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//       } catch (ClassNotFoundException ex) {
//           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
//       } catch (InstantiationException ex) {
//           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
//       } catch (IllegalAccessException ex) {
//           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
//       }
//      }
    
   public static void main(String args[]) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
   {
       
      try
      {
         runTest();
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

         //stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
         String sql = "INSERT INTO books (title, author, price) VALUES"
                    + "('Dyrektor II. Wydanie pierwsze', 'A. Sawicka', 165)";
         
         stat.executeUpdate(sql);

         try (ResultSet result = stat.executeQuery("SELECT * FROM books"))
         {
            if (result.next())
               System.out.println(result.getString(1));
         }
         //stat.executeUpdate("DROP TABLE Greetings");
      }
   }

   /**
    * Nawi�zuje po��czenie, korzystaj�c
    * z w�a�ciwo�ci w pliku database.properties
    * @return po��czenie do bazy danych
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
      //String protocol = props.getProperty("jdbc.protocol");
      String url = props.getProperty("jdbc.url");
      //String username = props.getProperty("jdbc.username");
      //String password = props.getProperty("jdbc.password");

      return DriverManager.getConnection(url);
   }
}