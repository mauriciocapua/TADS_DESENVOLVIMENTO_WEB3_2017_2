package cobaia1server;

public class ServerProxy implements cobaia1server.Server {
  private String _endpoint = null;
  private cobaia1server.Server server = null;
  
  public ServerProxy() {
    _initServerProxy();
  }
  
  public ServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initServerProxy();
  }
  
  private void _initServerProxy() {
    try {
      server = (new cobaia1server.ServerServiceLocator()).getServerPort();
      if (server != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)server)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)server)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (server != null)
      ((javax.xml.rpc.Stub)server)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cobaia1server.Server getServer() {
    if (server == null)
      _initServerProxy();
    return server;
  }
  
  public java.lang.String pingPong(java.lang.String text) throws java.rmi.RemoteException{
    if (server == null)
      _initServerProxy();
    return server.pingPong(text);
  }
  
  public java.lang.String[] ping3(java.lang.String text) throws java.rmi.RemoteException{
    if (server == null)
      _initServerProxy();
    return server.ping3(text);
  }
  
  
}