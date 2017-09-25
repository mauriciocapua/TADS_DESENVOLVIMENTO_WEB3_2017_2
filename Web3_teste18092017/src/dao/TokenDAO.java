package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import negocio.Token;
import negocio.User;

public class TokenDAO {

	static public List<Token> getValidToken(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Token> tokens = new ArrayList<Token>();

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres",
					"123");
			if (connection != null) {
				preparedStatement = connection.prepareStatement(
						"select * from token where login = ? and status = true and now() >= criacao and now() <= validade");
				preparedStatement.setString(1, user.getLogin());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next())
					tokens.add(new Token(resultSet.getInt("id"), resultSet.getString("login"),
							resultSet.getBoolean("status"), resultSet.getTimestamp("validade"),
							resultSet.getTimestamp("criacao")));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (tokens);
	}

	public static Token createToken(User user, Token token) throws ClassNotFoundException, SQLException {
		/*
		 * Connection connection = null; PreparedStatement preparedStatement = null;
		 * ResultSet resultSet = null; Token token = null;
		 * 
		 * try { Class.forName("org.postgresql.Driver"); connection =
		 * DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017",
		 * "postgres", "123"); if (connection != null) { preparedStatement =
		 * connection.prepareStatement(
		 * "select * from token where login = ? and status = true and now() >= criacao and now() <= validade"
		 * ); preparedStatement.setString(1, user.getLogin()); resultSet =
		 * preparedStatement.executeQuery(); while (resultSet.next()) token.add(new
		 * Token(resultSet.getInt("id"), resultSet.getString("login"),
		 * resultSet.getBoolean("status"), resultSet.getTimestamp("validade"),
		 * resultSet.getTimestamp("criacao"))); resultSet.close();
		 * preparedStatement.close(); } connection.close(); } catch (SQLException e) {
		 * throw e; } return (token);
		 */
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "insert into token (login, status, criacao, validade) values (?,?,?,?) returning id";
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres",
					"123");
			if (connection != null) {

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, token.getLogin());
				preparedStatement.setBoolean(2, token.getStatus());
				preparedStatement.setTimestamp(3, new Timestamp(token.getCriacao().getTime()));
				preparedStatement.setTimestamp(4, new Timestamp(token.getValidade().getTime()));

				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					token.setId(resultSet.getInt("id"));
				}

				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (SQLException e) {
			throw e;
		}
		return token;
	}

}
