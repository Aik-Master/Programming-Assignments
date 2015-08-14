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

import static aufgabenblatt_5.DiscEnums.Inhalt.*;
import static aufgabenblatt_5.DiscEnums.Format.*;


public class Disc_verwaltung{

    public static void main(String[] args){

        MagicList<Disc> l1 = new MagicList<Disc>();

        l1.putL(new CD("Sing mit Heino", AUDIO, "Heino"));
        l1.putL(new DVD("Augsburger Puppenkiste: Urmel aus dem Eis – Gold Edition", MOVIE, PAL));
        l1.putL(new CD("IV", AUDIO, "Led Zeppelin"));
        l1.putL(new DVD("Sin City - Uncut", MOVIE, NTSC));
        l1.putL(new DVD("Gone with the Wind", MOVIE, PAL));
        l1.putL(new DVD("David Bowie: Best of Bowie", VIDEO, PAL));
        l1.putL(new DVD("Irreversible", MOVIE, PAL));
        l1.putL(new DVD("Menschenfeind", MOVIE, PAL));
        l1.putL(new DVD("Enter the Void", MOVIE, PAL));
        l1.putL(new DVD("Synedoche New York", MOVIE, PAL));
        l1.putL(new DVD("Vergiss mein nicht!", MOVIE, PAL));
        l1.putL(new DVD("Geständnisse – Confessions of a Dangerous Mind", MOVIE, PAL));
        l1.putL(new DVD("Adaption", MOVIE, PAL));
        l1.putL(new DVD(" Human Nature", MOVIE, PAL));
        l1.putL(new DVD("Being John Malkovich", MOVIE, PAL));
        l1.putL(new DVD("The Shining", MOVIE, PAL));
        l1.putL(new DVD("A Clockwork Orange", MOVIE, PAL));
        l1.putL(new DVD("Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb", MOVIE, PAL));
        l1.putL(new DVD("2001: A Space Odyssey", MOVIE, PAL));

        System.out.println("-----------------------------");
        MagicList<Disc> l2 = new MagicList<Disc>();
        // nun testen durch „hin-und-her“-kopieren
        if ( l1.size() < 16 ){ System.out.println( "ERROR : Die Aufgabenstellung wurde nicht gruendlich gelesen!" ); }
        while ( !l1.isEmpty() ){ l2.putF( l1.getL() ); } l2.printF2L(); System.out.println( l2.size() );
        while ( !l2.isEmpty() ){ l1.putL( l2.getF() ); } l1.printF2L(); System.out.println( l1.size() );
        while ( !l1.isEmpty() ){ l2.putNo( 0, l1.getL() ); } l2.printF2L(); System.out.println( l2.size() );
        while ( !l2.isEmpty() ){ l1.putNo( l1.size(), l2.getF() ); } l1.printF2L(); System.out.println( l1.size() );
        while ( !l1.isEmpty() ){ l2.putNo( (int)( Math.random()*(1+l2.size()) ), l1.getL() ); } l2.printF2L(); System.out.println( l2.size() );
        while ( !l2.isEmpty() ){
        Disc d = l2.peekNo( (int)( Math.random()*l2.size() ) );
        l2.remove( d );
        l1.putNo( (int)( Math.random()*(1+l1.size()) ), d );
        }//while
        l1.printF2L(); System.out.println( l1.size() );
        l1.printL2F(); System.out.println( l1.size() );
        l1.printF2L(); System.out.println( l1.size() );
        l2.printF2L(); System.out.println( l2.size() );
        l2.printL2F(); System.out.println( l2.size() );
        System.out.println( "-----------------------------" );
        // subList testen
        l1.subList( l1.peekNo(4), l1.peekNo(13) ).printL2F(); System.out.println( l1.subList( l1.peekNo(4), l1.peekNo(13) ).size() );
        l1.subList( l1.peekNo(13), l1.peekNo(4) ).printL2F(); System.out.println( l1.subList( l1.peekNo(13), l1.peekNo(4) ).size() );
        System.out.println( "-----------------------------" );
        int i1 = (int)( Math.random()*(l1.size()) );
        int i2 = (int)( Math.random()*(l1.size()) );
        System.out.printf( "\n i1=%d , i2=%d , size=%d\n", i1, i2, l1.size() );
        l1.subList( l1.peekNo( i1 ), l1.peekNo( i2 ) ).printL2F(); System.out.println( l1.subList( l1.peekNo( i1 ), l1.peekNo( i2 ) ).size() );
        l1.subList( l1.peekF(), l1.peekNo( i1 ) ).printL2F(); System.out.println( l1.subList( l1.peekF(), l1.peekNo( i1 ) ).size() );
        l1.subList( l1.peekL(), l1.peekNo( i1 ) ).printL2F(); System.out.println( l1.subList( l1.peekL(), l1.peekNo( i1 ) ).size() );
        l1.subList( l1.peekNo( i1 ), l1.peekF() ).printL2F(); System.out.println( l1.subList( l1.peekNo( i1 ), l1.peekF() ).size() );
        l1.subList( l1.peekNo( i1 ), l1.peekL() ).printL2F(); System.out.println( l1.subList( l1.peekNo( i1 ), l1.peekL() ).size() );
        System.out.println( "-----------------------------" );
    }//main
}//Disc_verwaltung