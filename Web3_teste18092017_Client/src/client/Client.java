package client;

import java.util.List;

import server.*;

public class Client {
	public static void main(String[] args) {

		UserWSService service = new UserWSService();
		UserWS port = service.getUserWSPort();

		List<User> lista = port.listAll(); 
		
		for (User item : lista) {
			System.out.println(item.getLogin());
		}
		
	}
}
