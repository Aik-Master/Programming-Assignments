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

public abstract class Vehikel{

    private static int  anzahlVehikel = 0;

    public final int    id;
    public final String name;
    private Farbe       farbe;
    private boolean     defekt;
    private boolean     verliehen;
    private int         kosten;

    public Vehikel(String name, Farbe farbe, boolean defekt, boolean verliehen){
        this.id = ++anzahlVehikel;
        this.name = name;
        this.farbe = farbe;
        this.defekt = defekt;
        this.verliehen = verliehen;
    }// Vehikel()

    public int getKosten(){
        return(kosten);
    }// getKosten

    public void setKosten(int kosten){
        this.kosten = kosten;
    }// setKosten

    public String getFarbe(){
        return(farbe.toString().toUpperCase());
    }// getFarbe

    public boolean zuVerleihen(){
        return(!defekt && !verliehen);
    }// zuVerleihen

    public boolean getVerliehen(){
        return(verliehen);
    }// getVerliehen

    public void leiheAus(){
        verliehen = true;
    }// leiheAus

    public void gibZuruck(){
        verliehen = false;
    }// gibZuruck

    public void setDefekt(boolean defekt){
        this.defekt = defekt;
    }// setDefekt

    public void wartungDurchfuhren(){
        defekt = false;
        System.out.println(getClass().getSimpleName() + ": (#" + id + ") warten");
    }// wartungDurchfuhren

    @Override
    public String toString(){
        return(String.format("<|Vehikel|> anzahlVehikel: %d id: %d name: %s farbe: %s defekt: %b verliehen: %b kosten: %d",
                                              anzahlVehikel, id, name, farbe, defekt, verliehen, kosten));
    }// toString
}// Vehikel