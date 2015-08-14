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

public class Mopped extends Kfz{

    private int hubraum;

    public Mopped(String name, Farbe farbe, boolean defekt, boolean verliehen, Kraftstoffart kraftstoff, int hubraum){
        super(name, farbe, defekt, verliehen, kraftstoff);
        this.hubraum = hubraum;

        if(hubraum < 100){
            setKosten(500);
        } else if(hubraum < 250){
            setKosten(1000);
        } else if(hubraum < 500){
            setKosten(3000);
        } else if(hubraum < 1000){
            setKosten(6000);
        } else{
            setKosten(10000);
        }// if else
    }// Mopped()

    public int getHubraum(){
        return(hubraum);
    }// getHubraum

    @Override
    public String toString(){
        return String.format("<|Mopped|> hubraum:%s  super: %s ", hubraum, super.toString());
    }// toString
}// Mopped