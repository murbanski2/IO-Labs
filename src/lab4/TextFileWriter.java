package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark Urbanski
 */
class TextFileWriter {
    private String filePath;
    private List<String> stringsToSave;
    private boolean append;
        
    public TextFileWriter(String filePath, List<String> stringsToSave,
            boolean append) {
        this.filePath = filePath;
        this.stringsToSave = stringsToSave;
        this.append = append;
    }
    
    //FileWriter wrapped in a BufferedWriter wrapped in a PrintWriter
    //When append = false, overwrite
    public void writeFile() throws IOException {
        File data = null;
        PrintWriter out = null;
        
        try {
            data = new File(filePath);
            out = new PrintWriter(
                  new BufferedWriter(
                  new FileWriter(data, append)) );
            for(String s : stringsToSave) {
                out.println(s);
            }
        }
        catch(IOException ioe) {
            throw ioe;
        }
        finally{
            if(out != null){
                out.close();
            }
        }
    }
    
    //For testing only
    public static void main(String[] args) throws IOException{
        List<String> outStrings = new ArrayList<String>();
        outStrings.add("This is the first string");
        outStrings.add("This is the second string");
        outStrings.add("Would you believe this is the third string");
        outStrings.add("4");
        String fPath = "src/test.txt";
        TextFileWriter writer = new TextFileWriter(fPath, outStrings, false);
        writer.writeFile();
        TextFileWriter writer2 = new TextFileWriter(fPath, outStrings, true);
        writer2.writeFile();
    }
}
