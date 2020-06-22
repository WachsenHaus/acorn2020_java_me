package tset.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass08 {

	private static Connection conn;
	private static PreparedStatement pstmt;

	public static void main(String[] args) {
		//추가할 회원의 정보
		String name = "주뎅이";
		String addr="봉천동";
		PreparedStatement pstmt;
		Connection conn;

		MemberDto myMemberDto = new MemberDto();
		myMemberDto.setName(name);
		myMemberDto.setAddr(addr);
		
		insert(myMemberDto);
	}
	
	public static void insert(MemberDto dto) {
		conn = new DBConnect().getConn();
		String sql="INSERT INTO MEMBER" 
				+ " (num,name,addr)"
				+ " VALUES(member_seq.NEXTVAL, ?, ?)";
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.executeUpdate();
			System.out.println("회원정보를 저장했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("종료에러");
			}
		}
		
		
		
		
	}
}
