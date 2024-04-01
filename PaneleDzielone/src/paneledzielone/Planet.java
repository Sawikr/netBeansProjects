package paneledzielone;

import javax.swing.*;

/**
 * Klasa reprezentująca planety.
 */
public class Planet
{
   private String name;
   private double radius;
   private int moons;
   private ImageIcon image;

   /**
    * Tworzy obiekt reprezentujący planety.
    * @param n nazwa planety
    * @param r promień planety
    * @param m liczba księżyców
    */
   public Planet(String n, double r, int m)
   {
      name = n;
      radius = r;
      moons = m;
      image = new ImageIcon(getClass().getResource(name + ".gif"));
   }

   public String toString()
   {
      return name;
   }

   /**
    * Pobiera opis planety.
    * @return opis
    */
   public String getDescription()
   {
      return "Radius: " + radius + "\nMoons: " + moons + "\n";
   }

   /**
    * Pobiera obrazek planety.
    * @return obrazek
    */
   public ImageIcon getImage()
   {
      return image;
   }
}