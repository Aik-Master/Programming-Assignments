/** 
 * <b>Header</b>
 * Praktikum     P2P
 * Semester      SoSe13
 * Team          S1T1
 * Aufgabe       A3
 * Kontrolleur   Behnke
 * Datum         22.05.13
 * Quellen       /
 * @author       Klostermann, Aiko: 2125565
 */

package fileAnallysis;

public class FileAnalysisMain{

    public static void main(String[] args){

        FileAnalysisLogic logic = new FileAnalysisLogic();
        new FileAnalysisGUI(logic);
    }
}
