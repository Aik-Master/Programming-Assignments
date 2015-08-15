package cube;

import java.util.ArrayList;

public class TestFrame{

    public static void main(String[] args){

        Cube cube = new Cube();
        cube.printCube();

        cube.rotate(new byte[]{11});
        cube.printCube();
        cube.rotate(new byte[]{12});
        cube.printCube();
        cube.rotate(new byte[]{13});
        cube.printCube();
        cube.rotate(new byte[]{14});
        cube.printCube();
        cube.rotate(new byte[]{15});
        cube.printCube();
        cube.rotate(new byte[]{16});
        cube.printCube();
        cube.rotate(new byte[]{17});
        cube.printCube();
        cube.rotate(new byte[]{18});
        cube.printCube();
        cube.rotate(new byte[]{19});
        cube.printCube();
        cube.rotate(new byte[]{41, 41});
        cube.printCube();
        cube.rotate(new byte[]{42});
        cube.printCube();

        cube.rotate(new byte[]{17});
        cube.printCube();

        cube.rotate(new byte[]{12, 18, 15, 17});
        cube.printCube();

        cube.rotate(new byte[]{11});
        cube.printCube();
        cube.rotate(new byte[]{0});
        cube.printCube();

        testCube(cube, 100000);

    }

    static ArrayList<Byte> genTestSeq(int n){
        ArrayList<Byte> resu = new ArrayList<Byte>();
        for(int i = 0 ; i < n ; i++)
            resu.add((byte) ((10 * (1 + (int) (2 * Math.random()))) + (1 + (int) (9 * Math.random()))));
        return resu;
    }// genTestSeq

    static ArrayList<Byte> genRevTestSeq(ArrayList<Byte> ots){
        byte omov; // Original MOVe
        ArrayList<Byte> resu = new ArrayList<Byte>();
        for(int i = ots.size() - 1 ; i >= 0 ; i--){
            omov = ots.get(i);
            if(i % 13 != 0){
                resu.add((byte) (10 * (4 - omov / 10) + omov % 10));
            } else{
                int z = omov % 10;
                int a = (omov / 10) * 10;
                switch(z){
                    case 1:
                    case 2:
                    case 3:
                        switch(z){
                            case 1:
                                resu.add((byte) (a + 2));
                                resu.add((byte) (a + 3));
                                break;
                            case 2:
                                resu.add((byte) (a + 1));
                                resu.add((byte) (a + 3));
                                break;
                            case 3:
                                resu.add((byte) (a + 1));
                                resu.add((byte) (a + 2));
                                break;
                        }// switch
                        switch(a){
                            case 10:
                                resu.add((byte) 48);
                                resu.add((byte) 45);
                                resu.add((byte) 41);
                                break;
                            case 20:
                                resu.add((byte) 45);
                                resu.add((byte) 48);
                                break;
                            case 30:
                                resu.add((byte) 41);
                                break;
                        }// switch
                        break;

                    case 4:
                    case 5:
                    case 6:
                        switch(z){
                            case 4:
                                resu.add((byte) (a + 5));
                                resu.add((byte) (a + 6));
                                break;
                            case 5:
                                resu.add((byte) (a + 4));
                                resu.add((byte) (a + 6));
                                break;
                            case 6:
                                resu.add((byte) (a + 4));
                                resu.add((byte) (a + 5));
                                break;
                        }// switch
                        switch(a){
                            case 10:
                                resu.add((byte) 48);
                                resu.add((byte) 42);
                                resu.add((byte) 44);
                                break;
                            case 20:
                                resu.add((byte) 42);
                                resu.add((byte) 48);
                                break;
                            case 30:
                                resu.add((byte) 44);
                                break;
                        }// switch
                        break;

                    case 7:
                    case 8:
                    case 9:
                        switch(z){
                            case 7:
                                resu.add((byte) (a + 8));
                                resu.add((byte) (a + 9));
                                break;
                            case 8:
                                resu.add((byte) (a + 7));
                                resu.add((byte) (a + 9));
                                break;
                            case 9:
                                resu.add((byte) (a + 7));
                                resu.add((byte) (a + 8));
                                break;
                        }// switch
                        switch(a){
                            case 10:
                                resu.add((byte) 42);
                                resu.add((byte) 45);
                                resu.add((byte) 47);
                                break;
                            case 20:
                                resu.add((byte) 45);
                                resu.add((byte) 42);
                                break;
                            case 30:
                                resu.add((byte) 47);
                                break;
                        }// switch
                        break;
                }// switch
            }// if
        }// for
        return resu;
    }// genRecTestSeq

    static void testCube(Cube cube, int n){
        ArrayList<Byte> testSeq;
        System.out.printf("\n################################################################################\n\n");
        System.out.printf("Test 0:\n=======\n\n\n");
        cube.printCube(); // Ausgabe des Würfels
        System.out.printf("\n--------------------------------------------------------------------------------\n\n");
        System.out.printf("Test 1:\n=======\n\n\n");
        testSeq = genTestSeq(n);
        cube.rotate((testSeq));
        cube.printCube(); // Ausgabe des Würfels
        System.out.printf("\n--------------------------------------------------------------------------------\n\n");
        System.out.printf("Test 2:\n=======\n\n\n");
        testSeq = genRevTestSeq(testSeq);
        cube.rotate((testSeq));
        cube.printCube(); // Ausgabe des Würfels
        System.out.printf("\n################################################################################\n\n");
    }// testCube

}
