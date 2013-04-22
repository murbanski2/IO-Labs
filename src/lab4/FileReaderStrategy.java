package lab4;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Mark Urbanski
 */
public interface FileReaderStrategy {

    String getFilePath();

    List<String> readFile() throws IOException;

    void setFilePath(String filePath);
    
}
