package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainClass09 {

	/* 
	 * 3명의 회원정보 번호 , 이름 , 주소를 해위맵 객체에 담고
	 * 해쉬맵 객체의 참조값을 어레이리스트 객체에 순서대로 담아보세요
	 */
	
	public static void main(String[] args) {
		HashMap<String, Object> map1 = new HashMap<>();
		HashMap<String, Object> map2 = new HashMap<>();
		HashMap<String, Object> map3 = new HashMap<>();

		map1.put("num", 0);
		map1.put("name", "영훈");
		map1.put("addr", "인천");
		
		map2.put("num", 1);
		map2.put("name", "길동");
		map2.put("addr", "한양");
		
		map3.put("num", 2);
		map3.put("name", "동수");
		map3.put("addr", "서울");
		
		//리스트는 인터페이스 클래스이며 제네릭타입을 받는다. 
		List<Map<String,Object>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		list.add(map2);
		
		System.out.println((String)list.get(0).get("name"));
		
		for(Map<String,Object> tmp: list)
		{
			int num = (int)tmp.get("num");
			String name = (String)tmp.get("name");
			String addr = (String)tmp.get("addr");
			
			System.out.println(num + " | " + name + " | " + addr);
		}
	}
}
