/** 
 * <b>Header</b>
 * Praktikum     P2P
 * Semester      SoSe13
 * Team          S1T1
 * Aufgabe       A1
 * Kontrolleur   Schafers
 * Datum         03.04.13
 * Quellen       /
 * @author       Klostermann, Aiko: 2125565
 */

package cube;

public class Surface{

    private Alignment  alignment;
    private static int surfaceIDcount = 0;
    private int        surfaceID;

    public Surface(Alignment alignment){
        if(surfaceIDcount >= 54){
            surfaceIDcount = 0;
        }// if
        surfaceID = ++surfaceIDcount;
        this.alignment = alignment;
    }// Surface

    public int getSurfaceID(){
        return surfaceID;
    }// getSurfaceID

    public Alignment getAlignment(){
        return alignment;
    }// getAlignment

    public void setAlignment(Alignment alignment){
        this.alignment = alignment;
    }// setAlignment
}// Surface