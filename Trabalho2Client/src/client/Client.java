package client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import server.AdminWS;
import server.AdminWSService;
import server.Exception_Exception;
import server.Recurso;
import server.Token;
import server.User;
import server.UserWS;
import server.UserWSService;
import server.VendasWS;
import server.VendasWSService;

public class Client {
	public static void main(String[] args) {
//		userAction();
		adminAction();
	}

	public static void userAction() {
		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return (new PasswordAuthentication("user", "12345".toCharArray()));
			}
		});

		UserWSService userService = new UserWSService();
		UserWS userServicePort = userService.getUserWSPort();

		VendasWSService vendasService = new VendasWSService();
		VendasWS vendasServicePort = vendasService.getVendasWSPort();

		User user = new User();
		user.setUserid("user");
		user.setPassword("12345");

		Token token = null;
		try {
			token = userServicePort.login("user", "12345").get(0);
			if (vendasServicePort.consultaRecurso("1", "5") != null) {
				Recurso recurso = vendasServicePort.consultaRecurso("2", "5");
				System.out.println(recurso.getDescricao());
				if (vendasServicePort.vendeRecurso(String.valueOf(recurso.getId()), "5",
						String.valueOf(recurso.getVersion())))
					System.out.println("success");
				else
					System.out.println("fail");
			}

		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void adminAction() {
		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return (new PasswordAuthentication("admin", "12345".toCharArray()));
			}
		});

		AdminWSService adminService = new AdminWSService();
		AdminWS adminServicePort = adminService.getAdminWSPort();

		try {
			if (adminServicePort.incluiRecurso("3", "recurso3", "50") != null)
				System.out.println("success");
			else
				System.out.println("fail");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
