package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import negocio.Escola;
import negocio.Vaga;

public class VagaDAO {

	private DataSource dataSource = null;

	public VagaDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Vaga> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vaga> vagas = new ArrayList<Vaga>();

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("select * from vagas");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next())
					vagas.add(new Vaga(resultSet.getInt("id"), resultSet.getInt("serie"),
							resultSet.getInt("quantidade")));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (vagas);
	}

	public List<Vaga> findByEscola(Escola escola) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vaga> vagas = new ArrayList<Vaga>();

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("select * from vagas where id_escola=?");
				preparedStatement.setInt(1, escola.getId());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next())
					vagas.add(new Vaga(resultSet.getInt("id"), resultSet.getInt("serie"),
							resultSet.getInt("quantidade")));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (vagas);
	}

	public List<Vaga> findByEscolaSerie(Escola escola, int serie) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Vaga> vagas = new ArrayList<Vaga>();

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement("select * from vagas where id_escola=? and serie=?");
				preparedStatement.setInt(1, escola.getId());
				preparedStatement.setInt(2, serie);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next())
					vagas.add(new Vaga(resultSet.getInt("id"), resultSet.getInt("serie"),
							resultSet.getInt("quantidade")));
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (vagas);
	}

	public boolean createVagas(Escola escola, String serie, String vagas) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Boolean flag = false;
		String query = "insert into vagas (serie, quantidade, id_escola) values (?,?,?) returning id";
		try {
			connection = dataSource.getConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(serie));
				preparedStatement.setInt(2, Integer.parseInt(vagas));
				preparedStatement.setInt(3, escola.getId());

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
