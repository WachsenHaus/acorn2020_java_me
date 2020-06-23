package tset.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;


public class MainClass13 {
	public static void main(String[] args) {
		
		/*
		 * memberdao 객체를 이용해서 회원 목록을 얻어와서
		 * 아래와 같은 형식으로 출력해보세요
		 * 1| 김구라| 노량진
		 * 2| 원숭이| 상도동
		 * 3| 주뎅이| 봉천동
		 */
		
		MemberDao myDao = MemberDao.getInstance();
	
	
		myDao.getList();


	}
}
