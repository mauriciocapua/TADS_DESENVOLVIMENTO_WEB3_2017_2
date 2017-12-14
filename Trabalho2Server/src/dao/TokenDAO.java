package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import negocio.Token;
import negocio.User;

public class TokenDAO {

	private DataSource dataSource = null;

	public TokenDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Boolean validateToken(Token token) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Boolean verification = false;

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM token WHERE id = ?");
				preparedStatement.setInt(1, token.getId());
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

	public Boolean disableToken(Token token) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Boolean verification = false;

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("update token set status=false WHERE id = ?");
				preparedStatement.setInt(1, token.getId());
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

	public List<Token> getValidToken(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Token> tokens = new ArrayList<Token>();
		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(
						"select * from token where userid = ? and status = true and now() >= criacao and now() <= validade");
				preparedStatement.setString(1, user.getUserid());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next())
					tokens.add(new Token(resultSet.getInt("id"), resultSet.getString("userid"),
							resultSet.getBoolean("status"),
							resultSet.getTimestamp("validade"),
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

	public Token createToken(User user, Token token) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "insert into token (userid, status, criacao, validade) values (?,?,?,?) returning id";
		try {
			connection = dataSource.getConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, token.getLogin());
				preparedStatement.setBoolean(2, token.isStatus());
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
