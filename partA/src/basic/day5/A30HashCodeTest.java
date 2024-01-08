package basic.day5;

public class A30HashCodeTest {
    public static void main(String[] args) {
        int[] iArray = new int[10];
        String msg = "Hello! world~";

        //hashcode는 참조값(식별값-주소)을 만들기 위해 해쉬함수로 생성된 결과
        //hashcode = 참조값
        System.out.println(iArray); //배열의 식별값을 보여줌
        System.out.println("초기 해시코드 값: "+iArray.hashCode()); // 해쉬코드값을 가져옴(10진수)
        System.out.println(Integer.toHexString(iArray.hashCode()));//10진수를 16진수로 변환

        iArray[3] =99;
        System.out.println("배열 요소값이 변경된 해시코드 값: "+iArray.hashCode());
        //결론: 배열값이 변경되어도 메모리의 주소가 바뀌진 않음

        System.out.println("String 배열 msg의 해시코드값: "+msg.hashCode());
        msg = msg+"~Good";
        System.out.println("String 배열값이 바뀐 msg의 해시코드값: "+msg.hashCode());  
        //결론: 문자열은 내용이 변경되면 메모리의 위치가 바뀜      

        //객체란? 여러종류의 데이터가 모여있는 데이터 덩어리(기본형은 데이터 저장의 최소단위)
        //객체는 참조형 변수를 사용(변수가 주소를 저장)
        //객체를 메모리에 저장-> 초기 저장 데이터를 바꿀 수 있음(배열) - 가변객체
        //->초기 저장 데이터를 바꿀 수 없음(String) - 주소가 달라지기에..  불변객체 (새로 생기는 것과 같음..


    }
    
}
