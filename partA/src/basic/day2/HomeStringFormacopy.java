package basic.day2;

import java.util.Scanner;

public class HomeStringFormacopy {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("오늘의 날짜를 입력하세요(예시: 2024.01.01)");
        String date = scanner.nextLine();

        char[] year1 = {date.charAt(0),date.charAt(1),date.charAt(2),date.charAt(3)};
        String year = String.valueOf(year1);
        char[] month1 = {date.charAt(5),date.charAt(6)};
        String month = String.valueOf(month1);
        char[] day1 = {date.charAt(8),date.charAt(9)};
        String day = String.valueOf(day1);

        String msg1 = String.format("오늘은 %s년 %s월 %s일입니다", year,month,day);
        String msg2 = String.format("학원의 이름은 %s이고, 교육과정 이름은 %S입니다." , "코리아IT","웹서버개발 및 웹보안 구축 솔루션");

        System.out.println(msg1);
        System.out.println(msg2);

        scanner.close();
    }
}
