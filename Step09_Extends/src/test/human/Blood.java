package test.human;

import java.util.Set;

public  class Blood {
	
	private	String rh;
	private String type;
	
	/*
	 * 필드를 선언하고 나서 get을 타이핑 후 ctrl + space 키를 누르면
	 * 이클립스가 getter 메소드를 자동으로 만들어 줄 준비를 한다.
	 */
	//필드에 저장된 rh를 리턴해주는 getter 메소드.
	
	public Blood(String rh,String type)
	{
		this.rh = rh;
		this.type = type;
	}
	
	
	public String getRh() {
		return rh;
	}
	public void setRh(String rh) {
		this.rh = rh;
	}
}
