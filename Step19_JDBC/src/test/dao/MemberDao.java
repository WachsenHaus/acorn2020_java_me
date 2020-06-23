package test.dao;
/*
 * DAO ( Data Access Object)의 약자
 * 만드는방법
 * 1. 외부에서 객체 생성하지 못하도록 생성자의 접근지정자를 private로 지정
 * 2. 자신의 참조값을 저장 할 수 있는 필드를 private로 선언
 * 3. 자신의 참조값을 오직 하나만 생성해서 리턴해주는 static 메소드만들기
 * 4. 나머지 기능들은 (select, insert, update, delete)들은 non static으로 만들기
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	//자신의 참조값을 저장할 private 필드
	private static MemberDao dao;
	
	//외부에서 객체 생성하지 못하도록 한다.
	private MemberDao() {
		
	}
	
	//참조값을 리턴해주는 메소드
	public static MemberDao getInstance() {
		if(dao == null) { //최초 호출되면 null이므로
			dao = new MemberDao(); //객체를 생성해서 static필드에 담는다.
		}
		return dao;
	}
	public MemberDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto myDto =null;
		try {
			conn = new DBConnect().getConn();
			String sql="SELECT *" 
					+ " FROM member"
					+ " WHERE num=?";
			pstmt =conn.prepareStatement(sql);			
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				myDto = new MemberDto();
				myDto.setNum(rs.getInt("num"));
				myDto.setName(rs.getString("name"));
				myDto.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				return myDto;
			}
			catch(Exception e)
			{
				System.out.println("종료에러");
			}
		}
		return null;
	}
	public List<MemberDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<>();
		try {
			conn = new DBConnect().getConn();
			String sql="SELECT *" 
					+ " FROM member"
					+ " ORDER BY num ASC";
			pstmt =conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto myDto = new MemberDto();
				myDto.setNum(rs.getInt("num"));
				myDto.setName(rs.getString("name"));
				myDto.setAddr(rs.getString("addr"));
				list.add(myDto);
//				System.out.println(myDto.getNum() + " | " + myDto.getName() + " | " + myDto.getAddr());
			}
			System.out.println("회원정보의 목록을 얻어왔습니다..");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				return list;
			}
			catch(Exception e)
			{
				System.out.println("종료에러");
			}
		}
		return null;
	}
	
	//회원 정보를 DB에 저장하는 메소드
	//작업의 성공여부가 boolean으로 리턴된다.
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = new DBConnect().getConn();
			String sql="INSERT INTO MEMBER" 
					+ " (num,name,addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			if(pstmt.executeUpdate() != 0 ) 
			{
				result = true;	
			}
			System.out.println("회원정보를 저장했습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}
			catch(Exception e)
			{
				System.out.println("종료에러");
			}
		}
		return result;
	}
	public boolean delete(int num) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			if(pstmt.executeUpdate() != 0)
			{
				result = true;
			}
			System.out.println("회원 정보를 삭제 했습니다.");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			}catch(Exception e)
			{
				
			}
		}
		return result;
	}
	//회원 정보를 DB에서 수정하는 메소드
	public boolean update(MemberDto dto)
	{
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			if(pstmt.executeUpdate() != 0) 
			{
				result = true;
			}
			System.out.println("회원정보를 저장했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				return result;
			}
			catch(Exception e)
			{
				System.out.println("종료에러");
			}
		}
		return result;
	}
}
