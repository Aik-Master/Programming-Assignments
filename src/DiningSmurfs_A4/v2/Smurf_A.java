package DiningSmurfs_A4.v2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Smurf_A {
    
    private static final long START  =  System.nanoTime();
    
    
    private long drinkCnt;
    private long mealCnt;
    private long workCnt;
    
    private boolean dbgen;
    
    
    
    
    
    public Smurf_A( boolean dbgen ){
        this.dbgen = dbgen;
        this.drinkCnt = 0;
        this.mealCnt = 0;
        this.workCnt = 0;
    }//Smurf_A
    //
    public Smurf_A(){ this( true ); }
    
    
    
    
    
    public final void drinks(){
        for ( long l=1000; l>=0; l-- ){}
        if ( dbgen ){
            System.out.printf(
                "Smurf %2d is drinking %5d @ %s -> %s\n",
                Thread.currentThread().getId(),
                ++this.drinkCnt,
                getTimeStampString(),
                prettyTime( System.nanoTime() - START )
            );
        }//if
        for ( long l=1000+(long)( 98000* Math.random() ); l>=0; l-- ){}
    }//drinks
    
    public final void eats(){
        for ( long l=1000; l>=0; l-- ){}
        if ( dbgen ){
            System.out.printf(
                "Smurf %2d is eating %7d @ %s -> %s\n",
                Thread.currentThread().getId(),
                ++this.mealCnt,
                getTimeStampString(),
                prettyTime( System.nanoTime() - START )
            );
        }//if
        for ( long l=1000+(long)( 98000* Math.random() ); l>=0; l-- ){}
    }//eats
    
    public final void thinks(){
        for ( long l=1000; l>=0; l-- ){}
        if ( dbgen ){
            System.out.printf(
                "Smurf %2d is thinking %5d @ %s -> %s\n",
                Thread.currentThread().getId(),
                ++this.workCnt,
                getTimeStampString(),
                prettyTime( System.nanoTime() - START )
            );
        }//if
        for ( long l=1000+(long)( 98000* Math.random() ); l>=0; l-- ){}
    }//thinks
    
    
    
    private static String getTimeStampString(){
        return new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss.SSS", new Locale("de","DE") ).format( new Date().getTime() );
    }//requestTimeString
    
    private static String prettyTime( long nsTime ){
        if (       nsTime < 1000000000000L ){
            return String.format(
                "%3d_%03d_%03d_%03d[ns]",
                   nsTime / 1000000000L,
                 ( nsTime /    1000000L ) % 1000,
                 ( nsTime /       1000L ) % 1000,
                   nsTime                 % 1000
            );//return
        }else if ( nsTime < 1000000000000000L ){
            return String.format(
                "%3d_%03d_%03d_%03d_%03d[ns]",
                   nsTime / 1000000000000L ,
                (  nsTime /    1000000000L ) % 1000,
                (  nsTime /       1000000L ) % 1000,
                (  nsTime /          1000L ) % 1000,
                   nsTime                    % 1000
            );//return
        }else if ( nsTime < 1000000000000000000L ){
            return String.format(
                "%3d_%03d_%03d_%03d_%03d_%03d[ns]",
                   nsTime / 1000000000000000L ,
                (  nsTime /    1000000000000L ) % 1000,
                (  nsTime /       1000000000L ) % 1000,
                (  nsTime /          1000000L ) % 1000,
                (  nsTime /             1000L ) % 1000,
                   nsTime                       % 1000
            );//return
        }else{
            return String.format(
                "%3d_%03d_%03d_%03d_%03d_%03d_%03d[ns]",
                   nsTime / 1000000000000000000L ,
                (  nsTime /    1000000000000000L ) % 1000,
                (  nsTime /       1000000000000L ) % 1000,
                (  nsTime /          1000000000L ) % 1000,
                (  nsTime /             1000000L ) % 1000,
                (  nsTime /                1000L ) % 1000,
                   nsTime                          % 1000
            );//return 
        }//if
    }//prettyTime
    
}//Smurf_A
