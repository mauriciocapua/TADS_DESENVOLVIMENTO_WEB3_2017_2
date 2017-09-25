package exercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

		static public User getByLogin(String login) {
			Connection c = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			User u = null;

			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection("jdbc:postgresql://localhost/exercicio1", "postgres", "");
				if (c != null) {
					ps = c.prepareStatement("SELECT * FROM users WHERE login = ?");
					ps.setString(1, login);
					rs = ps.executeQuery();
					if (rs.next())
						u = new User(rs.getString("login"), rs.getString("senha"));
					rs.close();
					ps.close();
				}
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return (u);
		}
	
}
