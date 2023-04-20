package web.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * JDBC를 위한 로드, 연결, 닫기
 */
public class DBManager {
	
	private static DataSource ds;

	/**
	 * 로드
	 */
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 연결
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = ds.getConnection();
		return con;
	}

	/**
	 * 닫기(DML 전용). 사용된 객체를 닫는 것
	 */
	public static void releaseConnection(Connection con, Statement st) {
		try {
			if (st != null) st.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 닫기(SELECT 전용)
	 */
	public static void releaseConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseConnection(con, st);
	}
}
