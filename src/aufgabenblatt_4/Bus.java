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

import aufgabenblatt_4.FuhrparkEnums.Farbe;
import aufgabenblatt_4.FuhrparkEnums.BusTyp;
import aufgabenblatt_4.FuhrparkEnums.Kraftstoffart;

public class Bus extends Kfz{

    private int    sitzplatze;
    private BusTyp bustyp;

    public Bus(String name, Farbe farbe, boolean defekt, boolean verliehen, Kraftstoffart kraftstoff, BusTyp bustyp,
            int sitzplatze){
        super(name, farbe, defekt, verliehen, kraftstoff);
        this.sitzplatze = sitzplatze;
        this.bustyp = bustyp;
        switch(bustyp){
            case NORMAL:
                setKosten(10000);
                break;
            default:
                setKosten(12500);
        }// switch
    }// Bus()

    public BusTyp getBusTyp(){
        return(bustyp);
    }// getBusTyp

    public int getSitzplatze(){
        return sitzplatze;
    }// getSitzplatze

    @Override
    public String toString(){
        return String.format("<|Bus|> sitzplatze:%s, bustyp:%s  super: %s ", sitzplatze, bustyp, super.toString());
    }// toString
}// Bus