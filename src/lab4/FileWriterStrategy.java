/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;

/**
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
