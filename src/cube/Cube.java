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
 *               Morschheuser, Michael: 2125067
 */

package cube;

import java.util.ArrayList;

public class Cube{

    private Stone[][][] stones;

    public Cube(){
        init();
    }// Cube

    private void init(){
        stones = new Stone[3][3][3];
        for(int z = 0 ; z < 3 ; z++){
            for(int y = 2 ; y >= 0 ; y--){
                for(int x = 0 ; x < 3 ; x++){
                    stones[x][y][z] = new Stone();
                }// for
            }// for
        }// for

        // surface top
        for(int z = 2 ; z >= 0 ; z--){
            for(int x = 0 ; x < 3 ; x++){
                stones[x][2][z].getSurface()[4] = new Surface(Alignment.V);
            }// for
        }// for

        // surface 2. L
        for(int z = 2 ; z >= 0 ; z--){
            stones[0][2][z].getSurface()[1] = new Surface(Alignment.O);
        }// for

        // surface 2. V
        for(int x = 0 ; x < 3 ; x++){
            stones[x][2][0].getSurface()[0] = new Surface(Alignment.O);
        }// for

        // surface 2. R
        for(int z = 0 ; z < 3 ; z++){
            stones[2][2][z].getSurface()[2] = new Surface(Alignment.O);
        }// for

        // surface 2. H
        for(int x = 2 ; x >= 0 ; x--){
            stones[x][2][2].getSurface()[3] = new Surface(Alignment.O);
        }// for

        // surface 1. L
        for(int z = 2 ; z >= 0 ; z--){
            stones[0][1][z].getSurface()[1] = new Surface(Alignment.O);
        }// for

        // surface 1. V
        for(int x = 0 ; x < 3 ; x++){
            stones[x][1][0].getSurface()[0] = new Surface(Alignment.O);
        }// for

        // surface 1. R
        for(int z = 0 ; z < 3 ; z++){
            stones[2][1][z].getSurface()[2] = new Surface(Alignment.O);
        }// for

        // surface 1. H
        for(int x = 2 ; x >= 0 ; x--){
            stones[x][1][2].getSurface()[3] = new Surface(Alignment.O);
        }// for

        // surface 0. L
        for(int z = 2 ; z >= 0 ; z--){
            stones[0][0][z].getSurface()[1] = new Surface(Alignment.O);
        }// for

        // surface 0. V
        for(int x = 0 ; x < 3 ; x++){
            stones[x][0][0].getSurface()[0] = new Surface(Alignment.O);
        }// for

        // surface 0. R
        for(int z = 0 ; z < 3 ; z++){
            stones[2][0][z].getSurface()[2] = new Surface(Alignment.O);
        }// for

        // surface 0. H
        for(int x = 2 ; x >= 0 ; x--){
            stones[x][0][2].getSurface()[3] = new Surface(Alignment.O);
        }// for

        // surface bottom
        for(int z = 0 ; z < 3 ; z++){
            for(int x = 0 ; x < 3 ; x++){
                stones[x][0][z].getSurface()[5] = new Surface(Alignment.V);
            }// for
        }// for
    }

    public void rotate(ArrayList<Byte> rotationList){
        for(byte elem : rotationList){
            move(elem);
        }// for
    }// rotate

    private void move(byte rotation){
        if(rotation > 10 && rotation < 40){

            int numberOfRotations = rotation / 10; // how often to rotate(1|2|3)
            int rotationType = rotation - ((numberOfRotations - 1) * 10);// what kind of rotation(11|...|19)

            for(int i = 0 ; i < numberOfRotations ; i++){

                // tmp[][][] = copy of stones[][][]
                Stone[][][] tmp = new Stone[3][3][3];
                for(int a = 0 ; a < 3 ; a++){
                    for(int b = 0 ; b < 3 ; b++){
                        for(int c = 0 ; c < 3 ; c++){
                            tmp[a][b][c] = stones[a][b][c];
                        }// for
                    }// for
                }// for

                if(rotationType > 10 && rotationType < 14){
                    int stay = (rotationType % 10) - 1;

                    // rotate X
                    stones[stay][2][0] = tmp[stay][0][0];
                    stones[stay][1][0] = tmp[stay][0][1];
                    stones[stay][0][0] = tmp[stay][0][2];
                    stones[stay][2][1] = tmp[stay][1][0];
                    stones[stay][1][1] = tmp[stay][1][1];
                    stones[stay][0][1] = tmp[stay][1][2];
                    stones[stay][2][2] = tmp[stay][2][0];
                    stones[stay][1][2] = tmp[stay][2][1];
                    stones[stay][0][2] = tmp[stay][2][2];
                    for(int a = 0 ; a < 3 ; a++){
                        for(int b = 0 ; b < 3 ; b++){
                            stones[stay][a][b].rotateStoneX();
                        }// for
                    }// for
                }// if

                if(rotationType > 13 && rotationType < 17){
                    int stay = (rotationType % 10) - 4;

                    // rotate Y
                    stones[2][stay][0] = tmp[0][stay][0];
                    stones[1][stay][0] = tmp[0][stay][1];
                    stones[0][stay][0] = tmp[0][stay][2];
                    stones[2][stay][1] = tmp[1][stay][0];
                    stones[1][stay][1] = tmp[1][stay][1];
                    stones[0][stay][1] = tmp[1][stay][2];
                    stones[2][stay][2] = tmp[2][stay][0];
                    stones[1][stay][2] = tmp[2][stay][1];
                    stones[0][stay][2] = tmp[2][stay][2];
                    for(int a = 0 ; a < 3 ; a++){
                        for(int b = 0 ; b < 3 ; b++){
                            stones[a][stay][b].rotateStoneY();
                        }// for
                    }// for
                }// if

                if(rotationType > 16 && rotationType < 20){
                    int stay = (rotationType % 10) - 7;

                    // rotate Z
                    stones[2][0][stay] = tmp[0][0][stay];
                    stones[1][0][stay] = tmp[0][1][stay];
                    stones[0][0][stay] = tmp[0][2][stay];
                    stones[2][1][stay] = tmp[1][0][stay];
                    stones[1][1][stay] = tmp[1][1][stay];
                    stones[0][1][stay] = tmp[1][2][stay];
                    stones[2][2][stay] = tmp[2][0][stay];
                    stones[1][2][stay] = tmp[2][1][stay];
                    stones[0][2][stay] = tmp[2][2][stay];
                    for(int a = 0 ; a < 3 ; a++){
                        for(int b = 0 ; b < 3 ; b++){
                            stones[a][b][stay].rotateStoneZ();
                        }// for
                    }// for
                }// if

            }// for(numberOfRotations)
        } else if(rotation == 0 || rotation > 40){// specials
            switch(rotation){
                case (0):
                    init();
                    break;
                case (41):
                    move((byte) 13);
                    move((byte) 12);
                    move((byte) 11);
                    break;
                case (42):
                    move((byte) 23);
                    move((byte) 22);
                    move((byte) 21);
                    break;
                case (43):
                    move((byte) 33);
                    move((byte) 32);
                    move((byte) 31);
                    break;
                case (44):
                    move((byte) 16);
                    move((byte) 15);
                    move((byte) 14);
                    break;
                case (45):
                    move((byte) 26);
                    move((byte) 25);
                    move((byte) 24);
                    break;
                case (46):
                    move((byte) 36);
                    move((byte) 35);
                    move((byte) 34);
                    break;
                case (47):
                    move((byte) 19);
                    move((byte) 18);
                    move((byte) 17);
                    break;
                case (48):
                    move((byte) 29);
                    move((byte) 28);
                    move((byte) 27);
                    break;
                case (49):
                    move((byte) 39);
                    move((byte) 38);
                    move((byte) 37);
                    break;
            }// switch(rotation)
        }// if normal or special rotation
    }// move

    public void rotate(byte[] rotation){
        ArrayList<Byte> list = new ArrayList<Byte>();
        for(int i = 0 ; i < rotation.length ; i++){
            list.add(rotation[i]);
        }// for
        rotate(list);
    }// rotate()

    public void printCube(){
        System.out.printf("                   OOOOOOOOOOOOOOOO\n");
        System.out.printf("                   O %2d | %2d | %2d O\n", stones[0][2][2].getStoneID(),
                stones[1][2][2].getStoneID(), stones[2][2][2].getStoneID());
        System.out.printf("                   O %2S | %2S | %2S O\n", stones[0][2][2].getSurface()[4].getAlignment(),
                stones[1][2][2].getSurface()[4].getAlignment(), stones[2][2][2].getSurface()[4].getAlignment());
        System.out.printf("                   O %2d | %2d | %2d O\n", stones[0][2][2].getSurface()[4].getSurfaceID(),
                stones[1][2][2].getSurface()[4].getSurfaceID(), stones[2][2][2].getSurface()[4].getSurfaceID());
        System.out.printf("                   O----+----+----O\n");
        System.out.printf("                   O %2d | %2d | %2d O\n", stones[0][2][1].getStoneID(),
                stones[1][2][1].getStoneID(), stones[2][2][1].getStoneID());
        System.out.printf("                   O %2S | %2S | %2S O\n", stones[0][2][1].getSurface()[4].getAlignment(),
                stones[1][2][1].getSurface()[4].getAlignment(), stones[2][2][1].getSurface()[4].getAlignment());
        System.out.printf("                   O %2d | %2d | %2d O\n", stones[0][2][1].getSurface()[4].getSurfaceID(),
                stones[1][2][1].getSurface()[4].getSurfaceID(), stones[2][2][1].getSurface()[4].getSurfaceID());
        System.out.printf("                   O----+----+----O\n");
        System.out.printf("                   O %2d | %2d | %2d O\n", stones[0][2][0].getStoneID(),
                stones[1][2][0].getStoneID(), stones[2][2][0].getStoneID());
        System.out.printf("                   O %2S | %2S | %2S O\n", stones[0][2][0].getSurface()[4].getAlignment(),
                stones[1][2][0].getSurface()[4].getAlignment(), stones[2][2][0].getSurface()[4].getAlignment());
        System.out.printf("                   O %2d | %2d | %2d O\n", stones[0][2][0].getSurface()[4].getSurfaceID(),
                stones[1][2][0].getSurface()[4].getSurfaceID(), stones[2][2][0].getSurface()[4].getSurfaceID());
        System.out.printf("                   OOOOOOOOOOOOOOOO\n\n\n");
        System.out.printf("LLLLLLLLLLLLLLLL   VVVVVVVVVVVVVVVV   RRRRRRRRRRRRRRRR   HHHHHHHHHHHHHHHH\n");
        System.out.printf("L %2d | %2d | %2d L   V %2d | %2d | %2d V   R %2d | %2d | %2d R   H %2d | %2d | %2d H\n",
                stones[0][2][2].getStoneID(), stones[0][2][1].getStoneID(), stones[0][2][0].getStoneID(),
                stones[0][2][0].getStoneID(), stones[1][2][0].getStoneID(), stones[2][2][0].getStoneID(),
                stones[2][2][0].getStoneID(), stones[2][2][1].getStoneID(), stones[2][2][2].getStoneID(),
                stones[2][2][2].getStoneID(), stones[1][2][2].getStoneID(), stones[0][2][2].getStoneID());
        System.out.printf("L %2S | %2S | %2S L   V %2S | %2S | %2S V   R %2S | %2S | %2S R   H %2S | %2S | %2S H\n",
                stones[0][2][2].getSurface()[1].getAlignment(), stones[0][2][1].getSurface()[1].getAlignment(),
                stones[0][2][0].getSurface()[1].getAlignment(), stones[0][2][0].getSurface()[0].getAlignment(),
                stones[1][2][0].getSurface()[0].getAlignment(), stones[2][2][0].getSurface()[0].getAlignment(),
                stones[2][2][0].getSurface()[2].getAlignment(), stones[2][2][1].getSurface()[2].getAlignment(),
                stones[2][2][2].getSurface()[2].getAlignment(), stones[2][2][2].getSurface()[3].getAlignment(),
                stones[1][2][2].getSurface()[3].getAlignment(), stones[0][2][2].getSurface()[3].getAlignment());
        System.out.printf("L %2d | %2d | %2d L   V %2d | %2d | %2d V   R %2d | %2d | %2d R   H %2d | %2d | %2d H\n",
                stones[0][2][2].getSurface()[1].getSurfaceID(), stones[0][2][1].getSurface()[1].getSurfaceID(),
                stones[0][2][0].getSurface()[1].getSurfaceID(), stones[0][2][0].getSurface()[0].getSurfaceID(),
                stones[1][2][0].getSurface()[0].getSurfaceID(), stones[2][2][0].getSurface()[0].getSurfaceID(),
                stones[2][2][0].getSurface()[2].getSurfaceID(), stones[2][2][1].getSurface()[2].getSurfaceID(),
                stones[2][2][2].getSurface()[2].getSurfaceID(), stones[2][2][2].getSurface()[3].getSurfaceID(),
                stones[1][2][2].getSurface()[3].getSurfaceID(), stones[0][2][2].getSurface()[3].getSurfaceID());
        System.out.printf("L----+----+----L   V----+----+----V   R----+----+----R   H----+----+----H\n");
        System.out.printf("L %2d | %2d | %2d L   V %2d | %2d | %2d V   R %2d | %2d | %2d R   H %2d | %2d | %2d H\n",
                stones[0][1][2].getStoneID(), stones[0][1][1].getStoneID(), stones[0][1][0].getStoneID(),
                stones[0][1][0].getStoneID(), stones[1][1][0].getStoneID(), stones[2][1][0].getStoneID(),
                stones[2][1][0].getStoneID(), stones[2][1][1].getStoneID(), stones[2][1][2].getStoneID(),
                stones[2][1][2].getStoneID(), stones[1][1][2].getStoneID(), stones[0][1][2].getStoneID());
        System.out.printf("L %2S | %2S | %2S L   V %2S | %2S | %2S V   R %2S | %2S | %2S R   H %2S | %2S | %2S H\n",
                stones[0][1][2].getSurface()[1].getAlignment(), stones[0][1][1].getSurface()[1].getAlignment(),
                stones[0][1][0].getSurface()[1].getAlignment(), stones[0][1][0].getSurface()[0].getAlignment(),
                stones[1][1][0].getSurface()[0].getAlignment(), stones[2][1][0].getSurface()[0].getAlignment(),
                stones[2][1][0].getSurface()[2].getAlignment(), stones[2][1][1].getSurface()[2].getAlignment(),
                stones[2][1][2].getSurface()[2].getAlignment(), stones[2][1][2].getSurface()[3].getAlignment(),
                stones[1][1][2].getSurface()[3].getAlignment(), stones[0][1][2].getSurface()[3].getAlignment());
        System.out.printf("L %2d | %2d | %2d L   V %2d | %2d | %2d V   R %2d | %2d | %2d R   H %2d | %2d | %2d H\n",
                stones[0][1][2].getSurface()[1].getSurfaceID(), stones[0][1][1].getSurface()[1].getSurfaceID(),
                stones[0][1][0].getSurface()[1].getSurfaceID(), stones[0][1][0].getSurface()[0].getSurfaceID(),
                stones[1][1][0].getSurface()[0].getSurfaceID(), stones[2][1][0].getSurface()[0].getSurfaceID(),
                stones[2][1][0].getSurface()[2].getSurfaceID(), stones[2][1][1].getSurface()[2].getSurfaceID(),
                stones[2][1][2].getSurface()[2].getSurfaceID(), stones[2][1][2].getSurface()[3].getSurfaceID(),
                stones[1][1][2].getSurface()[3].getSurfaceID(), stones[0][1][2].getSurface()[3].getSurfaceID());
        System.out.printf("L----+----+----L   V----+----+----V   R----+----+----R   H----+----+----H\n");
        System.out.printf("L %2d | %2d | %2d L   V %2d | %2d | %2d V   R %2d | %2d | %2d R   H %2d | %2d | %2d H\n",
                stones[0][0][2].getStoneID(), stones[0][0][1].getStoneID(), stones[0][0][0].getStoneID(),
                stones[0][0][0].getStoneID(), stones[1][0][0].getStoneID(), stones[2][0][0].getStoneID(),
                stones[2][0][0].getStoneID(), stones[2][0][1].getStoneID(), stones[2][0][2].getStoneID(),
                stones[2][0][2].getStoneID(), stones[1][0][2].getStoneID(), stones[0][0][2].getStoneID());
        System.out.printf("L %2S | %2S | %2S L   V %2S | %2S | %2S V   R %2S | %2S | %2S R   H %2S | %2S | %2S H\n",
                stones[0][0][2].getSurface()[1].getAlignment(), stones[0][0][1].getSurface()[1].getAlignment(),
                stones[0][0][0].getSurface()[1].getAlignment(), stones[0][0][0].getSurface()[0].getAlignment(),
                stones[1][0][0].getSurface()[0].getAlignment(), stones[2][0][0].getSurface()[0].getAlignment(),
                stones[2][0][0].getSurface()[2].getAlignment(), stones[2][0][1].getSurface()[2].getAlignment(),
                stones[2][0][2].getSurface()[2].getAlignment(), stones[2][0][2].getSurface()[3].getAlignment(),
                stones[1][0][2].getSurface()[3].getAlignment(), stones[0][0][2].getSurface()[3].getAlignment());
        System.out.printf("L %2d | %2d | %2d L   V %2d | %2d | %2d V   R %2d | %2d | %2d R   H %2d | %2d | %2d H\n",
                stones[0][0][2].getSurface()[1].getSurfaceID(), stones[0][0][1].getSurface()[1].getSurfaceID(),
                stones[0][0][0].getSurface()[1].getSurfaceID(), stones[0][0][0].getSurface()[0].getSurfaceID(),
                stones[1][0][0].getSurface()[0].getSurfaceID(), stones[2][0][0].getSurface()[0].getSurfaceID(),
                stones[2][0][0].getSurface()[2].getSurfaceID(), stones[2][0][1].getSurface()[2].getSurfaceID(),
                stones[2][0][2].getSurface()[2].getSurfaceID(), stones[2][0][2].getSurface()[3].getSurfaceID(),
                stones[1][0][2].getSurface()[3].getSurfaceID(), stones[0][0][2].getSurface()[3].getSurfaceID());
        System.out.printf("LLLLLLLLLLLLLLLL   VVVVVVVVVVVVVVVV   RRRRRRRRRRRRRRRR   HHHHHHHHHHHHHHHH\n\n\n");
        System.out.printf("                   UUUUUUUUUUUUUUUU\n");
        System.out.printf("                   U %2d | %2d | %2d U\n", stones[0][0][0].getStoneID(),
                stones[1][0][0].getStoneID(), stones[2][0][0].getStoneID());
        System.out.printf("                   U %2S | %2S | %2S U\n", stones[0][0][0].getSurface()[5].getAlignment(),
                stones[1][0][0].getSurface()[5].getAlignment(), stones[2][0][0].getSurface()[5].getAlignment());
        System.out.printf("                   U %2d | %2d | %2d U\n", stones[0][0][0].getSurface()[5].getSurfaceID(),
                stones[1][0][0].getSurface()[5].getSurfaceID(), stones[2][0][0].getSurface()[5].getSurfaceID());
        System.out.printf("                   U----+----+----U\n");
        System.out.printf("                   U %2d | %2d | %2d U\n", stones[0][0][1].getStoneID(),
                stones[1][0][1].getStoneID(), stones[2][0][1].getStoneID());
        System.out.printf("                   U %2S | %2S | %2S U\n", stones[0][0][1].getSurface()[5].getAlignment(),
                stones[1][0][1].getSurface()[5].getAlignment(), stones[2][0][1].getSurface()[5].getAlignment());
        System.out.printf("                   U %2d | %2d | %2d U\n", stones[0][0][1].getSurface()[5].getSurfaceID(),
                stones[1][0][1].getSurface()[5].getSurfaceID(), stones[2][0][1].getSurface()[5].getSurfaceID());
        System.out.printf("                   U----+----+----U\n");
        System.out.printf("                   U %2d | %2d | %2d U\n", stones[0][0][2].getStoneID(),
                stones[1][0][2].getStoneID(), stones[2][0][2].getStoneID());
        System.out.printf("                   U %2S | %2S | %2S U\n", stones[0][0][2].getSurface()[5].getAlignment(),
                stones[1][0][2].getSurface()[5].getAlignment(), stones[2][0][2].getSurface()[5].getAlignment());
        System.out.printf("                   U %2d | %2d | %2d U\n", stones[0][0][2].getSurface()[5].getSurfaceID(),
                stones[1][0][2].getSurface()[5].getSurfaceID(), stones[2][0][2].getSurface()[5].getSurfaceID());
        System.out.printf("                   UUUUUUUUUUUUUUUU\n");
    }// printCube
}// Cube