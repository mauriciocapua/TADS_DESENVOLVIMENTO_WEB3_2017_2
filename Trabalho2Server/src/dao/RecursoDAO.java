package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import exceptions.RecursoNotFound;
import exceptions.RecursoNotInsert;
import exceptions.RecursoSemEstoque;
import negocio.Recurso;

public class RecursoDAO {

	private DataSource dataSource = null;

	public RecursoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Recurso insert(Recurso recurso) throws RecursoNotInsert {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "insert into recurso (id,descricao, quantidade,version) values (?,?,?,?) returning id";
		try {
			connection = dataSource.getConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, recurso.getId());
				preparedStatement.setString(2, recurso.getDescricao());
				preparedStatement.setInt(3, recurso.getQuantidade());
				preparedStatement.setInt(4, 0);

				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					recurso.setId(resultSet.getInt("id"));
				}

				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (SQLException e) {
			throw new RecursoNotInsert();
		}
		return recurso;

	}

	public Recurso consulta(Recurso recurso) throws RecursoNotFound {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("SELECT * FROM recurso WHERE id = ? and quantidade >= ?");
				preparedStatement.setInt(1, recurso.getId());
				preparedStatement.setInt(2, recurso.getQuantidade());

				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					recurso = new Recurso(resultSet.getInt("id"), resultSet.getString("descricao"),
							resultSet.getInt("quantidade"), resultSet.getInt("version"));

				if (recurso.getQuantidade() == 0)
					throw new RecursoSemEstoque();
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecursoNotFound();
		}
		return (recurso);
	}

	public boolean compra(Recurso recurso) throws RecursoNotFound {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean success = false;
		String query = "insert into recurso (id, quantidade) values (?,?)";
		try {
			connection = dataSource.getConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, recurso.getId());
				preparedStatement.setInt(2, recurso.getQuantidade());

				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					success = true;
				}

				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			throw new RecursoNotFound();
		}
		return success;
	}

	public boolean vende(Recurso recurso, Integer venda, Integer version) throws RecursoNotFound {
		Connection connection = null;
		PreparedStatement preparedStatementUpdate = null;
		int resultSet = 0;
		Boolean retorno = false;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			String update = "update recurso set version=version+1, quantidade=quantidade-? WHERE id = ? and version=?;";

			if (connection != null) {

				preparedStatementUpdate = connection.prepareStatement(update);
				preparedStatementUpdate.setInt(1, venda);
				preparedStatementUpdate.setInt(2, recurso.getId());
				preparedStatementUpdate.setInt(3, version);

				resultSet = preparedStatementUpdate.executeUpdate();
				if (resultSet != 0)
					retorno = true;

				connection.commit();
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new RecursoNotFound();
			}
			throw new RecursoNotFound();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RecursoNotFound();
			}
		}

		return retorno;
	}

	public Recurso getById(int id) throws RecursoNotFound {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Recurso recurso = null;

		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("SELECT * FROM recurso WHERE id = ?");
				preparedStatement.setInt(1, id);

				resultSet = preparedStatement.executeQuery();
				if (resultSet.next())
					recurso = new Recurso(resultSet.getInt("id"), resultSet.getString("descricao"),
							resultSet.getInt("quantidade"), resultSet.getInt("version"));

				if (recurso.getQuantidade() == 0)
					throw new RecursoSemEstoque();
				resultSet.close();
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecursoNotFound();
		}
		return (recurso);
	}
}
