/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filepickerbean;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 * Ziarno FilePickerBean
 * @author Radosław Sawicki
 */
public class FilePickerBean extends JPanel{

   private static final int XPREFSIZE = 250;
   private static final int YPREFSIZE = 20;

   private JButton dialogButton;
   private JTextField nameField;
   private JFileChooser chooser;
   private String[] extensions = { "gif", "png", "xml" };

   public FilePickerBean()
   {
      dialogButton = new JButton("...");
      nameField = new JTextField(40);

      chooser = new JFileChooser();
      setPreferredSize(new Dimension(XPREFSIZE, YPREFSIZE));

      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.weightx = 100;
      gbc.weighty = 100;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      add(nameField, gbc);

      dialogButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               chooser.setFileFilter(new FileNameExtensionFilter(Arrays.toString(extensions),
                     extensions));
               int r = chooser.showOpenDialog(null);
               if (r == JFileChooser.APPROVE_OPTION)
               {
                  File f = chooser.getSelectedFile();
                  String name = f.getAbsolutePath();
                  setFileName(name);
               }
            }
         });
      nameField.setEditable(false);

      gbc.weightx = 0;
      gbc.anchor = GridBagConstraints.EAST;
      gbc.fill = GridBagConstraints.NONE;
      gbc.gridx = 1;
      add(dialogButton, gbc);
   }

   /**
    * Metoda set właściwości fileName.
    * @param newValue nowa nazwa pliku
    */
   public void setFileName(String newValue)
   {
      String oldValue = nameField.getText();
      nameField.setText(newValue);
      firePropertyChange("fileName", oldValue, newValue);
   }

   /**
    * Metoda get właściwości fileName.
    * @return nazwa wybranego pliku
    */
   public String getFileName()
   {
      return nameField.getText();
   }

   /**
    * Metoda get właściwości extensions.
    * @return domyślne rozszerzenia nazwy pliku
    */
   public String[] getExtensions()
   {
      return extensions;
   }

   /**
    * Metoda set właściwości extensions.
    * @param newvalue nowe domyślne rozszerzenia nazwy pliku
    */
   public void setExtensions(String[] newValue)
   {
      extensions = newValue;
   }

   /**
    * Zwraca jedną z wartości właściwości extensions.
    * @param i indeks wartości właściwości
    * @return wartość o podanym indeksie
    */
   public String getExtensions(int i)
   {
      if (0 <= i && i < extensions.length) return extensions[i];
      else return "";
   }

   /**
    * Nadaje wartość właściwości extensions.
    * @param indeks wartości właściwości
    * @param newValue nowa wartość o podanym indeksie
    */
   public void setExtensions(int i, String newValue)
   {
      if (0 <= i && i < extensions.length) extensions[i] = newValue;
   } 
}