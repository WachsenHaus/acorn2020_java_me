package test.main;
import test.myPac.*;
public class MainClass04 {
	public static void main(String[] args) {
		
		SmartPhone p1;
		SmartPhone p2 = null;
		SmartPhone p3 = new SmartPhone();
		
		//p1은 아직 만들어지지 않았기 때문에 문법이 성립하지 않는다.
		//p1.call();
		
		
		//p2는 비어있는(null이 들어 있는) 상태이기 때문에
		//실행시(runtime 시)에 NullPointerException이 발생한다.
		p2.call();
		
		//p3에는 참조값이 들어 있으므로 정상적으로 사용 가능
		
	}
}
