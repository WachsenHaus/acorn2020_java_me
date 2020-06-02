package test.main;
import test.mypac.*;
public class MainClass03 {
public static void main(String[] args) {
	//컴퓨터 객체를 생성해서 참조값을 c1이라는 이름의 지역변수에 담아보세요.
	
	Computer myCom = new Computer(new Cpu());
	
	//c1에 들어 있는 참조값을 이용해서 .dogame()메소드를 호출하세보세요
	myCom.doGame();
	Computer myCom2 = new Computer(null);
	myCom2.doGame();
}
}
