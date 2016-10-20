
package quiz1.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import quiz1.server.quiz1int;

public class quiz1Proxy implements quiz1int {
    private XmlRpcClient rpc;
    public static final String SERVER_ENDPOINT = "http://127.0.0.1:8282/XmlRpcServlet";   

    quiz1Proxy() throws MalformedURLException {
        // client setup 
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(SERVER_ENDPOINT));
        // instatiate client
        rpc = new XmlRpcClient();
        rpc.setTransportFactory(new XmlRpcCommonsTransportFactory(rpc));
        rpc.setConfig(config);
    }

    @Override
    public int addPerson(String name, int age, int height) throws IOException {
                try {
           Object[] params = new Object[]{ name, age, height};
           return (Integer) rpc.execute("quiz1.addPerson", params);
        } catch (XmlRpcException ex) {
            throw new IOException(ex);           
        }
    }

    @Override
    public String[] getFilteredPersonList(String nameContains, int minAge, int maxAge, int minHeight, int maxHeight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAllPersons() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
