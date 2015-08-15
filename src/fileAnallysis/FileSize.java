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

public class FileSize{

    private long   size;
    private String path;

    FileSize(long size, String path){
        this.size = size;
        this.path = path;
    }

    public long getSize(){
        return size;
    }

    public String getPath(){
        return path;
    }

    public void setSize(long size){
        this.size = size;
    }

    public void setPath(String path){
        this.path = path;
    }
}