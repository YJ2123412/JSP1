package basic.day5;

import java.util.Arrays;

//데이터의 참조값과 관련된 테스트
public class A29ArrayVarTest {
    public static void main(String[] args) {
        int[] iArray = {1,2,3,4,5};
        double[] dArray = new double[5];
        char[] cArray = new char[5];
        cArray[0] = 'j';
        cArray[1] = 'a';
        cArray[2] = 'v';
        cArray[3] = 'a';
        cArray[4] = '!';
        //cArray[4] = ''; -> ''안에 비어있으면 오류.. 반드시 1글자 필요

        //배열 이름으로 출력하면 배열과 관련된 정보를 표시. 
        // 그 정보에 참조값(식별값)이 포함됨, 변수가 다르면 식별값도 다르다
        System.out.print("1. ");
        System.out.println(iArray);
        System.out.print("2. ");
        System.out.println(dArray);
        System.out.print("3. ");
        System.out.println(cArray);

        int [] temp;
        temp = iArray; // 주소값을 넘긴 것
        System.out.print("4. ");
        System.out.println(temp);
        
        System.out.println("5. 참조값을 전달받은 temp 배열 확인");
        temp[3] = 999;
        System.out.println("temp[3]: "+temp[3]);
        System.out.println("temp 배열의 값: "+Arrays.toString(temp));
        System.out.println("6. 어라? iArray도 같네");
        System.out.println("iArray[3]: "+iArray[3]);
        iArray[1] = 1234;
        System.out.println("temp[1]: "+temp[1]);
        System.out.println("7. temp와 iArray는 하나의 배열을 가리킴");

        //일반변수
        int age = 23;
        int itemp;
        

        //
    }
    
}
