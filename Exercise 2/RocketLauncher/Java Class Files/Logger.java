// Logger class to handle logging to a file

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.

public class Logger {
    private BufferedWriter writer;

    // Constructor to initialize the logger
    public Logger(String filePath) {
        try {
            writer = new BufferedWriter(new FileWriter(filePath, true)); // Append mode
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    // Method to log a message
    public void log(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush(); // Ensure the message is written immediately
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }

    // Method to close the logger
    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing logger: " + e.getMessage());
        }
    }
}
