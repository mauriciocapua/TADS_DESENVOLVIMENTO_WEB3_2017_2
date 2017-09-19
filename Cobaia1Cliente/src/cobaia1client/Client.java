package cobaia1client;

import java.rmi.RemoteException;

import cobaia1server.*;

public class Client {
	public static void main(String args[]) {
		Server port = new ServerProxy();

		try {
			System.out.println(port.pingPong("hello world"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
