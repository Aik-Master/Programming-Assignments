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

public class Node<T> {
    Node<T> prev;
    Node<T> next;
    T                info;

    Node(T info){
        next        = null;
        prev        = null;
        this.info = info;
    }// Node(

    @Override
    public String toString(){
        return String.format("<|Node|>  prev:%s, next:%s, info:%s", prev, next, info);
    }//toString
}// Node<T>