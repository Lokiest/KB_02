package kb.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kb.mvc.common.DBManager;
import kb.mvc.dto.BoardDTO;
import kb.mvc.dto.ReplyDTO;
import kb.mvc.exception.DMLException;
import kb.mvc.exception.SearchWrongException;

public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAOImpl instance = new BoardDAOImpl();
	/*
	 * 외부에서 객체 생성 막음
	 */
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board order by board_no desc";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("board_no"),
						rs.getString("subject"), rs.getString("writer"),
						rs.getString("content"), rs.getString("board_date"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("전체 검색에 예외 발생, 확인 요망");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board where subject like ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyWord + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("board_no"),
						rs.getString("subject"), rs.getString("writer"),
						rs.getString("content"), rs.getString("board_date"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("키워드 검색에 예외 발생, 확인 요망");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDTO boardDTO = null;
		String sql = "select * from board where board_no = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				boardDTO = new BoardDTO(rs.getInt(1),
						rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("레코드 검색에 예외 발생, 확인 요망");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return boardDTO;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into board (board_no, subject, writer, content, board_date)values (board_seq.nextval, ?, ?, ?, sysdate)";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("게시물 등록에 예외 발생");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update board set content = ? where board_no = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("게시물 수정에 예외 발생");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from board where board_no = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("게시물 삭제에 예외 발생");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into reply values(reply_no_seq.nextval, ?, ?, sysdate)";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getBoardNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("댓글 등록에 예외 발생");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDTO boardDTO = null;
		String sql = "select * from board where board_no=?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				boardDTO = new BoardDTO(rs.getInt(1),
						rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				List<ReplyDTO> replyList = this.replySelect(con, boardNo);
				boardDTO.setRepliesList(replyList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("부모글 정보에 예외 발생, 확인 요망");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return boardDTO;
	}
	
	/*
	 * 부모글에 해당하는 댓글정보를 검색하는 메소드 추가
	 */
	private List<ReplyDTO> replySelect(Connection con, int boardNo) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReplyDTO> repliesList = new ArrayList<>();
		String sql = "select * from reply where board_no = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReplyDTO reply = new ReplyDTO(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getString(4));
				repliesList.add(reply);
			}
		} finally {
			DBManager.releaseConnection(null, ps, rs);
		}
		return repliesList;
	}

}
