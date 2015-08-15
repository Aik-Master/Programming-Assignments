/** 
 * <b>Header</b>
 * Praktikum     P2P
 * Semester      SoSe13
 * Team          S1T1
 * Aufgabe       A1
 * Kontrolleur   Schafers
 * Datum         03.04.13
 * Quellen       /
 * @author       Klostermann, Aiko: 2125565
 */

package cube;

public class Stone{

    private Surface[]  surface;
    private int        stoneID;
    private static int stoneIDcounter = 0;

    public Stone(){
        if(stoneIDcounter >= 27){
            stoneIDcounter = 0;
        }// if
        stoneID = ++stoneIDcounter;
        surface = new Surface[6];
    }// Stone

    public int getStoneID(){
        return stoneID;
    }// getStoneID

    public Surface[] getSurface(){
        return surface;
    }// getSurface []

    protected void rotateStoneX(){

        for(int i = 0 ; i < surface.length ; i++){
            if(surface[i] != null){
                switch(surface[i].getAlignment()){
                    case H:
                        surface[i].setAlignment(Alignment.U);
                        break;
                    case L:
                        // no change
                        break;
                    case O:
                        surface[i].setAlignment(Alignment.H);
                        break;
                    case R:
                        // no change
                        break;
                    case U:
                        surface[i].setAlignment(Alignment.V);
                        break;
                    case V:
                        surface[i].setAlignment(Alignment.O);
                        break;
                    default:
                        break;
                }// switch
            }// if
        }// for

        Surface[] tmp = new Surface[6];
        // tmp[] = surface[]
        for(int i = 0 ; i < surface.length ; i++){
            if(surface[i] != null){
                tmp[i] = surface[i];
            }// if
        }// for
        surface[4] = tmp[0];
        surface[5] = tmp[3];
        surface[3] = tmp[4];
        surface[0] = tmp[5];
    }// rotateX

    protected void rotateStoneY(){
        for(int i = 0 ; i < surface.length ; i++){
            if(surface[i] != null){
                switch(surface[i].getAlignment()){
                    case H:
                        surface[i].setAlignment(Alignment.L);
                        break;
                    case L:
                        surface[i].setAlignment(Alignment.V);
                        break;
                    case O:
                        // no change
                        break;
                    case R:
                        surface[i].setAlignment(Alignment.H);
                        break;
                    case U:
                        // no change
                        break;
                    case V:
                        surface[i].setAlignment(Alignment.R);
                        break;
                    default:
                        break;
                }// switch
            }// if
        }// for

        Surface[] tmp = new Surface[6];
        // tmp[] = surface[]
        for(int i = 0 ; i < surface.length ; i++){
            if(surface[i] != null){
                tmp[i] = surface[i];
            }// if
        }// for
        surface[2] = tmp[0];
        surface[0] = tmp[1];
        surface[3] = tmp[2];
        surface[1] = tmp[3];
    }// rotateY

    protected void rotateStoneZ(){
        for(int i = 0 ; i < surface.length ; i++){
            if(surface[i] != null){
                switch(surface[i].getAlignment()){
                    case H:
                        // no change
                        break;
                    case L:
                        surface[i].setAlignment(Alignment.U);
                        break;
                    case O:
                        surface[i].setAlignment(Alignment.L);
                        break;
                    case R:
                        surface[i].setAlignment(Alignment.O);
                        break;
                    case U:
                        surface[i].setAlignment(Alignment.R);
                        break;
                    case V:
                        // no change
                        break;
                    default:
                        break;
                }// switch
            }// if
        }// for

        Surface[] tmp = new Surface[6];
        // tmp[] = surface[]
        for(int i = 0 ; i < surface.length ; i++){
            if(surface[i] != null){
                tmp[i] = surface[i];
            }// if
        }// for
        surface[5] = tmp[1];
        surface[4] = tmp[2];
        surface[1] = tmp[4];
        surface[2] = tmp[5];
    }// rotateZ
}// Stone