package kb.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * JDBC를 위한 로드, 연결, 닫기 생성
 */

public class DBManager {
	
	//로드
	static {
		try {
			Class.forName(DBproperties.Driver_NAME);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//연결
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBproperties.URL, DBproperties.USER_ID, DBproperties.USER_PASS);
	}
	
	//닫기 (DML)
	public static void releaseConnection(Connection con, Statement st) {
		try {
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//닫기 (SELECT)
	public static void releaseConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		releaseConnection(con, st);
	}
	
}
