
package quiz1.server;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;


public class Quiz1Server {

private static final int port = 8282;

    public static void main(String[] args) throws Exception {
        // create web server and XML-RPC server connected to it
        WebServer webServer = new WebServer(port);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        // tell XML-RPC server which classes contain methods to map
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        phm.addHandler("quiz1", quiz1.server.quiz1Service.class);
        xmlRpcServer.setHandlerMapping(phm);

        // set some additional options
        XmlRpcServerConfigImpl serverConfig
                = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();        
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);
        
        // start web server and don't stop
        webServer.start();
    }
    
}
