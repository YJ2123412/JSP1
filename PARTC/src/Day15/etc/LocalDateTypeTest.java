package Day15.etc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTypeTest {
    
    public static void main(String[] args) {
        System.out.println("1. 현재 날짜와 시간을 구하여 출력하기");
        LocalDate currentDate = LocalDate.now(); //객체생성메소드 now(), new 연산을 대신함
        System.out.println("LocalDate 현재 날짜: "+currentDate);

        LocalTime currntTime = LocalTime.now(); //10억분의 1초(ns)까지 구해줍니다.
        System.out.println("LocalTime 현재시간: "+currntTime);

        LocalDateTime currDateTime = LocalDateTime.now(); //t: time.. 연결
        System.out.println("LocalDateTime 현재시간: "+currDateTime);
    
        System.out.println("2. 특정 날짜와 시간을 지정해서 객체를 생성하기");
        LocalDate mybirth = LocalDate.of(1996, 9, 23);  //minus , plusdays .. 메소드 있음
        LocalTime mybirth_time = LocalTime.of(17, 20);
        System.out.println("LocalDate.of(2000, 10, 11): "+mybirth);
        System.out.println("LocalTime.of(17, 20): "+mybirth_time);
        //
        //LocalDateTime.of 
        //of 메소드: 객체를 생성하고 값을 초기화

        //java.time 패키지에 다른 클래스 테스트
        System.out.println("3. 날짜 사이의 간격 계산하기");
        System.out.println("\t 내가 태어난지 ..년..월 ..일이 지났습니다");
        Period betwwen = Period.between(mybirth,currentDate); //생일-현재
        System.out.println(betwwen.getYears()+"년");
        System.out.println(betwwen.getMonths()+"월");
        System.out.println(betwwen.getDays()+"일");

        System.out.println("4. 날짜 사이의 간격 계산하기( 단위 : 년 또는 월 또는 일)");
        System.out.println("\t 내가 태어나서 ...년(개월 또는 일)이 지났습니다");
        System.out.println(ChronoUnit.YEARS.between(mybirth, currentDate)+"년");
        System.out.println(ChronoUnit.MONTHS.between(mybirth, currentDate)+"월");
        System.out.println(ChronoUnit.DAYS.between(mybirth, currentDate)+"일");

        LocalDate day10000 = mybirth.plusDays(10000);
        System.out.println("5. 내생일로부터 10000일이 이후 날짜는 : "+day10000);
        LocalDate before10000= currentDate.minusDays(10000);
        System.out.println("6. 오늘 날짜로부터 10000일 이전 날짜는?"+before10000);
        LocalDate before3= currentDate.minusDays(3);
        System.out.println("6. 오늘 날짜로부터 3일 이전 날짜는?"+before3);

        System.out.println("8. 날짜의 출력 패턴 설정하기");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 DD일"); 
        //시간은 hh 분은 mm 초 ss 밀리세컨드 SSS
        System.out.println(formatter.format(currDateTime));



    }
}
