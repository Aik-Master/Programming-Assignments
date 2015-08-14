/** 
* <b>Header</b>
* Praktikum    P1P
* Semester     WS12/13
* Team         S4T4
* Aufgabe      A8
* Kontrolleur  Michael Schafers
* Datum        13.12.12
* Quellen       /
* @author      Klostermann, Aiko; 2125565
*/

package aufgabenblatt_4;

import static aufgabenblatt_4.FuhrparkEnums.BusTyp.*;
import static aufgabenblatt_4.FuhrparkEnums.Farbe.*;
import static aufgabenblatt_4.FuhrparkEnums.Kraftstoffart.*;
import static aufgabenblatt_4.FuhrparkEnums.VeloTyp.*;


public class Fuhrpark_main{

    public static void main(String[] args){

        Fuhrpark fuhrpark = new Fuhrpark();
        
        fuhrpark.add(new Lkw("John McCarthy", ROT, false, false, BENZIN, 15));
        fuhrpark.add(new Velo("Jan Ulrich", BLAU, false, false, FAHRRAD));
        fuhrpark.add(new Velo("Alan Turing", WEISS, false, false, DREIRAD));
        fuhrpark.add(new Velo("H.P. BAXXTER", GELB, false, false, ROLLER));
        fuhrpark.add(new Lkw("John von Neumann", WEISS, false, false, BENZIN, 15));
        fuhrpark.add(new Bus("John Cocke", BLAU, false, false, ELEKTRO, DOPPELDECKER, 50));
        fuhrpark.add(new Pkw("Peter Griffin", SCHWARZ, false, false, BENZIN, 250, 2));
        fuhrpark.add(new Bus("Klaus Wunderlich", GELB, false, false, BENZIN, GELENK, 52));
        fuhrpark.add(new Lkw("Helge Schneider", ROT, false, false, BENZIN, 15));
        fuhrpark.add(new Pkw("Peter Jackson", WEISS, false, false, GAS, 180, 5));
        fuhrpark.add(new Mopped("Sam Mendes", GRUN, false, false, BENZIN, 200));
        fuhrpark.add(new Mopped("Charlie Kaufman", SCHWARZ, false, false, GAS, 1200));
        fuhrpark.add(new Lkw("Christopher Nolan", ROT, false, false, BENZIN, 15));
        fuhrpark.add(new Bus("Sasha Grey", BLAU, false, false, GAS, PANORAMA, 52));
        fuhrpark.add(new Velo("Kim Schmitz", GRUN, false, false, DREIRAD));
        fuhrpark.add(new Pkw("Dieter Thomas Heck", GELB, false, false, DIESEL, 200, 3));
        fuhrpark.add(new Mopped("B. A. Baracus", ROT, false, false, BENZIN, 1500));
        fuhrpark.add(new Velo("Magnum P.I.", SCHWARZ, false, false, FAHRRAD));
        fuhrpark.add(new Pkw("David Hasselhof", WEISS, false, false, ELEKTRO, 120, 6));
        fuhrpark.add(new Velo("Aik-Master", WEISS, false, false, ROLLER));
        fuhrpark.add(new Lkw("€num", ROT, false, false, BENZIN, 15));
        fuhrpark.add(new Mopped("Jesus Christus", BLAU, false, false, DIESEL, 150));
        fuhrpark.add(new Bus("Roberto Blanko", SCHWARZ, false, false, ELEKTRO, NORMAL, 70));
        fuhrpark.add(new Mopped("Walter White", WEISS, false, false, DIESEL, 500));
        fuhrpark.add(new Pkw("Alan Kay", SCHWARZ, false, false, GAS, 220, 4));
        fuhrpark.add(new Mopped("Gaspar Noe", GELB, false, false, GAS, 850));
        
        fuhrpark.verfugbar();
        System.out.println("roller");
        fuhrpark.verfugbar("roller");
        System.out.println("velo");
        fuhrpark.verfugbar("Velo"); 
        System.out.println("*");
        fuhrpark.verfugbar("*");
        System.out.println("Pkw  150   5");
        fuhrpark.verfugbar("Pkw", "150", "5");
        System.out.println("busse");
        fuhrpark.verfugbar("bus");
        System.out.println("busse in schwarz");
        fuhrpark.verfugbar("bus", "schwarz");
        fuhrpark.leiheAus("Jan Ulrich");
        fuhrpark.leiheAus("H.P. BAXXTER");        
        fuhrpark.verfugbar("bus", "gelenk");
        System.out.println(fuhrpark.berechneTagesEinnahmen());
        fuhrpark.verfugbar("lKw", "weiss");
    }//main
}//Fuhrpark_main
