package DiningSmurfs_A4.v2;

import java.util.Scanner;

public class SmurfMain{

    public static void main(String[] args){

        int noj = 3; // Number of JuiceDispensers

        // ----- getting the Number of Smurfs(nos) -----
        int nos; // Number of Smurfs
        System.out.println("Wie viele Schlümpfe leben im Schlumpfenland?");
        Scanner nosInput = new Scanner(System.in);
        nos = nosInput.nextInt();
        nosInput.close();

        // ---- creating Table -----
        Table table = new Table(nos, noj);

        // ----- create smurfs -----
        Smurf[] smurfs = new Smurf[nos];
        for(int i = 0 ; i < nos ; i++){
            smurfs[i] = new Smurf(i, nos, table);
        }

        // ----- arouse the Smurfs -----
        for(Smurf smurf : smurfs){
            smurf.start();
        }

        // ----- destroying SmurfVillage and therefore kill all smurfs -----
/*        Scanner killScanner = new Scanner(System.in);
        System.out.println("Kill the frickin Smurfs?");
        killScanner.nextLine();
        for(int i = 0 ; i < nos ; i++){
            smurfs[i].killSmurf();
        }
        killScanner.close();*/
    }
}
