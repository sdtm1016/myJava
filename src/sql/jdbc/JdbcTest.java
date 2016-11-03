package sql.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 用JDBC如何调用存储过程
 */
public class JdbcTest {

	public static void main(String[] args) {
		Connection cn = null;
		CallableStatement cstmt = null;
		try {
			//这里最好不要这么干，因为驱动名写死在程序中了
			Class.forName("com.mysql.jdbc.Driver");
			//实际项目中，这里应用DataSource数据，如果用框架，
			//这个数据源不需要我们编码创建，我们只需Datasource ds = context.lookup()
			//cn = ds.getConnection();
			cn = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
			cstmt = cn.prepareCall("{call insert_Student(?,?,?)}");
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.setString(1, "wangwu");
			cstmt.setInt(2, 25);
			cstmt.execute();
			//get第几个，不同的数据库不一样，建议不写
			System.out.println(cstmt.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			/*try{cstmt.close();}catch(Exception e){}
			try{cn.close();}catch(Exception e){}*/
			try {
				if (cstmt != null)
					cstmt.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}