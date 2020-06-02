package test.mypac;

public class Student {

	public String name = "";
	public Student(String name)
	{
		this.name = name;
		System.out.println("Student 클래스의 생성자 호출됨!");
	}
	public void study() {
		System.out.println("공부를 해요");
	}
	
	public void goSchool() {
		System.out.println("학교를 가요");
	}
	
}
