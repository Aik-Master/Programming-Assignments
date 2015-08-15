package DiningSmurfs_A4.v2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Table{

    public Semaphore juiceDispenser;
    public boolean[] forks;
    
    public Table(int nos, int noj) {
        juiceDispenser = new Semaphore(noj, true);
        forks = new boolean[nos];
        
        for(int i = 0; i< nos; i++) {
            forks[i] = false;
        }
    }

    public synchronized void getForks(int left, int right){
        while ( forks[left] || forks[right] ){// at least one of the forks is in use
            try{
                wait();
            }catch( InterruptedException ex ){ ex.printStackTrace(); }
        }//while
        // ----- actually getting forks -----
        forks[left] = true;
        forks[right] = true; 
    }

    public synchronized void giveForksAway(int left, int right){        
        forks[left] = false;
        forks[right] = false;
        notifyAll();
    }

}
