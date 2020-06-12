package test.main;
import java.util.ArrayList;
import java.util.List;

import test.mypac.info;

public class MainClass05 {
	public static void main(String[] args) {
		//info 클래스로 객체를 생성해서 참조값을 i1이라는 지역 변수에 담기
		info i1 = new info(1, "영훈", "인천");
		info i2 = new info(2, "해골", "행신동");
		
		List<info> human = new ArrayList<info>();
		human.add(i1);
		human.add(i2);
		
		for(info i : human) {
			System.out.println(i.num + "|" + i.name + "|" + i.addr);
		}
	}
}
