package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
                out.println();
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
    public static void main(String[] args) {
        
    }
}
