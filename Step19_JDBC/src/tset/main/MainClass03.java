package tset.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * member테이블에 추가할 호원의 정보
		 * 김구라, 노량진
		 * 회원의 번호는 시퀀스 객체를 이용해서 넣기
		 * 시퀀스 명: member_seq
		 */
		
		String name = "김구라";
		String addr = "노량진";
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보 @아이피주소:port번호:db이름
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn = DriverManager.getConnection(url,"scott","tiger");
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		}
		catch(Exception ex) {
			System.out.println("Static Main함수 오류");
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체의 참조값 없어오기.
			//pstmt가 sql문을 실행해준다.
			pstmt=conn.prepareStatement(sql);	

			// ?에 값을 바인딩해서 미완성의 SQL문을 완성 시킨다.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			//실제로 수행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
			}catch (Exception e) {
				
			}
		}
		
	}
}
