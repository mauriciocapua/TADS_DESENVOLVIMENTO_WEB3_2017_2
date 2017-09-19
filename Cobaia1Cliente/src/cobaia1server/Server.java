/**
 * Server.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cobaia1server;

public interface Server extends java.rmi.Remote {
    public java.lang.String pingPong(java.lang.String text) throws java.rmi.RemoteException;
    public java.lang.String[] ping3(java.lang.String text) throws java.rmi.RemoteException;
}
