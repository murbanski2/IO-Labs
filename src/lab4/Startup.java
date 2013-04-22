package lab4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark Urbanski
 */
public class Startup {
    public static void main(String[] args) throws IOException {
        FileReaderStrategy strategyReader = new TextFileReader("src" + File.separatorChar 
                + "test_comma_only.csv");
        MTUFileService reader = new MTUFileService(strategyReader);
        List<String> dataStrings = reader.readFile();
        System.out.println(dataStrings);
        for(String s : dataStrings) {
            System.out.println(s);
        }    
        
        
        List<String> outStrings = new ArrayList<String>();
        outStrings.add("This is the first string");
        outStrings.add("This is the second string");
        outStrings.add("Would you believe this is the third string");

        String fPath = "src/test2.txt";
        FileWriterStrategy strategyWriter 
                = new TextFileWriter(fPath, outStrings, false);
        MTUFileService writer = new MTUFileService(strategyWriter);
        writer.writeFile();
        outStrings.add("This was added after the first 3 were written");
        TextFileWriter writer2 = new TextFileWriter(fPath, outStrings, true);
        writer2.writeFile();
            
    }
}
