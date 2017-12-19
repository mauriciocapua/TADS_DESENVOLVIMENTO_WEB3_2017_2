package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import negocio.Escola;
import negocio.Matricula;
import negocio.Token;

public class EscolaDAO {
	private DataSource dataSource = null;

	public EscolaDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Escola findEscola(Matricula matricula) {
		Connection connection = null;
		PreparedStatement preparedStatementSelect = null;
		ResultSet resultSet = null;
		Escola escola = null;
		try {
			connection = dataSource.getConnection();

			String select = "";
			select = "SELECT * FROM escolas WHERE id=?;";
			if (connection != null) {

				preparedStatementSelect = connection.prepareStatement(select);
				preparedStatementSelect.setInt(1, matricula.getEscola().getId());

				resultSet = preparedStatementSelect.executeQuery();
				if (resultSet.next()) {
					escola = new Escola(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cep"),
							resultSet.getString("endereco"), resultSet.getString("bairro"), resultSet.getString("nro"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(escola.getNome());
		return (escola);
	}
}
