package book;

import java.awt.*;
import javax.swing.*;

/**
 * Program demonstruj¹cy tworzenie wielostronicowego wydruku.
 * Drukuje tekst transparentu, powiêkszaj¹c go, tak by wype³nia³
 * wysokoœæ ca³ej strony. Program implementuje tak¿e ogóln¹ klasê
 * okna dialogowego podgl¹du wydruku.
 * @version 1.12 2010-08-16
 * @author Rados³aw Sawicki
 */
public class BookTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new BookTestFrame();
               frame.setTitle("BookTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}