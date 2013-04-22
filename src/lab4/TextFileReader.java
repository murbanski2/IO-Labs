package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TextFileReader.java
 * Right now, this reads a text file and returns a list of strings.  It is the
 * user's responsibility to parse the string based on commas, tabs, or whatever
 * other delimiters are being used.  This will change when I have digested
 * the example code better.  A format strategy will be used then.
 * 
 * @author Mark Urbanski
 */
public class TextFileReader implements FileReaderStrategy {
    private String filePath;


    /**
     * public TextFileReader(String filePath)
     * filePath should be a string version of the file path.
     * @param filePath 
     */
    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * public List<String> readFile() throws IOException
     * Reads a text file and returns a list of strings.
     * @return
     * @throws IOException 
     */
    @Override
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

    /**
     * public String getFilePath()
     * Returns the value of filePath.
     * @return 
     */
    @Override
    public String getFilePath() {
        return filePath;
    }

    /**
     * public void setFilePath(String filePath)
     * Allows user to set value of filePath.
     * @param filePath 
     */
    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    
    //Testing code only
    public static void main(String[] args) throws IOException {
        FileReaderStrategy reader = 
                new TextFileReader("src" + File.separatorChar 
                + "test_comma_only.csv");
        List<String> dataStrings = reader.readFile();
        System.out.println(dataStrings);
        for(String s : dataStrings) {
            System.out.println(s);
        }
        
    }
    

}
