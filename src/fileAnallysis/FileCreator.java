package fileAnallysis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator{

    public static void main(String[] args){

        FileWriter fstream = null;
        BufferedWriter out = null;

        try{
            fstream = new FileWriter("C:\\Users\\Aiko\\Desktop\\groﬂ.txt");
            out = new BufferedWriter(fstream);
            for(long i = 0 ; i < 1_000_000 ; i++){
                out.write("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789_");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        try{
            out.close();
            fstream.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}