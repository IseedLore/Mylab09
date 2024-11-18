package it.unibo.mvc;

import java.io.IOException;

/**
 *
 */
public interface Controller {

    void write() throws IOException;
    void read() throws IOException;
    String getPathFile();
}
