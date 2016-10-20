
package quiz1.server;

import java.io.IOException;

public interface quiz1int {
    public int addPerson(String name, int age, int height) throws IOException;
    public String[] getFilteredPersonList(String nameContains,
                                            int minAge,
                                            int maxAge,
                                            int minHeight,
                                            int maxHeight);
    public String getAllPersons() throws IOException;    
}
