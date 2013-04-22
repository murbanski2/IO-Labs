package lab4;

import java.io.IOException;

/**
 * This interface is the contract for all File Writer Strategy implementations.
 *  
 * @author Mark Urbanski
 */
public interface FileWriterStrategy {

    String getFilePath();

    boolean isAppend();

    void setAppend(boolean append);

    void setFilePath(String filePath);

    void writeFile() throws IOException;
    
}
