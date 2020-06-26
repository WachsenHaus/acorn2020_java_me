package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import test.dto.MemoDto;
import test.util.DBConnect;

public class MemoDao {
	private static MemoDao dao;
	private static Connection conn;
	private MemoDao() {
		
	}
	

	public static MemoDao getInstance() {
		if(dao == null) {
			dao = new MemoDao();
		}
		return dao;
	}
	
	public void disconnectSQL() {
		try {
			if(conn != null) {
				System.out.println("연결을종료합니다.");
				conn.close();	
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public boolean connectSQL() {
		boolean isSucc = false;
		try {
			conn = new DBConnect().getConn();
			System.out.println("성공적으로 DB를 연결했습니다.");
			isSucc = true;
		}catch(Exception e)
		{
			System.out.println("DB 연결 실패");
		}
			return isSucc;	
	}
	
	public List<MemoDto> getList(){
		List<MemoDto> result = new ArrayList<MemoDto>();
		if(conn == null) return null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql="SELECT num,content,TO_CHAR(regdate,'YYYY\"년\"MM\"월\"DD\"일\" AM HH:MI') as regdate" 
					+ " FROM memo"
					+ " ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				MemoDto data = new MemoDto(rs.getInt("num"), rs.getString("content"), rs.getString("regdate"));
				result.add(data);
			}
		}catch(Exception e)
		{
			result = null;
			System.out.println("getList오류");
		}
		finally {
			try {
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
			}catch (SQLException e) {
				result = null;
				System.out.println("getList오류-close");
			}
		}
		return result;
	}
	public boolean delete(MemoDto dto) {
		boolean isSucc = false;
		if(conn == null) return false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM memo"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			if(pstmt.executeUpdate() != 0)
			{
				return true;
			}
		}catch(Exception e)
		{
			System.out.println("delete오류");
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					isSucc = true;
				} 
			}catch (SQLException e) {
				System.out.println("delete오류-close");
			}
		}
		return isSucc;
	}
	public boolean insert(MemoDto dto) {
		boolean isSucc = false;
		if(conn == null) return false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO MEMO"
					+ " (num,content,regdate)"
					+ " VALUES(memo_seq.NEXTVAL, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			if(pstmt.executeUpdate() != 0)
			{
				return true;
			}
		}catch(Exception e)
		{
			System.out.println("insert오류");
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					isSucc = true;
				} 
			}catch (SQLException e) {
				System.out.println("insert오류-close");
			}
		}
		return isSucc;
	}
	
	public boolean update(MemoDto data) {
		boolean isSucc = false;
		if(conn == null) return false;
		PreparedStatement pstmt = null;
		
		try {
			String sql="UPDATE memo"
					+ " SET content=?"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getContent());
			pstmt.setInt(2, data.getNum());
			if(pstmt.executeUpdate() != 0)
			{
				return true;
			}
		}catch(Exception e)
		{
			System.out.println("update오류");
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					isSucc = true;
				} 
			}catch (SQLException e) {
				System.out.println("update오류-close");
			}
		}
		return isSucc;
	}
	
}
