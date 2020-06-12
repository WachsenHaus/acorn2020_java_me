package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;
import test.mypac.info;

public class MainClass07 {
	public static void main(String[] args) {
		
		MemberDto m1 = new MemberDto();
		m1.setNum(1);
		m1.setName("김구라");
		m1.setAddr("노량진");
		
		MemberDto m2 = new MemberDto(2, "영훈", "병방동");
		//list객체에 담아보시오
		
		List<MemberDto> l1 = new ArrayList<MemberDto>();
		l1.add(m1);
		l1.add(m2);
		
		for(MemberDto i : l1) {
			System.out.println(i.getNum() + "|" + i.getName() + "|" + i.getAddr());
		}
		
		List<MemberDto> a = l1;
		
		MemberDto b= l1.get(0);
		
		int c = l1.get(0).getNum();
		
		String d = b.getName();
		
		String e = b.getAddr();
		
		int f = b.getName().length();
		 
		
	}
}
