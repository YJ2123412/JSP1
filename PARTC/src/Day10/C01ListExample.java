package Day10;

import java.util.ArrayList;
import java.util.List;

public class C01ListExample {
    public static void main(String[] args) {
    

        List<String> strlist = new ArrayList<>();

        strlist.add("트와이스");
        strlist.add("잇지");
        strlist.add("아이브");
        strlist.add("원더걸스");
        strlist.add("레드벨벳");
        strlist.add("뉴진스"); //인덱스 5번

        System.out.println("문자열 List strList size: "+strlist.size());
        System.out.println("\n 데이터 추가");
        strlist.add("르세라핌"); //인덱스 6번
        System.out.println("항목 추가 후 리스트: "+strlist); //arrayList 클래스의 toString 재정의 메소드 실행

        System.out.println("\n 데이터 삭제");
        strlist.remove("원더걸스"); //remove 메소드 오버로딩
        strlist.remove(1);      //          ㄴ메소드 인자타입이 int와 String 2가지로 동작
        System.out.println("항목 삭제 후 리스트: "+strlist);

        //아래 2개 메소드 비교
        System.out.println("\n 데이터 항목 변경");
        strlist.add(2, "????"); // 새로 생김 - 중간삽입
        System.out.println(" ?? 항목변경 후 리스트: "+ strlist);
        strlist.set(2,"!!!!"); //수정
        System.out.println("!! 항목변경 후 리스트: "+ strlist);

        System.out.println("특정 위치의 인덱스 요소 값 가져오기");
        System.out.println("strlist.get(0): "+strlist.get(0));
        System.out.println("strlist.get(3): "+strlist.get(3));
       // System.out.println("strlist.get(9): "+strlist.get(9));//오류. 항목없음

       List<String> strlist2 = new ArrayList<>();
       strlist2.add("소녀시대");
       strlist2.add("드림캐쳐");

       //조회하기
        //addAll
        strlist.addAll(strlist2);
        System.out.println("addAll 항목변경 후 리스트: "+ strlist);
        strlist.add("아이브");
        System.out.println("add 중복 항목변경 후 리스트: "+ strlist);
        
        //contains
        System.out.println(strlist.contains("소녀시대"));
        System.out.println(strlist.contains("소녀시대"));
        System.out.println("addAll 항목 중복 추가 후 리스트: "+ strlist); //->추가x
        System.out.println(strlist.contains("투바투"));
        
        //indexOf
        System.out.println(strlist.indexOf("레드벨벳"));

        //lastIndexOf
        System.out.println(strlist.lastIndexOf("아이브"));









/* 
 * List 구현 클래스 특징: 배열처럼 인덱스를 가짐 = 데이터의 순서가 있다는 것
 * 배열에 없는 삭제기능이 있음+조회기능.. 조작과 조회를 다양하게 할 수 있음
 * length 말고 size
 * 
 * 
 * 
 */
}



    
}
