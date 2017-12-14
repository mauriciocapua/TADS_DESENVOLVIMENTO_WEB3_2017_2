package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import negocio.Dado;
import negocio.User;
import javax.sql.DataSource;

public class UserDAO {

	private DataSource dataSource = null;

	public UserDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Boolean validateUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Boolean verification = false;

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?");
				preparedStatement.setInt(1, user.getId());
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					verification = true;
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (verification);
	}

	public List<User> getAll() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<User> l = new ArrayList<User>();

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM usuario");
				while (resultSet.next())
					l.add(new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"),
							resultSet.getInt("version")));
				resultSet.close();
				statement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (l);
	}

	public User getById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User p = null;

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?");
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					p = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"),
							resultSet.getInt("version"));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (p);
	}

	public User verifyUser(String login, String senha) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User p = null;

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
				preparedStatement.setString(1, login);
				preparedStatement.setString(2, senha);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					p = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"),
							resultSet.getInt("version"));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (p);
	}

	public User user(User user) {
		Connection connection = null;
		PreparedStatement preparedStatementSelect = null;
		PreparedStatement preparedStatementUpdate = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			String select = "SELECT * FROM usuario WHERE id = ? and version=?;";
			String update = "update dado set version=version+1 WHERE id = ? and version=?;";

			if (connection != null) {

				preparedStatementSelect = connection.prepareStatement(select);
				preparedStatementSelect.setInt(1, user.getId());
				preparedStatementSelect.setInt(1, user.getVersion());

				preparedStatementUpdate = connection.prepareStatement(update);
				preparedStatementUpdate.setInt(1, user.getId());

				resultSet = preparedStatementSelect.executeQuery();
				if (resultSet.next())
					user = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("senha"),
							resultSet.getInt("version"));

				preparedStatementUpdate.executeUpdate();

				connection.commit();
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (user);
	}

}
