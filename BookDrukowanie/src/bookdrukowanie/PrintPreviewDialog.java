package book;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.print.*;
import javax.swing.*;

/**
 * Klasa implementuj¹ca uniwersalne okno dialogowe podgl¹du wydruku.
 */
class PrintPreviewDialog extends JDialog
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 300;

   private PrintPreviewCanvas canvas;

   /**
    * Tworzy okno dialogowe podgl¹du wydruku.
    * @param p obiekt typu Printable
    * @param pf format strony	
    * @param pages liczba stron obiektu p
    */
   public PrintPreviewDialog(Printable p, PageFormat pf, int pages)
   {
      Book book = new Book();
      book.append(p, pf, pages);
      layoutUI(book);
   }

   /**
    * Tworzy okno podgl¹du wydruku.
    * @param b obiekt klasy Book
    */
   public PrintPreviewDialog(Book b)
   {
      layoutUI(b);
   }

   /**
    * Rozmieszcza komponenty okna dialogowego.
    * @param book obiekt klasy Book, którego podgl¹d bêdzie prezentowany
    */
   public void layoutUI(Book book)
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      canvas = new PrintPreviewCanvas(book);
      add(canvas, BorderLayout.CENTER);

      JPanel buttonPanel = new JPanel();

      JButton nextButton = new JButton("Next");
      buttonPanel.add(nextButton);
      nextButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               canvas.flipPage(1);
            }
         });

      JButton previousButton = new JButton("Previous");
      buttonPanel.add(previousButton);
      previousButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               canvas.flipPage(-1);
            }
         });

      JButton closeButton = new JButton("Close");
      buttonPanel.add(closeButton);
      closeButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setVisible(false);
            }
         });

      add(buttonPanel, BorderLayout.SOUTH);
   }
}
