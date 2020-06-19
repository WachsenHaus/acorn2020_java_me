package tset.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainClass01 {

	/*
	 * JDBC
	 * DabaBase에 연결해서 select,insert,update,delete 작업하기
	 * 
	 * oracle에 연결하기 위해서는 드라이버 클래스가 들어있는 ojdbc6.jar파일을
	 * 사용할 수 있도록 설정해야 한다.
	 */
	public static void main(String[] args) {
		//db연결객체를 담을 지역변수 만들기
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
	}
}
