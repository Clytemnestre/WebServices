/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoutbox.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import shoutbox.server.shoutboxInt;

/**
 *
 * @author ipd
 */
public class ShoutboxProxy implements shoutboxInt {
    
    private XmlRpcClient rpc;
    public static final String SERVER_ENDPOINT = "http://127.0.0.1:8181/XmlRpcServlet";
    // constructor
    ShoutboxProxy() throws MalformedURLException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://127.0.0.1:8080/XmlRpcServlet"));
        // instatiate client
        XmlRpcClient client = new XmlRpcClient();
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        client.setConfig(config);
    }

    @Override
    public int addshout(String shout) throws IOException {
        Object[] params1 = new Object[]{shout};
        return (Integer) rpc.execute("Shout.addshout", params1)
    }

    @Override
    public String getAllShouts() throws IOException {
        
    }

}
