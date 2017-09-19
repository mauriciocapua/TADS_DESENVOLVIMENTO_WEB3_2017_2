package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.User;

public class UserDAO {

	static public List<User> getAll() {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		List<User> l = new ArrayList<User>();

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres", "123");
			if (c != null) {
				s = c.createStatement();
				rs = s.executeQuery("SELECT * FROM public.user");
				while (rs.next())
					l.add(new User(rs.getInt("id"), rs.getString("login"), rs.getString("senha")));
				rs.close();
				s.close();
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (l);
	}

	static public User getById(int id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User p = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres", "123");
			if (c != null) {
				ps = c.prepareStatement("SELECT * FROM public.user WHERE id = ?");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next())
					p = new User(rs.getInt("id"), rs.getString("login"), rs.getString("senha"));
				rs.close();
				ps.close();
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (p);
	}

	public static User verifyUser(String login, String senha) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User p = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres", "123");
			if (c != null) {
				ps = c.prepareStatement("SELECT * FROM public.user WHERE login = ? and senha = ?");
				ps.setString(1, login);
				ps.setString(2, senha);
				rs = ps.executeQuery();
				if (rs.next())
					p = new User(rs.getInt("id"), rs.getString("login"), rs.getString("senha"));
				rs.close();
				ps.close();
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (p);
	}

}
