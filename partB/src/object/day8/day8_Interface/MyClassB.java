package object.day8.day8_Interface;

//인터페이스를 다중(여러개)으로 사용하는 구현 클래스 연습입니다.
//정리: 상속은 단일 상속, 인터페이스 구현은 다중구현, 인터페이스는 규칙을 주는 것
public class MyClassB implements InterfaceA , InterfaceX {
		
	//InterfaceA의 추상메소드 구현
	@Override
	public void methodA() {
		System.out.println("여기는 MyClassB의 methodA입니다.");
		
	}
	
	@Override
	public int methodB(int num) {
		return 0;
	}
	
	//InterfaceX의 추상메소드 구현
	@Override
	public String methodX() {
		return "나는 테스트";
	}
}
