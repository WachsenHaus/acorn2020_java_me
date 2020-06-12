package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {
		
		/*
		 * hashmap <키값의 type, value값의 type>
		 */
		Map<String, Object> map =new HashMap<>();
		map.put("num",1);
		map.put("name","김구라");
		map.put("addr","노량진");
		
		map.get("num");
		
		
		
		/*
		 *value의 제네릭 클래스가 오브젝트로 지정 되어 있기 때문에
		 *리턴되는 오브젝트 타입을 원래 타입로 캐스팅 해야한다.
		 *
		 */
		
		int num = (int)map.get("num");
		String name = (String)map.get("name");
		String addr= (String)map.get("addr");
		
		
		
		
	}
}
