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


public abstract class Disc{

    private String titel;
    private Inhalt inhalt;

    Disc(String titel, Inhalt inhalt){
        this.titel = titel;
        this.inhalt = inhalt;
    }// Disc(

    @Override
    public String toString(){
        return String.format("<|Disc|> titel:%s, inhalt:%s", titel, inhalt);
    }// toString

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((inhalt == null) ? 0 : inhalt.hashCode());
        result = prime * result + ((titel == null) ? 0 : titel.hashCode());
        return result;
    }//hashCode

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Disc other = (Disc) obj;
        if(inhalt != other.inhalt)
            return false;
        if(titel == null){
            if(other.titel != null)
                return false;
        } else if(!titel.equals(other.titel))
            return false;
        return true;
    }//equals
}// Disc{