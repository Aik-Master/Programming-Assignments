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

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class WordCounter{

    public static void main(String[] args){

        countWords();
    }// main

    public static void countWords(){

        try{
            WordGrabber wordgrabber = new WordGrabber("H:/k/klostermann_aiko/P1/aufgabenblatt_6/pg62.txt"); // Pfad angeben

            Map<Word, Counter> map = new HashMap<Word, Counter>();
            Word word = null;
            while(wordgrabber.hasNext()){
                word = new Word(wordgrabber.next());
                if(map.containsKey(word)){
                    map.get(word).inc();
                } else{
                    map.put(word, new Counter());
                }// else
            }// while

            Map<Word, Counter> tree = new TreeMap<Word, Counter>();
            for(Word outputWord : map.keySet()){
                tree.put(outputWord, map.get(outputWord));
            }// for

            System.out.println("contained words:");
            for(Word outputWord : tree.keySet()){
                System.out.println(outputWord.getWord() + " (" + tree.get(outputWord).getCounter() + ")");
            }// for

        } catch(IOException e){
            e.printStackTrace();
        }// try catch
    }// countWords
}// WordCounter