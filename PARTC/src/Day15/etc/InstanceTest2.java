package Day15.etc;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * InnerMyCalendar
 */
public class InstanceTest2 {

    public static void main(String[] args) {
        MyCalendar my1 = MyCalendar.getInstance();
        // MyCalendar my2 = new MyCalendar();
        // MyCalendar my3 = MyCalendar.object;

        YourCalendar you1 = YourCalendar.of("2024", "03");
        


    }
    
}
// main메소드는 1개 파일에 하나만 있어야 한다.
// public 클래스도 1개 파일에 하나만 있어야 한다.
// 위의 2가지 지키고 1개 파일에 클래스는 여러 개 만들 수 있다.
@Getter
@Setter
@NoArgsConstructor      //기본생성자
@AllArgsConstructor
@ToString
@EqualsAndHashCode

class Member {
    private String name;
    private int age;
    private int point;

    //lombok 라이브러리: 매번 작성되는 아래 메소드를 자동으로 만들어줌

    // 커스텀 생성자
    // 기본 생성자
    // getter   // setter
    // toString 재정의
    // hasgcode 와 equals 재정의

}


class MyCalendar {
    private static MyCalendar object = new MyCalendar();
    // 필드가 현재 클래스의 타입. 미리 생성자로 객체를 만듭니다.
    private MyCalendar() {      // 생성자는 private. 다른 클래스에서 사용 불가
    }

    public static MyCalendar getInstance(){
        // 미리 만들어진 현재 클래스 타임의 객체를 리턴
        return object;
    }

}

class YourCalendar{
    private String month;
    private String day;

    private YourCalendar(){}    // 다른 클래스에서 new 연산 사용 불가.

    public static YourCalendar of(String month, String day){
        YourCalendar result = new YourCalendar();
        result.month = month;
        result.day = day;
        return result;
    }

    public String getDay() {
        return day;
    }
    public String getMonth() {
        return month;
    }

}

