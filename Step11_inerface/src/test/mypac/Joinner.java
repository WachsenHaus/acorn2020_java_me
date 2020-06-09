package test.mypac;

// (@fun ctrl + space bar) 한 개의 메소드만 가지도록 강제하는 기능
@FunctionalInterface 
public interface Joinner {
	//전달되는 두 문자열을 연결해서 리턴하는 메소드
	public String join(String first, String second);
	//public void a();
}
