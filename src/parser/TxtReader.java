package parser;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {
    private String path;

    public TxtReader(String file_path){
        path = file_path;
    }

    public List<String> readFile() throws IOException{
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String aLine;
        List<String> textData = new ArrayList<>();

        while((aLine = bufferedReader.readLine())!= null){
            textData.add(aLine);
        }

        bufferedReader.close();
        return textData;
    }
}
