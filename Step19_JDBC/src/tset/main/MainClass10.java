package tset.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass10 {
	//만일 memberdao 객체의 참조값이 필요 하다면 ?
	//MemberDao dao = new MemberDao(); 직접 객체 생성불가/
	
	//static메소드를 이용해서 MemberDao 객체의 참조값을 받아올수있다.
	MemberDao dao = MemberDao.getInstance();
	
	//새로 추가할 회원의 정보라면
	MemberDto dto = new MemberDto();
	dto.setName("덩어리");
	dto.setAddr("상도동");
	dao.insert(dto);
	
	
}
