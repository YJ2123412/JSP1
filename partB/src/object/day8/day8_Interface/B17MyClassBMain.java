package object.day8.day8_Interface;

public class B17MyClassBMain {
    public static void main(String[] args) {
        
        MyClassA mya = new MyClassA();
        mya.methodB(80);
        mya.methodC("엥");
        mya.methodA();

        //다중구현 클래스인 MyClassB는 두가지 업캐스팅 가능합니다
        InterfaceA ifa= new MyClassB();
        //InterfaceX ifx = new MyClassB();
        //오류 ifx.methodA(); //methodA는 InterfaceA의 추상메소드
        //다른 인터페이스 참조 타입으로는 메소드 실행 못함

        //오류 ifa.methodX(); //methodX는 InterfaceX의 추상메소드

        InterfaceX ix = (InterfaceX) ifa;
        ix.methodX();




    }
    
}
