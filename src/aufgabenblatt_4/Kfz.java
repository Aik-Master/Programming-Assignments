/** 
 * <b>Header</b>
 * Praktikum    P1P
 * Semester     WS12/13
 * Team         S4T4
 * Aufgabe      A8
 * Kontrolleur  Michael Schafers
 * Datum        13.12.12
 * Quellen        /
 * @author      Klostermann, Aiko; 2125565
 */

package aufgabenblatt_4;

import aufgabenblatt_4.FuhrparkEnums.Farbe;
import aufgabenblatt_4.FuhrparkEnums.Kraftstoffart;

public class Kfz extends Vehikel{

    private Kraftstoffart kraftstoff;

    public Kfz(String name, Farbe farbe, boolean defekt, boolean verliehen, Kraftstoffart kraftstoff){
        super(name, farbe, defekt, verliehen);
        this.kraftstoff = kraftstoff;
    }// Kfz()

    public String getKraftstoff(){
        return(kraftstoff.toString());
    }// getKraftstoff

    @Override
    public String toString(){
        return String.format("<|Kfz|> kraftstoff:%s  super: %s ", kraftstoff, super.toString());
    }// // toString
}// Kfz