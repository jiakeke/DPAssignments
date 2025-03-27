package singleton.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private String fileName = "default_log.txt";

    private Logger() {
        openFile();
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void openFile() {
        try {
            writer = new PrintWriter(new FileWriter(fileName, true), true);
        } catch (IOException e) {
            System.err.println("Failed to open log file: " + e.getMessage());
        }
    }

    public synchronized void setFileName(String newFileName) {
        if (newFileName.equals(fileName)) return;

        close();
        fileName = newFileName;
        openFile();
    }

    public synchronized void write(String message) {
        if (writer == null) {
            System.err.println("Logger is closed! Reopening...");
            openFile();
        }
        System.out.println("Writing to log: " + message);
        writer.println(message);
    }

    public synchronized void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}
