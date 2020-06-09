package test.mypac;
/*
 * [ interface ]
 * 
 * - 생성자가 없다. (단독 객체 생성 불가)
 * 
 * - 추상 메소드만 가질 수 있다. (구현된 메소드는 불가)
 * 		abstract 예약어 생략가능.
 * 
 * - 필드는 static final 상수만 가질 수 있다.
 * 		static 예약어 생략가능
 * 
 * - data type의 역할을 할 수 있다.
 * 
 * - interace type의 참조값이 필요하면 구현(implement) 클래스를 만들어서
 * 		객체를 생성해야 한다.
 * 
 * - 클래스 상속은 단일 상속이지만, 인터페이스는 다중 구현이 가능하다.
 * 		class A extends B {}
 * 
 * 		class A implements B {}
 * 		class A implements B, C {}
 * 		
 * 		public A extends B implements C, D { ... }
 * 			A a = new A();
 * 			B, C, D ... type객체를 생성할 수 있다.
 *   
 * */
public interface Remocon {
	//필드 (static 예약어 생략가능)
//	public *static* final String COMPANY="LG";
	public final String COMPANY="LG";
	
	//메소드 (abstract 예약어 생략가능)
//	public *abstract* void up();
	public void up();
	public void down();
	
	//참조 Remocon.COMPANY
}
