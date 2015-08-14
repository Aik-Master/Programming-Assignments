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

public class Pkw extends Kfz{

    private int geschwindigkeit;
    private int sitzplatze;

    public Pkw(String name, Farbe farbe, boolean defekt, boolean verliehen, Kraftstoffart kraftstoff, int geschwindigkeit, int sitzplatze){
        super(name, farbe, defekt, verliehen, kraftstoff);
        this.geschwindigkeit = geschwindigkeit;
        this.sitzplatze = sitzplatze;

        if(geschwindigkeit < 100){
            setKosten(1000 + sitzplatze * 200);
        } else if(geschwindigkeit < 150){
            setKosten(1500 + sitzplatze * 200);
        } else if(geschwindigkeit < 200){
            setKosten(2500 + sitzplatze * 200);
        } else{
            setKosten(5000 + sitzplatze * 200);
        }// if else
    }// Pkw()

    public int getGeschwindigkeit(){
        return geschwindigkeit;
    }// getGeschwindigkeit

    public int getSitzplatze(){
        return sitzplatze;
    }// getSitzplatze

    @Override
    public String toString(){
        return String.format("<|Pkw|> geschwindigkeit:%s, sitzplatze:%s  super: %s ", 
                                               geschwindigkeit, sitzplatze,super.toString());
    }// toString
}// Pkw