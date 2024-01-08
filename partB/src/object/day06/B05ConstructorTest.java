package object.day06;

import java.util.Arrays;

public class B05ConstructorTest {
    public static void main(String[] args) {
        MyClass4 my = new MyClass4();
        System.out.println("기본 생성자 실행");
        System.out.println("\t field2 : " +my.getField2());

        System.out.println("인자1개 커스텀 생성자 실행");
        MyClass4 my1 = new MyClass4();
        System.out.println("\t my1 field 2: "+my1.getField2());
        MyClass4 my2 = new MyClass4("Hello");
        System.out.println("\t my2 field 1: "+my2.getField1());

        System.out.println("인자2개 커스텀 생성자 실행");
        MyClass4 my3 = new MyClass4("java",222);
        System.out.println("\t my3 field 1: "+my3.getField1());
        System.out.println("\t my3 field 2: "+my3.getField2());
        
        
        
        
        System.out.println("인자3개 커스텀 생성자 실행");
        MyClass4 my4 = new MyClass4("good",222, new double[3]);
        System.out.println("\t my4 field 1: "+my4.getField1());
        System.out.println("\t my4 field 2: "+my4.getField2());
        System.out.println("\t my4 field 3: "+my4.getField3());
        System.out.println("\t my4 field 3: "+Arrays.toString(my4.getField3()));
        
        //기본 생성자와 setter가 없는 MyClass5객체를 만듬
        MyClass5 my5 = new MyClass5("language", 111, new double[3]);
        //MyClass5 my6 = new MyClass5(); //오류, 기본생성자가 없는 클래스-> ctor로 기본생성자 만들어주면 쓸 수 있음
        System.out.println("MyClass5 객체확인");
        System.out.println("\t my5 field 1: "+my5.getField1());
        System.out.println("\t my5 field 2: "+my5.getField2());
        System.out.println("\t my5 field 3: "+my5.getField3());

        Myclass3 test = new Myclass3(); 
        test.setField1("파이썬");
        test.setField2(999);
        test.setField3(new double[]{1.2,34.56,123.45});
        //기본 생성자는 set메소드로 직접 값을 초기화하는 것이 조금불편합니다 ->초기화를 위해서는 커스텀 생성자가 좋습니다.
        //결론: MyClass3과 같이 생성자 메소드가 직접 정의된 것이 없으면 기본 생성자만 쓸 수 있음.
        //                                                          ㄴ기본생성자가 생략되어 있는 상태
        //MyClass5와 같이 커스텀 생성자 메소드가 하나라도 정의되어 있으면 기본 생성자는 사용못함
            //  사용하고 싶으면 직접 정의해야합니다. , 기본생성자는 생략하고 사용 못합니다. 
            //    public MyClass5() {}


    }
    
}
