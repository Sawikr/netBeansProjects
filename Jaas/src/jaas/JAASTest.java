package jaas;

import java.awt.*;
import javax.swing.*;

/**
 * Program uwierzytelnia u¿ytkownika
 * za pomoc¹ w³asnego modu³u logowania,
 * a nastêpnie wykonuje SysPropAction, korzystaj¹c
 * z pozwoleñ u¿ytkownika.
 * @version 1.01 2013-06-10
 * @author Rados³aw Sawicki
 */
public class JAASTest
{
   public static void main(final String[] args)
   {
      System.setSecurityManager(new SecurityManager());
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new JAASFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setTitle("JAASTest");
               frame.setVisible(true);
            }
         });
   }
}