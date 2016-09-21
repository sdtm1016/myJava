package sql.demo.utils;


import java.sql.*;



public class JDBCUtil {

	private static final String url = "jdbc:mysql://localhost:3306/imooc_db";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "root";
	private static final String sql = "select * from";
	
	private static  Connection conn;
	static{
		try {
			
				Class.forName(driver);
			
			conn =DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}
	public static void main(String[] args) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
