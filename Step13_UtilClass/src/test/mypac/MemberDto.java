package test.mypac;


/*
 * dto transfer object or value object
 * 
 * 객체를 생성할때 클래스의 작성법
 * 프라이빗 접근 지정자로 필요한 필드를 데이터타입을 고려해서 만든다.
 * 디폴트 생성자를 만든다.
 * 모든 필드의 값을 생성자의 인자로 전달 받아서 필드에 저장하는 생성자를 제너레이트한다.
 * 모든 필드의 접근 메소드 즉 setter, getter메소드를 generate한다.
 * 
 * generate 하는방법 : 마우스 우클릭 => 소스 => 제너레이트 컨스트럭터
 * 												제너레이트 게터 앤 세터
 */
public class MemberDto {
	//프라이빗 접근 지정자로 필요한 필드를 정의한다.
	private int num;
	private String name;
	private String addr;
	//디폴트 생성장를 정의한다
	
	public MemberDto(){	}

	//모든 필드의 값을 전달받아서 필드에 저장하는 생성자를 정의한다.ㅋ
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

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
