package object.day05;

import java.util.Arrays;

public class B01MyClassName {
    public static void main(String[] args) {
        //정의된 클래스 MyClass1으로 객체 만들기 - new 연산 사용

        MyClass1 my1 = new MyClass1(); 
        
        //객체란 데이터 덩어리
        //new 연산으로 MyClass1 객체를 저장할 메모리확보
        //              MyClass1()는 생성자 메소드. 무조건 클래스 이름과 동일
        //                              ㄴ메모리에 저장공간을 확보하면서 동시에 실행

        System.out.println("hashcode 1");
        System.out.println(my1.field1.hashCode()); //String 
        System.out.println(my1.field3.hashCode()); //double[]

        System.out.println("my1.field1: "+my1.field1); //String
        System.out.println("my1.field2: "+my1.field2); //int
        System.out.println("my1.field3: "+my1.field3); //double[]

        my1.field1 = "Hi 모모";
        my1.field2 = 999;
        my1.field3 = new double[5];

        System.out.println("hashcode 2");
        System.out.println(my1.field1.hashCode()); //String 
        System.out.println(my1.field3.hashCode()); //double[]


        System.out.println("my1.field1: "+my1.field1); //String   주체.변수명
        System.out.println("my1.field2: "+my1.field2); //int
        System.out.println("my1.field3: "+my1.field3); //double[]
        System.out.println("my1.field3 배열의 크기: "+my1.field3.length); //double[]
        System.out.println("my1.field3 배열 요소 값: "+Arrays.toString(my1.field3)); //double[]





        MyClass1 my2 = new MyClass1();  //새로운 MyClass1 객체를 생성
        my2.field1 = "점심먹으러 갑시다";
        my2.field2 = 12345;
        my2.field3 = new double[]{34.12,23.99,6.78};
        System.out.println("my2.field1: "+my2.field1); //String 
        System.out.println("my2.field2: "+my2.field2); //int
        System.out.println("my2.field3: "+my2.field3); //double[]

        //MyClass1 my3 = new MyClass2();
        //객체의 타입과 변수의 타입이 불일치되면 안됨




    }
    
}
