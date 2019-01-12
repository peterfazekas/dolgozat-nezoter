package nezoter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {

    private final String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void printAll(String text) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
