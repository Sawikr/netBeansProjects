package permissions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Demonstruje wykorzystanie
 * własnej klasy pozwoleń WordCheckPermission.
 * @version 1.03 2007-10-06
 * @author Cay Horstmann
 */
public class PermissionTest
{
   public static void main(String[] args)
   {
      System.setProperty("java.security.policy", "./PermissionTest.policy"); // musi być ./ i PermissionTest.policy musi być w Files netBeans i w pakiecie permissions     
      System.setSecurityManager(new SecurityManager());                      // muszą też być klasy, z których powstał plik java (np. PermissionTest.class)
      EventQueue.invokeLater(new Runnable()                                  // w pliku PermissionTest.policy może być WordCheckPermission a nie musi permissions.WordCheckPermission
         {
            public void run()
            {
               JFrame frame = new PermissionTestFrame();
               frame.setTitle("PermissionTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * Ramka zawierająca pole tekstowe umożliwiające
 * dodawanie tekstu do obszaru tekstowego pod warunkiem, że
 * nie zawiera on zabronionych słów.
 */
class PermissionTestFrame extends JFrame
{
   private JTextField textField;
   private WordCheckTextArea textArea;
   private static final int TEXT_ROWS = 20;
   private static final int TEXT_COLUMNS = 60;

   public PermissionTestFrame()
   {
      textField = new JTextField(20);
      JPanel panel = new JPanel();
      panel.add(textField);
      
      JButton openButton = new JButton("Insert");
      panel.add(openButton);
      openButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               insertWords(textField.getText());
            }
         });

      add(panel, BorderLayout.NORTH);

      textArea = new WordCheckTextArea();
      textArea.setRows(TEXT_ROWS);
      textArea.setColumns(TEXT_COLUMNS);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      pack();
   }

   /**
    * Próbuje dodać słowa do obszaru tekstowego.
    * Wyświetla okno dialogowe, jeśli próba nie powiedzie się.
    * @param words wstawiane słowa
    */
   public void insertWords(String words)
   {
      try
      {
         textArea.append(words + "\n");
      }
      catch (SecurityException ex)
      {
         JOptionPane.showMessageDialog(this, "I am sorry, but I cannot do that.");
         ex.printStackTrace();
      }
   }
}

/**
 * Klasa obszaru tekstowego, której metoda append
 * sprawdza, czy dodawany tekst nie zawiera zabronionych słów.
 */
class WordCheckTextArea extends JTextArea
{
   public void append(String text)
   {
      WordCheckPermission p = new WordCheckPermission(text, "insert");
      SecurityManager manager = System.getSecurityManager();
      if (manager != null) manager.checkPermission(p);
      super.append(text);
   }
}