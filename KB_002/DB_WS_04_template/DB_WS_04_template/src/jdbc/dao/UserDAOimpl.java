package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jdbc.common.DBManager;
import jdbc.dto.UserDto;

public class UserDAOimpl implements UserDAO {

	@Override
	public int insert(UserDto userDto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into users(user_seq, name, email, phone) values(?,?,?,?)";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, userDto.getUserSeq());
			ps.setString(2, userDto.getName());
			ps.setString(3, userDto.getEmail());
			ps.setString(4, userDto.getPhone());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int update(UserDto userDto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update users set phone = ? where user_seq = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userDto.getPhone());
			ps.setInt(2, userDto.getUserSeq());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}

	@Override
	public List<UserDto> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserDto> users = new ArrayList<>();
		String sql = "select * from users";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserDto dto = new UserDto();
				dto.setUserSeq(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setPhone(rs.getString(4));
				dto.setSleep(Objects.equals(rs.getString(5), "Y"));
				
				users.add(dto);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return users;
	}

	@Override
	public UserDto selectOne(int userSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where user_seq = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int user_seq = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String is_sleep = rs.getString(5);
			
				System.out.println(user_seq + " / " + name + " / " + email + " / " + phone + " / " + is_sleep);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return null;
	}

	@Override
	public int delete(int userSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from users where user_seq = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

}
