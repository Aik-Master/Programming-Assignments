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

public class Bier{

    public static void main(String[] bullshit){
        MagicList<String> bier = new MagicList<String>();

        bier.putL("kronsberg");
        bier.putL("MeisterPils");
        bier.putF("Hansa");

        MagicList<String> bier1 = new MagicList<String>();

        bier1.putL("kronsberg");
        bier1.putL("MeisterPils");
        bier1.putF("Hansa");

        System.out.println("while");
        while(!bier.isEmpty()){
            String d = bier.peekNo((int) (Math.random() * bier.size()));
            bier.remove(d);
            bier1.putNo((int) (Math.random() * (1 + bier1.size())), d);
        }// while
        System.out.println("while");

        bier.putL("kronsberg");
        bier.putL("MeisterPils");
        bier.putF("Hansa");
        System.out.println(bier.peekF());
        System.out.println(bier.peekL());
        bier.printF2L();
        bier.printL2F();
        System.out.println(bier.size());

        System.out.println(bier.peekNo(2));
        System.out.println(bier.pos("Hansa"));
        System.out.println(bier.putNo(3, "Germania"));
        bier.printF2L();
        System.out.println("getNo");
        System.out.println(bier.getNo(2));
        System.out.println(bier.getNo(2));
        System.out.println();
        bier.printF2L();
        while(bier.pos("Hansa") != -1){
            bier.remove("Hansa");
            System.out.println();
        }
        bier.printF2L();
        System.out.println("sublist1");
        MagicList<String> bier2 = bier.subList("kronsberg");
        bier2.printF2L();

        bier.putF("Oettinger");

        System.out.println("sublist2");
        MagicList<String> bier3 = bier.subList("Oettinger", "Oettinger");
        bier3.printF2L();
        System.out.println();
    }

}