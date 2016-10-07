package parser;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class TxtReader {
    private String path;

    public TxtReader(String file_path){
        path = file_path;
    }

    public List<List<String>> readFile() throws IOException{
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        boolean counter = false;

        List<String> oneScenario = new ArrayList<>();
        List<List<String>> allScenarios = new ArrayList<>();

        while((line = bufferedReader.readLine())!= null){
            boolean newScenario = line.trim().split(" ", 2)[0].equals("Scenario");

            if(newScenario && !counter){
                //first scenario in the list was found
                oneScenario.add(line);
                counter = true;
            }
            else if(!newScenario && counter){
                //adding lines to the current scenario
                oneScenario.add(line);
            }
            else if(newScenario && counter){
                //save full current scenario to the list and clear current scenario to save the next
                allScenarios.add(oneScenario);
                oneScenario = new ArrayList<>();
                oneScenario.add(line);
            }
        }
        allScenarios.add(oneScenario);

        bufferedReader.close();

        return allScenarios;
    }

    //этот способ наверное получше:
    // 1) читается весь файл в строку
    // 2) строка парсится регуляркой
    // пока не смог подобрать нормальную регулярку, приходется использовать г%вно-метод выше
    public List<documentObject> readFullFile() throws IOException{
        String text = new String(readAllBytes(get(path)));
        return null;
    }
}
