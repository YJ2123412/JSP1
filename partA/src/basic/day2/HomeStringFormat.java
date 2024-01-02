package basic.day2;

public class HomeStringFormat {
    public static void main(String[] args) {
        
       String msg1 = String.format("오늘은 %d년 %d월 %d일입니다", 2024, 1, 2);
       String msg2 = String.format("학원의 이름은 %s이고, 교육과정 이름은 %S입니다." , "코리아IT","웹서버개발 및 웹보안 구축 솔루션");

       System.out.println(msg1);
       System.out.println(msg2);

    }
}
