/** 
 * <b>Header</b>
 * Praktikum     P1P
 * Semester      WS12/13
 * Team          S4T4
 * Aufgabe       B2
 * Kontrolleur   Schafers
 * Datum         20.11.12
 * Quellen       /
 * @author       Klostermann, Aiko; 2125565
 */

package aufgabenblatt_6;

public class Word implements Comparable<Word>{

    private final String word;

    public String getWord(){
        return(word);
    }// getWord

    public Word(String word){
        this.word = word;
    }// Word(

    @Override
    public int hashCode(){
        return(word.hashCode());
    }// hashCode

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if(word == null){
            if(other.word != null)
                return false;
        } else if(!word.equals(other.word)) // ignore Case!
            return false;
        return true;
    }// equals

    @Override
    public int compareTo(Word word){
        return this.word.compareTo(word.word);
    }// compareTo
}// Word