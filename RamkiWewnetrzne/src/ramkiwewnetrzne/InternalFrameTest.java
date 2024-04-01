package ramkiwewnetrzne;

import java.awt.*;
import javax.swing.*;

/**
 * Program demonstrujący użycie ramek wewnętrznych.
 * @version 1.11 2012-08-01
 * @author Radosław Sawicki
 */
public class InternalFrameTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new DesktopFrame();
               frame.setTitle("InternalFrameTest");               
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}