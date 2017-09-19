package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.User;

public class TokenDAO {

	static public Token getToken(User p) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Token l = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost/web3_teste18092017", "postgres", "123");
			if (c != null) {
				ps = c.prepareStatement(
						"select public.token.id, public.token.login, public.token.status, public.token.validade, public.token.criacao\r\n"
								+ "from public.token inner join\r\n"
								+ "public.dado on public.token.id = public.dado.numero where public.dado.userid = ?; ");
				ps.setInt(1, p.getId());
				rs = ps.executeQuery();
				if (rs.next())
					l = new Token(rs.getInt("id"), rs.getString("login"), rs.getBoolean("status"),
							rs.getTimestamp("validade"), rs.getTimestamp("criacao"));
				rs.close();
				ps.close();
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (l);
	}

}
