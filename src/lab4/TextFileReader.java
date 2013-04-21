package lab4;

import java.io.BufferedReader;
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
                String str[] = line.split("_");
                if (str.length >=8) {
                    setContact(str);
                    System.out.println(contact.toString());
                }
                else{
                    System.out.println("Input line did not have enough fields");
                }
                //outputRecord(str);
                line = in.readLine();  // strips out any carriage return chars
            }
        }
        catch(IOException ioe) {
            throw ioe;
        }
        finally {
            
        }   
        return stringsFromFile;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    

}
