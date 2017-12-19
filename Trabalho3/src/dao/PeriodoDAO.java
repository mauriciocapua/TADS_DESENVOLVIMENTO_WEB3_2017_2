package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import negocio.Periodo;

public class PeriodoDAO {
	private DataSource dataSource = null;

	public PeriodoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Periodo getPeriodo() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Periodo periodo = new Periodo();

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("select * from periodo");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next())
					periodo = new Periodo(resultSet.getTimestamp("inicio"), resultSet.getTimestamp("fim"));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (periodo);
	}

	public boolean createPeriodo(Periodo periodo) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Boolean flag = false;
		String query = "insert into periodo (inicio, fim) values (?,?) returning id";
		try {
			connection = dataSource.getConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setTimestamp(1, new Timestamp(periodo.getInicio().getTime()));
				preparedStatement.setTimestamp(2, new Timestamp(periodo.getFim().getTime()));

				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					flag = true;
				}

				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (SQLException e) {
			throw e;
		}
		return flag;
	}

}
