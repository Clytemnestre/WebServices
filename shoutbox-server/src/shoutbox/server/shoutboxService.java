package shoutbox.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class shoutboxService implements shoutboxInt {
    
    private static final String FILE_NAME = "data.txt";

    @Override
    public int addshout(String shout) throws IOException {
        try {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)));
        pw.println(shout);
        pw.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return 0;
    }

    @Override
    public String getAllShouts() throws IOException {
        try {
        // trick scanner into returning the content of he entire text file.
        Scanner scanner = new Scanner(new File(FILE_NAME)).useDelimiter("\u001a");
        return scanner.next();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;            
        }
    }
    
}
