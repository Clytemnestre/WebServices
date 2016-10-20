
package quiz1.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class quiz1Service implements quiz1int {
    
    private static final String FILE_NAME = "data.txt";

    @Override
    public int addPerson(String name, int age, int height) throws IOException {
        System.out.println("called addPerson()");
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {
            String person = String.format("%s;%d;%d", name, age, height);
            pw.println(person);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return 0;
    }

    @Override
    public String[] getFilteredPersonList(String nameContains, int minAge, int maxAge, int minHeight, int maxHeight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAllPersons() throws IOException {
        System.out.println("called getAllPersons()");
        return "";
    }


}
