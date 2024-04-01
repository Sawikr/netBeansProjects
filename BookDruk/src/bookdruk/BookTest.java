package bookdruk;

import java.awt.*;
import javax.swing.*;

/**
 * Program demonstruj�cy tworzenie wielostronicowego wydruku.
 * Drukuje tekst transparentu, powi�kszaj�c go, tak by wype�nia�
 * wysoko�� ca�ej strony. Program implementuje tak�e og�ln� klas�
 * okna dialogowego podgl�du wydruku.
 * @version 1.12 2007-08-16
 * @author Radosław Sawicki
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