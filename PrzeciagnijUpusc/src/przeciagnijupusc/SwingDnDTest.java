package przeciagnijupusc;

import java.awt.*;
import javax.swing.*;

/**
 * Program demonstrujący podstawową obsługę mechanizmu "przeciągnij i upuść"
 * przez komponenty Swing.
 * @version 1.10 2014-09-20
 * @author Radosław Sawicki
 */
public class SwingDnDTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new SwingDnDFrame();
               frame.setTitle("SwingDnDTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}