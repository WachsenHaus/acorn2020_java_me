package tset.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;


public class MainClass12 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * scanner 객체를 이용해서 문자열을 두번 입력 받는다.
		 * 즉 새로 추가할 이름과 주소를 입력 받아서
		 * MemberDao 객체를 이용해서 Db에 저장하는 code를 작성해보세요
		 */
		MemberDao myDao = MemberDao.getInstance();
		MemberDto myData = new MemberDto();
		
		{
			System.out.println("이름을 입력하세요");
			myData.setName(sc.nextLine());
			System.out.println("주소를 입력하세요");
			myData.setAddr(sc.nextLine());
		}
		
		if(myDao.insert(myData) == false) {
			System.out.println("추가 실패");
		}
		myDao.getList();

	}
}
