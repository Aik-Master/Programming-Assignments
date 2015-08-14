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

import aufgabenblatt_5.DiscEnums.Inhalt;


public class CD extends Disc{

    private String interpret;

    CD(String titel, Inhalt inhalt, String interpret){
        super(titel, inhalt);
        this.interpret = interpret;
    }// CD(

    @Override
    public String toString(){
        return String.format("<|CD|> super: %s interpret:%s", super.toString(), interpret);
    }//toString

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((interpret == null) ? 0 : interpret.hashCode());
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
        CD other = (CD) obj;
        if(interpret == null){
            if(other.interpret != null)
                return false;
        } else if(!interpret.equals(other.interpret))
            return false;
        return true;
    }//equals
}// CD{