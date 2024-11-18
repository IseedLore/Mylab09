package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    
    private static final String PATH = System.getProperty("user.home")
                                        + System.getProperty("file.separator")
                                        + "output.txt";
    File file = new File(PATH);

    public void setFile(File file){
        this.file = file;
    }

    public File getFile(){
        return this.file;
    }
    
    public String getPathFile(){
        return this.file.getPath();
    }

    public void write(String s) throws IOException{
        try(
            PrintStream ps = new PrintStream(getPathFile(), StandardCharsets.UTF_8)) 
            {
                ps.print(s);
            }
    }
}
