/** 
 * <b>Header</b>
 * Praktikum     P1P
 * Semester      WS12/13
 * Team          S4T4
 * Aufgabe       A8
 * Kontrolleur   Michael Schafers
 * Datum         13.12.12
 * Quellen        /
 * @author       Klostermann, Aiko; 2125565
 */

package aufgabenblatt_4;

import aufgabenblatt_4.FuhrparkEnums.Farbe;
import aufgabenblatt_4.FuhrparkEnums.Kraftstoffart;

public class Lkw extends Kfz{

    private int maxZuladung;

    public Lkw(String name, Farbe farbe, boolean defekt, boolean verliehen, Kraftstoffart kraftstoff, int maxZuladung){
        super(name, farbe, defekt, verliehen, kraftstoff);
        this.maxZuladung = maxZuladung;

        if(maxZuladung < 10){
            setKosten(8000);
        } else if(maxZuladung < 20){
            setKosten(9000);
        } else if(maxZuladung < 30){
            setKosten(10000);
        } else if(maxZuladung < 40){
            setKosten(12500);
        } else{
            setKosten(20000);
        }// if else
    }// Lkw()

    public int getZuladung(){
        return(maxZuladung);
    }// getZuladung

    @Override
    public String toString(){
        return String.format("<|Lkw|> maxZuladung:%s  super: %s ", maxZuladung, super.toString());
    }// toString
}// Lkw