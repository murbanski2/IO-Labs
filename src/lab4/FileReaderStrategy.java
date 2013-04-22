package lab4;

import java.io.IOException;
import java.util.List;

/**
 * This interface is the contract for all File Reader Strategy implementations.
 * The return type right now is String, though this will change.
 * I am unfamiliar with the generic return type used in the file experiments.
 * 
 * @author Mark Urbanski
 */

public interface FileReaderStrategy {

    String getFilePath();

    List<String> readFile() throws IOException;

    void setFilePath(String filePath);
    
}
