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


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class WordGrabber implements Iterator<String> {
    
    // declarations----------------------------------------------
    
    private BufferedReader br;  
    private String  line;
    private Matcher matcher;
    private Pattern pattern;
    private String  matched;
    private boolean nextComputed;
    
    
    
    // constructors----------------------------------------------
    
    public WordGrabber( final String fn ) throws FileNotFoundException, IOException {
        pattern = Pattern.compile( "\\w+" );
        br = new BufferedReader ( new FileReader ( fn ) );
        line = br.readLine();
        
        matcher = (line!=null)  ?  pattern.matcher(line)  :  pattern.matcher("");
        matched = null;
        nextComputed = false;
    }//WordGrabber
    
    public WordGrabber() throws FileNotFoundException, IOException {
        this( "input.txt" );
    }//WordGrabber
    
    
    
    // methods---------------------------------------------------
    
    @Override
    public boolean hasNext(){ return nextComputed  ?  matched!=null  :  nextAvailable(); }
    
    @Override
    public String next(){
        if ( nextComputed ){
            nextComputed = false;
        }else if ( !nextAvailable() ){
            throw new NoSuchElementException();
        }//if
        return matched;
    }//next
    
    @Override
    public void remove(){ throw new UnsupportedOperationException(); }
    
    
    
    // internal method for the computation of the next element
    private boolean nextAvailable(){
        boolean found = false;
        try{
            found = matcher.find();
            while ( (!found) && (line!=null) ){
                line = br.readLine();
                if ( line!=null ){
                    matcher = pattern.matcher( line );
                    found = matcher.find();
                }else{
                    found = false;
                }//if
            }//while
        }catch( IOException ex ){
            ex.printStackTrace();
        }//try
        
        nextComputed = true;
        matched = found  ?  matcher.group()  :  null;
        return found;
    }//getNext
    
}//WordGrabber
