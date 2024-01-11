package object.day8;

import object.day7.Diamond;
import object.day7.Shape;
import object.day7.Square;
import object.day7.Triangle;

//모든 자바 클래스의 부모는 Object타입.
public class B14ObjectTest {
    public static void main(String[] args) {
        //Object타입으로 업캐스팅
        Object ob1 = new String("Hello java~");
        Object ob2 = new Diamond();
        Object ob3 = 3; //3은 int 정수 ->Integer 객체로 변경 ->Object로 참조
                        //기본형 타입은 Wrapper 클래스 객체로 변경되어 Object로 업캐스팅/ Byte, Character, Short, Long,Float,Double, Integer
                                                                                    //ㄴ다른 자료구조 List,Map, set등은 객체(클래스) 타입만 다룸
                        //Object클래스의 메소드 - 모든 자바 클래스가 상속받음
        //getClass, toString, hashCode, equals.. 그 외는 스레드 관련 메소드
        //String클래스의 equals는 Object 메소드의 재정의(오버라이드)
        System.out.println("ob1 gatClass= "+ ob1.getClass().getName());     //getName은 클래스 타입정보중 클래스이름 리턴
        System.out.println("ob1 gatClass= "+ ob2.getClass().getName());
        System.out.println("ob1 gatClass= "+ ob3.getClass().getName());

        System.out.println("hascode는 객체의 참조값(식별값)을 리턴");
        System.out.println("\t ob1 hascode = "+ob1.hashCode()+","+Integer.toHexString(ob1.hashCode()));
        System.out.println("\t ob2 hascode = "+ob2.hashCode()+","+Integer.toHexString(ob2.hashCode()));
        System.out.println("\t ob3 hascode = "+ob3.hashCode()+","+Integer.toHexString(ob3.hashCode()));

        System.out.println("toString 확인- 참조변수를 출력할때 문자열 표현값 리턴");
        System.out.println("\t ob1 toString = "+ ob1.toString());   //String은 toString 재정의
        System.out.println("\t ob2 toString = "+ ob2.toString());   //object toString의 기본값 출력
        System.out.println("\t ob3 toString = "+ ob3.toString()); //Integer는 toString 재정의
        System.out.println("\t ob1 toString = "+ ob1); //toString메소드는 생략하고 쓸 수 있음
        System.out.println("\t ob1 toString = "+ ob2);
        System.out.println("\t ob1 toString = "+ ob3);

        System.out.println("우리가 만든 클래스의 toString 재정의 확인");
        Shape sh2 = new Shape("아직모름", 25,20);
        Shape diamond = new Diamond(); // 인스턴스 필드는 초기값 0
        Shape square = new Square();
        Shape triangle = new Triangle("삼각형", 20, 30 , 65);
        System.out.println("\t sh2= " +sh2);
        System.out.println("\t diamond= " +diamond); //diamond자식클래스가 정의한 toStirng 이 나옴
        System.out.println("\t square= " +square);   //부모 Shape이 정의한 toString
        System.out.println("\t triangl= " +triangle);//부모 Shape이 정의한 toString




    }
    
}
