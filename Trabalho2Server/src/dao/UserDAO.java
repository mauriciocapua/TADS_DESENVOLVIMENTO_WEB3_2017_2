package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import negocio.User;

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
				preparedStatement = connection.prepareStatement("SELECT * FROM usertable WHERE userid = ?");
				preparedStatement.setString(1, user.getUserid());
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
				resultSet = statement.executeQuery("SELECT * FROM usertable");
				while (resultSet.next())
					l.add(new User(resultSet.getString("userid"), resultSet.getString("password")));
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
				preparedStatement = connection.prepareStatement("SELECT * FROM usertable WHERE userid = ?");
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					p = new User(resultSet.getString("userid"), resultSet.getString("password"));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (p);
	}

	public User verifyUser(String userid, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User p = null;

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("SELECT * FROM usertable WHERE userid = ? and password = ?");
				preparedStatement.setString(1, userid);
				preparedStatement.setString(2, password);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					p = new User(resultSet.getString("userid"), resultSet.getString("password"));
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
