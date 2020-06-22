package test.dao;
/*
 * DAO ( Data Access Object)의 약자
 * 만드는방법
 * 1. 외부에서 객체 생성하지 못하도록 생성자의 접근지정자를 private로 지정
 * 2. 자신의 참조값을 저장 할 수 있는 필드를 private로 선언
 * 3. 자신의 참조값을 오직 하나만 생성해서 리턴해주는 static 메소드만들기
 * 4. 나머지 기능들은 (select, insert, update, delete)들은 non static으로 만들기
 */

import test.dto.MemberDto;

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
	
	//회원 정보를 DB에 저장하는 메소드
	public void insert(MemberDto dto) {
		
		
	}
	
	//회원 정보를 DB에서 수정하는 메소드
	public void update(MemberDto dto)
	{
		
	}
}
