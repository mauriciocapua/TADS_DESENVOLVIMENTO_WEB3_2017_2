package cobaia2server;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		PersonDAO personDAO = new PersonDAO();
			List<Person> l = personDAO.getAll();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getId() + ", " + l.get(i).getName());
		}
	}
}
