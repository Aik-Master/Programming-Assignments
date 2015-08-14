/** 
 * <b>Header</b>
 * Praktikum     P1P
 * Semester      WS12/13
 * Team          S4T4
 * Aufgabe       A8
 * Kontrolleur   Michael Schafers
 * Datum         13.12.12
 * Quellen        /
 * @author       Klostermann, Aiko; 2125565
 */

package aufgabenblatt_4;

import java.util.ArrayList;

public class Fuhrpark{

    private ArrayList<Vehikel> vehikelListe = new ArrayList<Vehikel>();

    public void add(Vehikel vehikel){
        vehikelListe.add(vehikel);
    }// add

    public int berechneTagesEinnahmen(){
        int tagesEinnahmen = 0;
        for(Vehikel vehikel : vehikelListe){
            if(vehikel.getVerliehen()){
                tagesEinnahmen += vehikel.getKosten();
            }// if
        }// for
        return(tagesEinnahmen);
    }// berechneTagesEinnahmen()

    public void leiheAus(String name){
        for(Vehikel vehikel : vehikelListe){
            if(vehikel.zuVerleihen() && vehikel.name.equals(name)){
                vehikel.leiheAus();
            }// if
        }// for
    }// leiheAus

    public void gibZuruck(String name){
        for(Vehikel vehikel : vehikelListe){
            if(vehikel.zuVerleihen() && vehikel.name.equals(name)){
                vehikel.gibZuruck();
            }// if
        }// for
    }// gibZuruck

    public void verfugbar(){
        verfugbar("*", "*");
    }// verfugbar()

    public void verfugbar(String vehikelTyp){
        if(vehikelTyp == "*"){
            verfugbar("*", "*");
        } else{
            verfugbar(vehikelTyp, "*");
        }// else
    }// verfugbar(String )

    public void verfugbar(String vehikelTyp, String zusatzInfo){
        vehikelTyp = vehikelTyp.toUpperCase();
        zusatzInfo = zusatzInfo.toUpperCase();

        for(Vehikel vehikel : vehikelListe){
            if(vehikelTyp == "*" && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo == "*")){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(2) == 'H' && vehikel instanceof Vehikel && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo == "*")){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'K' && vehikel instanceof Kfz
                    && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo == "*" || zusatzInfo.equals(((Kfz) vehikel).getKraftstoff()))){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'L' && vehikel instanceof Lkw
                    && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo == "*" || zusatzInfo.equals(((Lkw) vehikel).getZuladung()))){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'P' && vehikel instanceof Pkw
                    && ((zusatzInfo.equals(vehikel.getFarbe()) || Integer.parseInt(zusatzInfo) <= ((Pkw) vehikel).getSitzplatze()) || zusatzInfo == "*")){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'B' && vehikel instanceof Bus
                    && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo.equals(((Bus) vehikel).getBusTyp().toString().toUpperCase()) || zusatzInfo == "*")){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'M' && vehikel instanceof Mopped
                    && (zusatzInfo.equals(vehikel.getFarbe()) || Integer.parseInt(zusatzInfo) <= ((Mopped) vehikel).getHubraum())){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'R' && vehikel instanceof Velo && ((Velo) vehikel).getVeloTyp() == "ROLLER"
                    && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo == "*")){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'F' && vehikel instanceof Velo && ((Velo) vehikel).getVeloTyp() == "FAHRRAD"
                    && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo == "*")){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'D' && vehikel instanceof Velo && ((Velo) vehikel).getVeloTyp() == "DREIRAD"
                    && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo == "*")){
                System.out.println(vehikel);
            } else if(vehikelTyp.charAt(0) == 'V' && vehikel instanceof Velo && (zusatzInfo.equals(vehikel.getFarbe()) || zusatzInfo == "*")){
                System.out.println(vehikel);
            }// if
        }// for
    }// verfugbar(String, String

    public void verfugbar(String vehikelTyp, String geschwindigkeit, String sitzplatze){
        if(vehikelTyp.charAt(0) == 'P'){
            for(Vehikel vehikel : vehikelListe){
                if(vehikel.zuVerleihen() && vehikel instanceof Pkw && ((Pkw) vehikel).getGeschwindigkeit() >= Integer.parseInt(geschwindigkeit)
                        && ((Pkw) vehikel).getSitzplatze() >= Integer.parseInt(sitzplatze)){
                    System.out.println(vehikel);
                }// if
            }// for
        } else{
            System.out.println("Abfrage nicht moglich");
        }// else
    }// verfugbar(String, String, String)
}// Fuhrpark