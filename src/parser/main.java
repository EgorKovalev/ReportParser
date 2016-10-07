package parser;

import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        try{
            //let's parse txt and get scenarios from the test
            List<List<String>> scenarios = TxtReader.readFile();

            //let's get names from all scenarios
            List<String> names = TxtReader.getNames(scenarios);

            //let's write the names to excel
            ExcelWriter.writeNamesToExcel(names);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch (WriteException e) {
            e.printStackTrace();
        }
    }
}