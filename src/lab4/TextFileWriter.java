package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * TextFileWriter.java
 * Right now, this takes in file path and a list of strings.  It writes the 
 * strings to the file.  The future version of this will use a format 
 * to merge data into csv or other text formats.
 * 
 * @author Mark Urbanski
 */
class TextFileWriter implements FileWriterStrategy {
    private String filePath;
    private List<String> stringsToSave;
    private boolean append;
        
    /**
     * public TextFileWriter(String filePath, List<String> stringsToSave,
     *       boolean append)
     * Constructor that  sets the values to be used in the rest of the program. 
     * @param filePath
     * @param stringsToSave
     * @param append 
     */
    public TextFileWriter(String filePath, List<String> stringsToSave,
            boolean append) {
        this.filePath = filePath;
        this.stringsToSave = stringsToSave;
        this.append = append;
    }
    
    //FileWriter wrapped in a BufferedWriter wrapped in a PrintWriter
    //When append = false, overwrite
    /**
     * public void writeFile() throws IOException
     * Right now, this takes a list of strings and writes it out
     * to filePath.
     * @throws IOException 
     */
    @Override
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
     * Allows user to set the value of filePath.
     * @param filePath 
     */
    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * public List<String> getStringsToSave()
     * Gets the list of stringsToSave.
     * @return 
     */
    public List<String> getStringsToSave() {
        return stringsToSave;
    }

    /**
     * public void setStringsToSave(List<String> stringsToSave)
     * Sets the value of stringsToSave.
     * @param stringsToSave 
     */
    public void setStringsToSave(List<String> stringsToSave) {
        this.stringsToSave = stringsToSave;
    }

    /**
     * public boolean isAppend()
     * Returns the value of append.  
     * True = append
     * False = overwrite
     * @return 
     */
    @Override
    public boolean isAppend() {
        return append;
    }

    /**
     * public void setAppend(boolean append)
     * Sets the value of append.
     * @param append 
     */
    @Override
    public void setAppend(boolean append) {
        this.append = append;
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
