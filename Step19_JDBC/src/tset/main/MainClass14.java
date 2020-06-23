package tset.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;


public class MainClass14 {
	public static void main(String[] args) {
		
		/*
		 * scanner객체를 이용해서 검색할 회원 번호를 입력 받아서
		 * 입력받은 번호에 해당되는 회원 정보를 얻어와서 
		 * 아래와 같은 형식으로 출력해보세요.
		 * 
		 * 만일 1을 입력한 경우
		 * 
		 * 1 | 김구라 | 노량진
		 * 
		 * 번호가 없는경우
		 * 
		 * 9번 회원은 존재하지않습니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		MemberDao myWork = MemberDao.getInstance();
		MemberDto myData;
		
		while(true) {
			System.out.println("검색할 회원번호를 입력해주세요(종료는Q)");
			String inputChar =sc.nextLine();
			if(inputChar.equals("q")) {
				System.out.println("종료합니다.");
				return;
			}
			myData = myWork.getData(Integer.parseInt(inputChar));
			if(myData == null){
				System.out.println(inputChar + " 번 회원은 존재하지않습니다.");
			}
			else {
				System.out.println(myData.getNum() + " | " + myData.getName() + " | " + myData.getAddr());
				System.out.println("회원정보를 얻어왔습니다..");
			}
		}

	}
}
