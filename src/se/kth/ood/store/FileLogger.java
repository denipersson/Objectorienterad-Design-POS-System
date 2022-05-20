package se.kth.ood.store;

import java.io.FileWriter; import java.io.IOException;
import java.io.PrintWriter;
/**
 * CODE FOR THIS CLASS RE-USED FROM COURSEBOOK
 * Prints log messages to a file. The log file will be in the
 * current directory and will be called log.txt.
 */
public class FileLogger {
    private PrintWriter logStream;
    /**
     * Creates a new instance and also creates a new log file.
     * An existing log file will be deleted.
     */
    public FileLogger() { try {
        logStream = new PrintWriter(
                new FileWriter("log.txt"), true);

    } catch (IOException ioe) { System.out.println("CAN NOT LOG."); ioe.printStackTrace();
    } }
    /**
     * Prints the specified string to the log file.
     *
     * @param message The string that will be printed to the
     *
    log file.
     */
    public void log(String message) { logStream.println(message);
    } }