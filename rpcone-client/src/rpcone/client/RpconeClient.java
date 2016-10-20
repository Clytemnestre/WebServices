/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpcone.client;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

/**
 *
 * @author ipd
 */
public class RpconeClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        // client set up

        // make a call
        Object[] params = new Object[]{new Integer(2), new Integer(3)};
        Integer result = (Integer) client.execute("Calculator.add", params);
        //
        System.out.print("Result is " + result);
        // Echo call:
        Object[] params2 = new Object [] {"I am here"};
        String result2 = (String) client.execute("Echo.echo", params2);
        //
        System.out.print("Result2 is: " + result2);
    }

}
