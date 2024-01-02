package basic.day2;

import java.util.Arrays;

public class A11StrimgMethod {
    public static void main(String[] args) {    
        //메소드는 메소드 이름 뒤에 괄호가 따라 나옴
        //괄호 안의 값들은 메소드 처리에 필요한 입력데이터 : 메소드의 인자
        //처리한 결과는 출력데이터 : 메소드의 리턴(반환)값

        //-메소드 인자개수와 형식에 따라 분류
         //1. 메소드 괄호 안에 아무것도 없는 것 :length, isEmpty,toUppercase,toLowerCase
         //2. 메소드 괄호 안에 정수 1개를 쓰는 것: charAt
         //3. 메소드 괄호 안에 문자열 1개를 쓰는 것: concat, equals, starstWith, endsWith
         //4. 메소드 괄호 안에 정수 2개를 쓰는 것: substring, 
         //5. 메소드 괄호 안에 문자열 2개를 쓰는 것 : replace, split
         
         String message = "Hello, World~e";
         String message2 = "";
         System.out.println("해당 문자열로 시작하는지 여부: "+message.startsWith("H")); //대소문자구분, 한 인덱스만
         System.out.println("해당 문자열로 끝나는지 여부: "+message.endsWith("e")); //대소문자구분

         System.out.println("비었는지 여부: "+message2.isEmpty()); //null 말고 "" 여야 true
         System.out.println("'메세지'"+message+"'의 길이: "+message.length());
        
         System.out.println("첫번째 글자: "+message.charAt(0));
         System.out.println("마지막 인덱스: (length-1) = "+(message.length()-1));

         System.out.println(message.concat("짱"));


          //4. 메소드 괄호 안에 정수 2개를 쓰는 것: substring ->문자열 추출: 시작과 끝(마지막 인덱스 포함x) 인덱스 지정
          //결국 추출하는 문자개수는 endIndex-beginIndex
            System.out.println("message.substring(0, 4)"+message.substring(0, 4));
            System.out.println("message.substring(2, 4)"+message.substring(2, 4));
   
          //5. 메소드 괄호 안에 문자열 2개를 쓰는 것 : replace(문자열 바꾸기), split
        System.out.println(message.replace("ll", "***"));
        //System.out.println(message.split(l));





        /*//리턴 값 형식을 기준으로 정리하기
        1. boolean: isEmpty,equals, startstWith, endsWith
        2. String: endIndex-beginIndex, concat, toUppercase, toLowerCase, replace
        3. int: length,indexOf
        4. char:charAt
        */
        System.out.println("---------------");


        String m = "안녕하세요!반갑습니다!잘부탁합니다";
        String[] arr = new String[5];
        arr = m.split("!");
        System.out.println(Arrays.toString(arr));

        //message.toLowerCase().equals(); //메소드 이어서 사용가능

    }
    
}
