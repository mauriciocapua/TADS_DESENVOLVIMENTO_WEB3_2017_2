package cobaia3client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import cobaia3server.*;

public class Client {

	public static void main(String[] args) {

		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return(new PasswordAuthentication("user", "12345".toCharArray()));
			}
		});

		
		AuthenticationWSService service = new AuthenticationWSService();
		AuthenticationWS port = service.getAuthenticationWSPort();

		System.out.println(port.authenticate());
	}

}