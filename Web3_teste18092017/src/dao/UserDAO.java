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
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<User> l = new ArrayList<User>();

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres", "123");
			if (connection != null) {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM usuario");
				while (resultSet.next())
					l.add(new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha")));
				resultSet.close();
				statement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (l);
	}

	static public User getById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User p = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres", "123");
			if (connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?");
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					p = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (p);
	}

	public static User verifyUser(String login, String senha) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User p = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres", "123");
			if (connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
				preparedStatement.setString(1, login);
				preparedStatement.setString(2, senha);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					p = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (p);
	}

}
