/** 
 * <b>Header</b>
 * Praktikum     P2P
 * Semester      SoSe13
 * Team          S1T1
 * Aufgabe       A3
 * Kontrolleur   Behnke
 * Datum         22.05.13
 * Quellen       /
 * @author       Klostermann, Aiko: 2125565
 */

package fileAnallysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAnalysisLogic{

    private String     path = "C:\\";
    private int        nod  = 1;                               // Number of Directories
    private int        nof  = 1;                               // Number of Files
    private FileSize[] sizesF;
    private FileSize[] sizesD;
    private int        fileCouter;
    private int        directoryCounter;

    public FileAnalysisLogic(){
        fileCouter = 0;
        directoryCounter = 0;
    }// Constructor

    public void analyse(){
        sizesD = new FileSize[nod];
        sizesF = new FileSize[nof];
        initArrays(sizesD, nod);
        initArrays(sizesF, nof);

        sizeRecursion(new File(path));
        try{
            save2File();
        } catch(IOException e){
            e.printStackTrace();
        }// try2 save
    }// analyse()

    public long sizeRecursion(File directory){
        long folderSize = 0;
        String folderPath = directory.getAbsolutePath();
        if(directory.listFiles() == null)
            System.out.println("unable to analyse: " + directory.getAbsolutePath());
        else{
            for(File file : directory.listFiles()){
                if(file.isFile()){
                    add2ArrayIfBigEnough(file.length(), file.getAbsolutePath(), sizesF, nof);
                    folderSize += file.length();
                    fileCouter++;
                } else{
                    folderSize += sizeRecursion(file);
                    directoryCounter++;
                }// if isFile
            }//for each File
        }//if unable to read
        add2ArrayIfBigEnough(folderSize, folderPath, sizesD, nod);
        return folderSize;
    }// sizeRecursion()

    private void add2ArrayIfBigEnough(long size, String path, FileSize[] sizes, int no){
        FileSize tmp[] = null;
        if(size > sizes[no - 1].getSize()){
            FileSize fileSize = new FileSize(size, path);
            tmp = new FileSize[no];
            for(int i = 0 ; i < no ; i++){
                if(sizes[i].getSize() < size){
                    System.arraycopy(sizes, i, tmp, 0, no - (i + 1));
                    sizes[i] = fileSize;
                    System.arraycopy(tmp, 0, sizes, i + 1, no - (i + 1));
                    break;
                }// if right spot found
            }// for i<no
        }// if big enough
    }// add2ArrayIfBigEnough()

    private void save2File() throws IOException{
        FileWriter fstream = null;
        BufferedWriter out = null;
        try{
            fstream = new FileWriter("C:\\Users\\Dieter\\Desktop\\a3_out.txt");
            out = new BufferedWriter(fstream);

            out.write("Analysing:" + path);
            out.newLine();
            out.newLine();
            out.newLine();
            out.write("The Top " + nof + " Files");
            writeHead(out);
            writeBody(out, nof, sizesF);
            out.newLine();
            out.write("The Top " + nod + " Directories");
            writeHead(out);
            writeBody(out, nod, sizesD);
            out.newLine();

            out.write(fileCouter + " Files and " + directoryCounter + " Directories analysed");

            out.close();
            fstream.close();
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            out.close(); // throws IOException
            fstream.close();// throws IOException
        }// try2 open/close stream 
    }// save2File()

    private void writeBody(BufferedWriter out, int no, FileSize[] sizes) throws IOException{
        for(int i = 0 ; i < no ; i++){
            if(sizes[i].getSize() != 0){
                out.write(String.format("%27d", sizes[i].getSize()));
                out.write(" ");
                out.write(" " + sizes[i].getPath());
                out.newLine();
            }// if there is any data to be printed
        }// for i < no
    }// writeBody()

    private void writeHead(BufferedWriter out) throws IOException{
        out.newLine();
        out.write("===========================");
        out.newLine();
        out.write("  Y  Z");
        out.newLine();
        out.write("  o  e     P  T  G  M  K  B");
        out.newLine();
        out.write("  t  t  E  e  e  i  e  i  y");
        out.newLine();
        out.write("  t  t  x  t  r  g  g  L  t");
        out.newLine();
        out.write("  a..a..a..a..a..a..a..o..e");
        out.newLine();
    }// writeHead()

    private void initArrays(FileSize[] sizes, int no){
        for(int i = 0 ; i < no ; i++){
            sizes[i] = new FileSize(0, null);
        } // for
    }// initArrays()

    // vvvvv only setter following vvvvv
    public void setPath(String path){
        this.path = path;
    }

    public void setNOF(int nof){
        this.nof = nof;
    }

    public void setNOD(int nod){
        this.nod = nod;
    }
}