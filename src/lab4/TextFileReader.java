package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark Urbanski
 */
public class TextFileReader {
    private String filePath;


    
    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }
    
    public List<String> readFile() throws IOException{
        List<String> stringsFromFile = new ArrayList<String>();
        BufferedReader inFile = null;
        
        try{
            inFile = new BufferedReader(new FileReader(filePath));
            String line = inFile.readLine();
            while (line != null) {
                stringsFromFile.add(line);                
                line = inFile.readLine();  // strips out any carriage return chars
            }
        }
        catch(IOException ioe) {
            throw ioe;
        }
        finally {
            if(inFile != null) {
                inFile.close();
            }
        }   
        return stringsFromFile;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    
    //Testing code only
    public static void main(String[] args) throws IOException {
        TextFileReader reader = 
                new TextFileReader("src" + File.separatorChar 
                + "test_comma_only.csv");
        List<String> dataStrings = reader.readFile();
        System.out.println(dataStrings);
        for(String s : dataStrings) {
            System.out.println(s);
        }
        
    }
    

}
