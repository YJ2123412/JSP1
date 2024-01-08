package object.day05;

import java.util.Arrays;

public class B02GetterSetterTest {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        MyClass2 momo = new MyClass2();
        System.out.println("MyClass2의 field1값(초기): "+momo.getField1());
        momo.setField1("나는 모모");

        System.out.println("MyClass2의 field1값(변경후): "+momo.getField1());
        String msg = "안녕";
        momo.setField1(msg);      
        System.out.println("MyClass2의 field1값(변경후2): "+momo.getField1());

        System.out.println("MyClass2의 field2값(초기): "+momo.getField2());
        momo.setField2(10);
        System.out.println("MyClass2의 field2값(변경후): "+momo.getField2());
       
        System.out.println("지금까지의 momo객체 값들은...");
        momo.printData();



        System.out.println("filed3은 double[] 타입입니다.");
        System.out.println("MyClass2의 field3값(초기): "+momo.getField3());
        double[] dArray = momo.getField3();
        System.out.println(Arrays.toString(dArray));
        System.out.println("MyClass2의 field3값(변경후1): "+momo.getField3());
        System.out.println("MyClass2의 field3값(변경후1): "+dArray);

        dArray = new double[]{3.1, 2.3,4.4};
        momo.setField3(dArray);
        System.out.println("MyClass2의 field3값(변경후2): "+momo.getField3());
        System.out.println("MyClass2의 field3값(변경후2): "+Arrays.toString(momo.getField3()));
        
        momo.setField3(new double[5]);
        System.out.println("모모 전체1");
        momo.printData();
        double[] tempArray = {1.2,3.44,62.2};
        System.out.println("변경된 후의 3");
        momo.setField3(tempArray);
        System.out.println("모모 전체2");
        momo.printData();

        tempArray[2]=3.145;
        System.out.println("바뀐 값3: ");
        momo.printData();
    }
}
