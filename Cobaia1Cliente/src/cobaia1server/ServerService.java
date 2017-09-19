/**
 * ServerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cobaia1server;

public interface ServerService extends javax.xml.rpc.Service {
    public java.lang.String getServerPortAddress();

    public cobaia1server.Server getServerPort() throws javax.xml.rpc.ServiceException;

    public cobaia1server.Server getServerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
