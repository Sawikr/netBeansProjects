package loaderszyfr;

import java.awt.*;

/**
   Zadaniem tej klasy jest ułatwienie korzystania z klasy GridBagConstraints.
   * 
   *Pole - Przeznaczenie:
    * 
    int anchor - Określa położenie komponentu wewnątrz komórki. Domyślną wartością tego pola
    jest stała GridBagConstraints.CENTER
    *
    int fill - Określa sposób ewentualnego modyfikowania wymiarów komponentu w sytuacji, gdy
    komponent ten jest mniejszy od swojej komórki. Do prawidłowych wartości tego pola należą
    stałe: GridBagConstraints.NONE (wartość domyślna), GridBagConstraints.HORIZONTAL,
    GridBagConstraints.VERTICAL oraz GridBagConstraints.BOTH
    * 
    int gridheight - Określa względną wysokość komponentu w ramach komórek. Wartością domyślną jest 1
    * 
    int gridwidth - Określa względną szerokość komponentu w ramach komórek. Wartością domyślną jest 1
    * 
    int gridx - Określa współrzędną poziomą komórki, do której zostanie dodany dany komponent.
    Wartością domyślną tego pola jest stała GridBagConstraints.RELATIVE
    * 
    int gridy - Określa współrzędną pionową komórki, do której zostanie dodany dany komponent.
    Wartością domyślną tego pola jest stała GridBagConstraints.RELATIVE
    * 
    Insets insets - Określa obramowania. Domyślnie wszystkie obramowania mają zerową szerokość
    i wysokość
    * 
    int ipadx - Określa dodatkową przestrzeń otaczającą komponent z góry i z dołu w ramach komórki.
    Wartością domyślną jest 0
    * 
    int ipady - Określa dodatkową przestrzeń otaczającą komponent z lewej i z prawej strony w ramach
    komórki. Wartością domyślną jest 0
    * 
    double weightx - Określa wartość wagi, która bezpośrednio wpływa na poziome odstępy pomiędzy
    komórkami a krawędziami kontenera, w którym te komórki są przechowywane.
    Wartością domyślną jest 0,0. Im większa jest zdefiniowana w tym polu waga, tym więcej
    przestrzeni jest przydzielane. Jeśli wszystkie wagi mają wartość 0,0, dodatkowa przestrzeń
    jest rozdzielana równomiernie pomiędzy krawędzie okna
    double weighty Określa wartość wagi, która bezpośrednio wpływa na pionowe odstępy pomiędzy
    komórkami a krawędziami kontenera, w którym te komórki są przechowywane.
    Wartością domyślną jest 0,0. Im większa jest zdefiniowana w tym polu waga, tym więcej
    przestrzeni jest przydzielane. Jeśli wszystkie wagi mają wartość 0,0, dodatkowa przestrzeń
    jest rozdzielana równomiernie pomiędzy krawędzie okna
*/

public class GBC extends GridBagConstraints 
{
   /**
      Tworzy obiekt GBC dla podanych parametr�w gridx i gridy.
      Pozosta�e ograniczenia otrzymuj� warto�ci domy�lne.
      @param gridx pozycja gridx
      @param gridy pozycja gridy
   */
   public GBC(int gridx, int gridy)
   {
      this.gridx = gridx;
      this.gridy = gridy;
   }

   /**
      Tworzy obiekt GBC dla podanych parametr�w gridx, gridy, gridwidth, gridheight.
      Pozosta�e ograniczenia otrzymuj� warto�ci domy�lne.
      @param gridx pozycja gridx
      @param gridy pozycja gridy
      @param gridwidth kom�rki w kierunku x
      @param gridheight kom�rki w kierunku y
   */
   public GBC(int gridx, int gridy, int gridwidth, int gridheight)
   {
      this.gridx = gridx;
      this.gridy = gridy;
      this.gridwidth = gridwidth; 
      this.gridheight = gridheight; 
   }

   /**
      Konfiguruje parametr anchor.
      @param anchor wartość parametru anchor - kotwica
      @param anchor do określenia lewego górnego roku, w sytuacji, kiedy element jest mniejszy niż komponent, w którym się znajduje
      @return obiekt GBC do dalszej modyfikacji
   */
   public GBC setAnchor(int anchor) 
   { 
      this.anchor = anchor; 
      return this;
   }
   
   /**
      Konfiguruje parametr fill.
      @param fill wartość parametru fill
      @return obiekt GBC do dalszej modyfikacji
   */
   public GBC setFill(int fill) 
   { 
      this.fill = fill; 
      return this;
   }

   /**
      Konfiguruje parametry weightx i weighty.
      @param weightx warto�� parametru weightx
      @param weighty warto�� parametru weighty
      @return obiekt GBC do dalszej modyfikacji
   */
   public GBC setWeight(double weightx, double weighty) 
   { 
      this.weightx = weightx; 
      this.weighty = weighty; 
      return this;
   }

   /**
      Konfiguruje odst�py pomi�dzy kom�rkami.
      @param distance odst�p we wszystkich kierunkach
      @return obiekt GBC do dalszej modyfikacji
   */
   public GBC setInsets(int distance) 
   { 
      this.insets = new Insets(distance, distance, distance, distance);
      return this;
   }

   /**
      Konfiguruje odst�py pomi�dzy kom�rkami.
      @param top odst�p w g�r�
      @param left odst�p w lewo
      @param bottom odst�p w d�
      @param right odst�p w prawo
      @return obiekt GBC do dalszej modyfikacji
   */
   public GBC setInsets(int top, int left, int bottom, int right) 
   { 
      this.insets = new Insets(top, left, bottom, right);
      return this;
   }

   /**
      Konfiguruje parametry ipadx i ipady.
      @param ipadx warto�� parametru ipadx
      @param ipady warto�� parametru ipady
      @return obiekt GBC do dalszej modyfikacji
   */
   public GBC setIpad(int ipadx, int ipady) 
   { 
      this.ipadx = ipadx; 
      this.ipady = ipady; 
      return this;
   }
}