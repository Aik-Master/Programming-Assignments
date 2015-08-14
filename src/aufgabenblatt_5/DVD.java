/** 
* <b>Header</b>
* Praktikum    P1P
* Semester     WS12/13
* Team         S4T4
* Aufgabe      B1
* Kontrolleur  Michael Schafers
* Datum        13.12.12
* Quellen       /
* @author      Klostermann, Aiko; 2125565
*/

package aufgabenblatt_5;

import aufgabenblatt_5.DiscEnums.Format;
import aufgabenblatt_5.DiscEnums.Inhalt;


public class DVD extends Disc{

    private Format format;

    DVD(String titel, Inhalt inhalt , Format format){
        super(titel, inhalt);
        this.format = format;
    }// DVD(

    @Override
    public String toString(){
        return String.format("<|DVD|> super: %s format:%s", super.toString(), format);
    }//toString

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        return result;
    }//hashCode

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(!super.equals(obj))
            return false;
        if(getClass() != obj.getClass())
            return false;
        DVD other = (DVD) obj;
        if(format != other.format)
            return false;
        return true;
    }//equals
}// DVD{