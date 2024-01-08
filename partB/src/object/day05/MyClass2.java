package object.day05;

import java.util.Arrays;

public class MyClass2 {
    //인스턴스 필드 - 객체 생성하여 사용
    private String field1;
    private int field2;
    private double[] field3; //참조값 저장 변수


    //private : 사적인, 개인적인. MyClass2 클래스 외에는 사용할 수 없는 필드
    //필드값을 가져오는 메소드: getter
    public String getField1(){
        return field1;
    };


    public int getField2() {
        return field2;
    }

    public double[] getField3() {
        return field3; //배열의 참조값을 리턴
    }



    //필드값을 저장하는 메소드: setter
    public void setField1(String f1){
        field1 = f1;
    }
    public void setField2(int f2){
        field2 = f2;
    }

    // public void setField3(double[]f1){
    //     field3 = f1;
    // }

    public void setField3(double[] f3) { 
        //this.field3 = f3;  ->//참조값을 대입시킴. 객체가 의도하지 않아도 쉽게 field3의 배열값이 변경됨
        field3 = new double[f3.length];
        for (int i = 0; i < f3.length; i++) {
            field3[i] = f3[i];
        }
    }

    //모든 인스턴스 필드 값을 출력해주는 메소드
    public void printData(){
        System.out.println("field1 = "+field1+", filed2 = "+field2+", filed3 = "+Arrays.toString(field3));
    }

    

}