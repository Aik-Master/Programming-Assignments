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

import static aufgabenblatt_4.FuhrparkEnums.*;

public class Velo extends Vehikel{

    private VeloTyp velotyp;

    public Velo(String name, Farbe farbe, boolean defekt, boolean verliehen, VeloTyp velotyp){
        super(name, farbe, defekt, verliehen);
        this.velotyp = velotyp;

        switch(velotyp){
            case FAHRRAD:
                this.setKosten(100);
                break;
            case DREIRAD:
                this.setKosten(13);
                break;
            case ROLLER:
                switch(farbe){
                    case ROT:
                        this.setKosten(11);
                        break;
                    case GRUN:
                        this.setKosten(15);
                        break;
                    case GELB:
                        this.setKosten(99);
                        break;
                    case BLAU:
                        this.setKosten(17);
                        break;
                    default:
                        this.setKosten(10);
                }// switch(farbe)
                break;
        }// switch(velotyp)
    }// Velo()

    public String getVeloTyp(){
        return(velotyp.toString());
    }// getVeloTyp

    @Override
    public void wartungDurchfuhren(){
        setDefekt(false);
        System.out.println("Velo: (#" + id + ") warten");
    }// wartungDurchfuhren

    @Override
    public String toString(){
        return String.format("<|Velo|> velotyp:%s  super: %s ", velotyp, super.toString());
    }// toString
}// Velo