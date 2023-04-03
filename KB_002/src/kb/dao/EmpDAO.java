package kb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kb.common.DBManager;
import kb.dto.EmpDTO;

public class EmpDAO {
	/*
	 * emp테이블의 사원 정보 검색하기
	 * select empno, ename, job, sal, hiredate from emp
	 */
	public void selectAll() {
		//load connection execute close
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, sal, hiredate from emp";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int sal = rs.getInt(4);
				String hiredate = rs.getString(5);
				
				System.out.println(empno + " / " + ename + " / " + job + " / " + sal + " / " + hiredate);
			}
			System.out.println(" -------- success ---------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
	}
	
	//사원 등록하기 insert into emp(empno, ename, job, sal, hiredate) values(?,?,?,?,sysdate)
	public int insert(EmpDTO emp) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into emp(empno, ename, job, sal, hiredate) values(?,?,?,?,sysdate)";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, emp.getEmpNo());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}
	
}
