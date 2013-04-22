package lab4;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Mark Urbanski
 */
public class MTUFileService {
    FileReaderStrategy reader;
    FileWriterStrategy writer;
    
    /**
     * public MTUFileService(FileReaderStrategy reader)
     * Constructor to create a reader.
     * @param reader 
     */
    public MTUFileService(FileReaderStrategy reader) {
        this.reader = reader;
    }
    
    /**
     * public MTUFileService(FileWriterStrategy writer)
     * Constructor to create a writer.
     * @param writer 
     */
    public MTUFileService(FileWriterStrategy writer) {
        this.writer = writer;
    }
    
    public List<String> readFile() throws IOException {
        return reader.readFile();
    }
    
    public void writeFile() throws IOException {
        writer.writeFile();
    }
}
