package test.dto;

public class MemberDto {
	//회원 한명의 정보를 담을 필드 선언
	private int num;
	private String name;
	private String addr;
	//default 생성자 만들기
	public MemberDto() {
		//인자로 필드에 저장할 값을 전달 받는 생성자.
	}
	public MemberDto(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	//필드의 접근 메소드 setter, getter 메소드
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
