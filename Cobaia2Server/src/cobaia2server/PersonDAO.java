package cobaia2server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

	static public List<Person> getAll() {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		List<Person> l = new ArrayList<Person>();

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost/cobaia2", "postgres", "123");
			if (c != null) {
				s = c.createStatement();
				rs = s.executeQuery("SELECT * FROM person");
				while (rs.next())
					l.add(new Person(rs.getInt("id"), rs.getString("name")));
				rs.close();
				s.close();
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return(l);
	}

	static public Person getById(int id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost/cobaia2", "postgres", "");
			if (c != null) {
				ps = c.prepareStatement("SELECT * FROM person WHERE id = ?");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next())
					p = new Person(rs.getInt("id"), rs.getString("name"));
				rs.close();
				ps.close();
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return(p);
	}

}
