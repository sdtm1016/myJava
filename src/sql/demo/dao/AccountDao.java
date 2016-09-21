package sql.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sql.demo.model.Account;
import sql.demo.utils.JDBCUtil;

public class AccountDao {

	public void insert(Account account) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = " " + " insert into account_info (account,amount) values(?,?); ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, account.getAccount());
		ptmt.setDouble(2, account.getAmount());
		ptmt.execute();
	}

	public void update(Account account) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = "" + " update account_info " + " set account=?,amount=? " + " where id =? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, account.getAccount());
		ptmt.setDouble(2, account.getAmount());
		ptmt.setDouble(3, account.getId());

		ptmt.execute();
	}

	public void delete(Account account) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = "" + " delete from account_info " + " where id =? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, account.getId());
		ptmt.execute();
	}

	public ArrayList<Account> query(Account account) throws SQLException {
		List<Account> result = new ArrayList<Account>();

		Connection conn = JDBCUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from account_info ");
		sb.append("  where account like ?  ");

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%" + account.getAccount() + "%");
		ResultSet rs = ptmt.executeQuery();
		ptmt.setInt(1, 1);
		ptmt.execute();
		return null;
	}

}
