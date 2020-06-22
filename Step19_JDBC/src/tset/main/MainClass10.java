package tset.main;

import test.dao.MemberDao;
import test.dto.MemberDto;


public class MainClass10 {
	public static void main(String[] args) {
		//만일 memberdao 객체의 참조값이 필요 하다면 ?
		//MemberDao dao = new MemberDao(); 직접 객체 생성불가/
		
		//static메소드를 이용해서 MemberDao 객체의 참조값을 받아올수있다.
		MemberDao dao = MemberDao.getInstance();
		//새로 추가할 회원의 정보라면
		MemberDto dto = new MemberDto();
		dto.setName("덩어리");
		dto.setAddr("상도동");
//		dao.insert(dto);
		
		MemberDao dao2 = MemberDao.getInstance();
		//수정할 회원의 정보라면
		MemberDto dto2 = new MemberDto(1,"김구라","독산동");
		
		//테스트
		//dao2.update(dto2);
		//dao.getData(7);
		dao.getList();
		
	}
}
