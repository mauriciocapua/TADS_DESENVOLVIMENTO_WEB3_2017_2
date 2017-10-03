package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocio.Dado;
import negocio.Token;
import negocio.User;
import javax.sql.DataSource;

public class DadoDAO {

	private DataSource dataSource = null;

	public DadoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Dado getDado(User user, Token token) {
		Connection connection = null;
		PreparedStatement preparedStatementSelect = null;
		PreparedStatement preparedStatementUpdate = null;
		ResultSet resultSet = null;
		Dado dado = null;

		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			// String query = "BEGIN TRANSACTION;";
			String select = "";
			String update = "";
			select = "SELECT * FROM dado WHERE userid = ?;";
			update = "update dado set numero=numero+1 WHERE userid = ?;";
			// query += "COMMIT;";
			if (connection != null) {

				preparedStatementSelect = connection.prepareStatement(select);
				preparedStatementSelect.setInt(1, user.getId());

				preparedStatementUpdate = connection.prepareStatement(update);
				preparedStatementUpdate.setInt(1, user.getId());

				resultSet = preparedStatementSelect.executeQuery();
				if (resultSet.next())
					dado = new Dado(resultSet.getInt("userid"), resultSet.getInt("numero"));

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
		return (dado);
	}
}
