package sql.jdbc;

public class JDBCDemo1 {
	public static void main(String[] args) {
		try {
			Class.forName("jdbc.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
