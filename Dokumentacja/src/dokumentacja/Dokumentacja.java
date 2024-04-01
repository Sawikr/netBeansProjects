/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokumentacja;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * Klasa do testowania javadoc.
 * Klasa <code>Dokumentacja</code>
 * @author Radosław Sawicki
 * @version 1.0
 * @serial 1.0.1.0
 */
public final class Dokumentacja extends JFrame {

    public Dokumentacja(){
        
        super("Zdarzenia");
        this.setBounds(300, 300, 300, 300);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                
        initComponents();        
            
    }
    JPanel panel = new JPanel();
    JButton usun = new JButton();
    JButton niebieskiButton = new JButton();
    JButton czerwonyButton = new JButton();
    
    /**
     * Metoda wywołuja okno, nie robi nic bo konstruktor Dokuemntacja wywyołuje okno.
     * Metoda tworzy przyciski
     */
    public void initComponents(){
        
        usun = new JButton("Usuń");
        panel.add(usun);
        
        usun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                if(czerwonyButton.isShowing()){
                panel.remove(czerwonyButton);
                repaint();
                }
                else if(niebieskiButton.isShowing()){
                panel.remove(niebieskiButton);
                repaint();
                }
            }   
        });
       
        budujPrzycisk("Czarny", Color.BLACK);
        budujPrzycisk("Zielony", Color.GREEN);
        
        Action niebieski = new TworzenieAkcji("Niebieski", Color.BLUE, KeyEvent.VK_N);
        Action czerwony = new TworzenieAkcji("Czerwony", Color.RED, KeyEvent.VK_C);
        
        niebieskiButton = new JButton(niebieski);
        czerwonyButton = new JButton(czerwony);
        
        //czerwonyButton.setMnemonic('C'); ustwaia mnemonic dla buttona
        
        panel.add(niebieskiButton);
        panel.add(czerwonyButton);
        
        // ustawienie klawisza na akcję "ctrl+"
        InputMap imap = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl N"), "niebieski");
        imap.put(KeyStroke.getKeyStroke("ctrl C"), "czerwony");
        
        ActionMap amap = panel.getActionMap();
        amap.put("niebieski", niebieski);
        amap.put("czerwony", czerwony);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // wywołanie konstruktora tworzącego JFrame
        new dokumentacja.Dokumentacja().setVisible(true);
        
        Dokumentacja c = new Dokumentacja();
        c.mojaMetoda(2, 2);
        System.out.println(c);
        
        // przykład wykorzystania asercji
        int a = 0;
        
        assert a > 0: "Parametr a ma być większy od zera!";
        if(a == 0)
            System.out.println("Równe 0");
        else if(a == 1)
            System.out.println("Możemy pracować!");
        
        
    }
    
    /**
     * Metoda tworzy przycisk, dodaje do panelu i ustawia słuchacza z klasą anonimową
     * zmienijącą tło panelu
     * @param nazwa
     * @param kolor 
     */
    public void budujPrzycisk(String nazwa, Color kolor){
        
        JButton przycisk = new JButton(nazwa);
        
        panel.add(przycisk);
        
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(kolor);
            }
        }); 
        // to samo jako lambda
        przycisk.addActionListener((ActionEvent e) -> {
            panel.setBackground(kolor);
            System.out.println("Działa lambda!");
        });
        
    }
    
    /**
     * Klasa tworząca obiekt Action z klasy AbstractAction
     * 
     */
     
    public class TworzenieAkcji extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            Color kolor = (Color)getValue("Color");
            panel.setBackground(kolor);
            
        }

        @SuppressWarnings("OverridableMethodCallInConstructor")
        public TworzenieAkcji(String nazwa, Color kolor, Integer mnemonic) {
            putValue(Action.NAME, nazwa);
            putValue(Action.SHORT_DESCRIPTION, "Naciśnij Ctrl + " + nazwa.substring(0, 1));
            putValue("Color", kolor);
            putValue(Action.MNEMONIC_KEY, mnemonic);
            //putValue(Action.SELECTED_KEY, true);
            //putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("A"));
        }
              
    }    
           
    @Override
    public String toString() {
        return "Dokumentacja{" + "a = " + a + ", b = " + b + '}';
    }
    private int a;
    private int b;
    
    /**
    * Metoda <code>mojaMetoda</code> 26/09/2020<strong> Radek Sawicki</strong>
    * @param a parametr
    * @param b parametr
    * @version 5.0
    * {@link dokumentacja.Dokumentacja#mojaMetoda(int, int)}
    * @since 1.0.0.0 
    * @see <a href="http://www.onet.pl" >www.onet.pl</a>
    * @see "Zobacz: Radek to mistrz!"
    * @see dokumentacja.Dokumentacja#mojaMetoda(int, int)
    * @serialData 26-09-2020
    */          
    public void mojaMetoda(int a, int b){
        
        this.a = a;
        this.b = b;
    }
    
    /**
     * Klasa <code>Przycisk</code> tworząca słuchacza do zmiany tła panelu
     * @see <a href= "http://onet.pl" >www.onet.pl</a>
     */
//    private class kliknijPrzycisk implements ActionListener {
//
//        private Color kolor;
//
//        public kliknijPrzycisk(Color kolor) {
//            this.kolor = kolor;
//        }
//        
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            
//            czerwony.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    panel.setBackground(Color.RED);
//                }
//            });        
//        }          
//    }    
}
