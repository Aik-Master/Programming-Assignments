package DiningSmurfs_A4.v2;

import java.lang.Thread.State;
import java.lang.Thread.UncaughtExceptionHandler;

public class Smurf extends Smurf_A implements Runnable{

    private final Thread     t;
    private volatile boolean smurfing;
    private final int        ID;
    private Table            table;
    private int              right;
    private int              left;
    private boolean          bothForks = false;

    public void killSmurf(){
        this.smurfing = false;
    }

    public Smurf(int ID, int nos, Table table){
        this.ID = ID;
        right = ID;
        left = (ID + 1) % nos;
        t = new Thread(this);
        this.smurfing = true;
        this.table = table;
        System.out.println("Smurf" + this.t.getId() + " created");
    }// Constructor

    @Override
    public void run(){
        while(smurfing){

            // trinken
            try{
                table.juiceDispenser.acquire();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            try{
                super.drinks();
            } finally{
                table.juiceDispenser.release();
            }

            // denken
            super.thinks();

            // essen
            table.getForks(left, right);
            super.eats();
            table.giveForksAway(left, right);
        }
    }

    // ....... alles an den Thread t delegieren ....
    public void start(){
        t.start();
        System.out.println("Smurf" + ID + " is alive, it's internal ThreadID is" + t.getId());
    }

    public void interrupt(){
        t.interrupt();
    }

    public boolean isInterrupted(){
        return t.isInterrupted();
    }

    public final boolean isAlive(){
        return t.isAlive();
    }

    public final void setPriority(int newPriority){
        t.setPriority(newPriority);
    }

    public final int getPriority(){
        return t.getPriority();
    }

    public final void setName(String name){
        t.setName(name);
    }

    public final String getName(){
        return t.getName();
    }

    public final ThreadGroup getThreadGroup(){
        return t.getThreadGroup();
    }

    public final void join(long millis) throws InterruptedException{
        t.join(millis);
    }

    public final void join(long millis, int nanos) throws InterruptedException{
        t.join(millis, nanos);
    }

    public final void join() throws InterruptedException{
        t.join();
    }

    public final void setDaemon(boolean on){
        t.setDaemon(on);
    }

    public final boolean isDaemon(){
        return t.isDaemon();
    }

    public final void checkAccess(){
        t.checkAccess();
    }

    public ClassLoader getContextClassLoader(){
        return t.getContextClassLoader();
    }

    public void setContextClassLoader(ClassLoader cl){
        t.setContextClassLoader(cl);
    }

    public StackTraceElement[] getStackTrace(){
        return t.getStackTrace();
    }

    public long getId(){
        return t.getId();
    }

    public State getState(){
        return t.getState();
    }

    public UncaughtExceptionHandler getUncaughtExceptionHandler(){
        return t.getUncaughtExceptionHandler();
    }

    public void setUncaughtExceptionHandler(UncaughtExceptionHandler eh){
        t.setUncaughtExceptionHandler(eh);
    }

}
