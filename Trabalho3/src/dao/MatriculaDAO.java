package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import negocio.Escola;
import negocio.Matricula;
import negocio.Token;

public class MatriculaDAO {
	private DataSource dataSource = null;

	public MatriculaDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Matricula findStatusByRg(String rg) {
		Connection connection = null;
		PreparedStatement preparedStatementSelect = null;
		ResultSet resultSet = null;
		Matricula matricula = null;
		try {
			connection = dataSource.getConnection();

			String select = "";
			select = "SELECT * FROM matriculas WHERE rg = ?;";
			if (connection != null) {

				preparedStatementSelect = connection.prepareStatement(select);
				preparedStatementSelect.setString(1, rg);

				resultSet = preparedStatementSelect.executeQuery();
				if (resultSet.next()) {
					matricula = new Matricula(resultSet.getInt("id"), resultSet.getString("nome"),
							resultSet.getString("rg"), resultSet.getTimestamp("nascimento"),
							resultSet.getString("serie"), resultSet.getString("cep"), resultSet.getString("endereco"),
							resultSet.getString("bairro"), resultSet.getString("nro"),
							new Token(resultSet.getInt("token")), resultSet.getTimestamp("data"),
							new Escola(resultSet.getInt("id_escola")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (matricula);
	}

	public List<Matricula> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatementSelect = null;
		ResultSet resultSet = null;
		List<Matricula> matriculas = new ArrayList<Matricula>();
		Matricula matricula = null;
		try {
			connection = dataSource.getConnection();

			String select = "";
			select = "SELECT * FROM matriculas;";
			if (connection != null) {

				preparedStatementSelect = connection.prepareStatement(select);

				resultSet = preparedStatementSelect.executeQuery();
				if (resultSet.next()) {
					matricula = new Matricula(resultSet.getInt("id"), resultSet.getString("nome"),
							resultSet.getString("rg"), resultSet.getTimestamp("nascimento"),
							resultSet.getString("serie"), resultSet.getString("cep"), resultSet.getString("endereco"),
							resultSet.getString("bairro"), resultSet.getString("nro"),
							new Token(resultSet.getInt("token")), resultSet.getTimestamp("data"),
							new Escola(resultSet.getInt("id_escola")));
					matriculas.add(matricula);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (matriculas);
	}

	public List<Matricula> findStatusBySerie(String serie) {
		Connection connection = null;
		PreparedStatement preparedStatementSelect = null;
		ResultSet resultSet = null;
		List<Matricula> matriculas = new ArrayList<Matricula>();
		Matricula matricula = null;
		try {
			connection = dataSource.getConnection();

			String select = "";
			select = "SELECT * FROM matriculas where serie =?;";
			if (connection != null) {

				preparedStatementSelect = connection.prepareStatement(select);
				preparedStatementSelect.setString(1, serie);

				resultSet = preparedStatementSelect.executeQuery();
				if (resultSet.next()) {
					matricula = new Matricula(resultSet.getInt("id"), resultSet.getString("nome"),
							resultSet.getString("rg"), resultSet.getTimestamp("nascimento"),
							resultSet.getString("serie"), resultSet.getString("cep"), resultSet.getString("endereco"),
							resultSet.getString("bairro"), resultSet.getString("nro"),
							new Token(resultSet.getInt("token")), resultSet.getTimestamp("data"),
							new Escola(resultSet.getInt("id_escola")));
					matriculas.add(matricula);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (matriculas);
	}

	public List<Matricula> findStatusByBairro(String bairro) {
		Connection connection = null;
		PreparedStatement preparedStatementSelect = null;
		ResultSet resultSet = null;
		List<Matricula> matriculas = new ArrayList<Matricula>();
		Matricula matricula = null;
		try {
			connection = dataSource.getConnection();

			String select = "";
			select = "SELECT * FROM matriculas where bairro = ?;";
			if (connection != null) {

				preparedStatementSelect = connection.prepareStatement(select);
				preparedStatementSelect.setString(1, bairro);

				resultSet = preparedStatementSelect.executeQuery();
				if (resultSet.next()) {
					matricula = new Matricula(resultSet.getInt("id"), resultSet.getString("nome"),
							resultSet.getString("rg"), resultSet.getTimestamp("nascimento"),
							resultSet.getString("serie"), resultSet.getString("cep"), resultSet.getString("endereco"),
							resultSet.getString("bairro"), resultSet.getString("nro"),
							new Token(resultSet.getInt("token")), resultSet.getTimestamp("data"),
							new Escola(resultSet.getInt("id_escola")));
					matriculas.add(matricula);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (matriculas);
	}
}
