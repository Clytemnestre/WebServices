
package shoutbox.server;

import java.io.IOException;


public interface shoutboxInt {
    public int addshout (String shout) throws IOException ;
    public String getAllShouts () throws IOException ;
    
}
