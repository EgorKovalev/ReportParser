package parser;

import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String path = "D:/test.txt";

        try{
            TxtReader txtReader = new TxtReader(path);
            List<String> result = txtReader.readFile();

            int size = result.size();
        }
        catch(IOException ex){

        }
    }
}