package basic.day1;

public class A01DataTest {

/* 패키지?
 * 인터넷 주소 https://developers.kakao.com/  와 같은 형식에서  developers.kakao.com 을 도메인네임이라고 하며 , 
 * 자바의 패키지이름은 보통 이것을 com.kakao.developers 와 같이 높은 단계 부터 표시하여 이름을 정한다.
 * 클래스의 소속 그룹을 표시하는 이름이다. 자바 객체지향프로그램은 클래스 단위로 작성이 돕니다. 개발자가 클래스 이름을 정합니다.
 */
public static void main(String[] args){

    //1. 데이터저장
    int myage = 19;
    double weight = 57.891234567890;
   // boolean isAdult;
    //char grade = 'C';

    //2. 데이터 값 변경 - 대입문 또는 연산자 활용
    //예) 한달 후에 1.3kg 감량된 몸무게
    weight = weight -1.3;
    //weight -=1.3;

    //예) 7년 동안 직장생활을 열심히하면 나이가 몇살이 되나요?
    myage = myage+7;
    //age +=7;
    
    //isAdult= myage>=20;
    //grade ='B';
 
        
    }
}
    

