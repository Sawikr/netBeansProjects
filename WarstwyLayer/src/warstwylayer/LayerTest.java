package warstwylayer;

import java.awt.*;
import javax.swing.*;

/**
 * Program demonstrujący dekorowanie komponentu Swing za pomocą warstwy. 
 * @version 1.0 2014-06-08
 * @author Radosław Sawicki
 */
public class LayerTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new ColorFrame();
               frame.setTitle("LayerTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}