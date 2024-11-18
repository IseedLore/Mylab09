package it.unibo.mvc;

import java.io.File;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private static final String PATH = System.getProperty("user.home")
                                        + System.getProperty("file.separator")
                                        + "output.txt";
    File file = new File(PATH);

    @Override
    public String getPathFile() {
        return file.getPath();
    }

    @Override
    public void read() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void write() {
        // TODO Auto-generated method stub
        
    }
    public void setStringToPrint(String s){

    }

    
}
