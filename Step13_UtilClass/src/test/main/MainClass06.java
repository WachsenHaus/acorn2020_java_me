package test.main;

import java.lang.reflect.Member;

import javax.print.attribute.standard.Media;

import test.mypac.MemberInfo;
import test.mypac.info;

public class MainClass06 {
	public static void main(String[] args) {
		
		//디폴트 생성자를 호출해서 memberinfo객체 생성
		MemberInfo m1 =new MemberInfo();
		m1.num = 1;
		m1.name	="김구라";
		m1.addr	 = "노량진";
		
		MemberInfo i2 = new MemberInfo(2, "해골", "행신동");
		
		

	}
	
}
