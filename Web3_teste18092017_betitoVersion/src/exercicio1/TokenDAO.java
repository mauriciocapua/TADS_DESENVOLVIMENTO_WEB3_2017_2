package exercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TokenDAO {

		static public int getTokensValidosNaoUsados(String login) {
			Connection c = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int resultado = 0;
			
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection("jdbc:postgresql://localhost/exercicio1", "postgres", "");
				if (c != null) {
					ps = c.prepareStatement("SELECT * FROM token WHERE login = ? AND status = true AND criacao >= NOW() AND NOW() < validade");
					ps.setString(1, login);
					rs = ps.executeQuery();
					if (rs.next())
						resultado = 1;
					rs.close();
					ps.close();
				}
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return (resultado);
		}
	
}
