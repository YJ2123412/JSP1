package Day14;

import java.io.IOException;

import Day11.myapp.JavaWord;
import Day13.Io.JavaWordList;


public class ReviewProb {
    public static void main(String[] args) {
        prob_10();
        
        
    }

    //8번 문제 예시
    public static void prob_8(){
        JavaWordList words = new JavaWordList("Wordtest.txt");
        words.fileLoad();
        words.add(new JavaWord("null", "비어있는",1));// 1번
        //words.remove(-9); //2번
        //개발자가 만드는 예외: 1) 예외가 발생되는 문법오류, 실행오류 없지만 값의 범위를 제한하기 위해 예외 발생할 수 있음
        //2) 기존 발생하는 예외를 새로운 내용으로 변경할 떄
        
    }

    public static void prob_10(){
        byte[] buffer = new byte[20];
        try {
            int b = System.in.read(buffer); //최대 20바이트, 실제 입력한 byte는 정수값으로 리턴..
            System.out.println("입력바이트 수 :"+b);
            //System.out.println("입력한 문자열: "+new String(buffer));
            System.out.println("입력한 문자열 정수변환 "+Integer.parseInt(new String(buffer).trim()));
        } catch (IOException | NumberFormatException e) { // ||논리적인 or, | 비트단위 or
            e.printStackTrace();
            // 해당 오류 메소드로 실행되는 결과 예시. trace-  추적하다
            //보통 오류 원인은 맨 윗줄
            /* Exception in thread "main" java.lang.IllegalArgumentException: 삭제할 인덱스 범위가 잘못되었습니다.
                at Day13.Io.JavaWordList.remove(JavaWordList.java:106)
                at Day14.ReviewProb.prob_8(ReviewProb.java:16)
                at Day14.ReviewProb.main(ReviewProb.java:8) */
        }

        
    }
}
