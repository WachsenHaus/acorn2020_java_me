package tset.main;

import test.dao.MemberDao;
import test.dto.MemberDto;


public class MainClass11 {
	public static void main(String[] args) {
		MemberDao dao1 = MemberDao.getInstance();
		MemberDao dao2 = MemberDao.getInstance();
		MemberDao dao3 = MemberDao.getInstance();
		//dao1,2,3안에 있는 참조값은 모두 같다. (싱글톤 = 일꾼하나)
		
		if(dao1 == dao2) {
			System.out.println("둘이같다.");
			
		}
	}
}
