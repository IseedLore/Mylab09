package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

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
        return file;
    }
    
    public Path getPathFile(){
        return file.toPath();
    }

    public void write(String s) throws IOException{
        try(
            PrintStream ps = new PrintStream(PATH, StandardCharsets.UTF_8)) 
            {
                ps.print(s);
            }
    }
}
