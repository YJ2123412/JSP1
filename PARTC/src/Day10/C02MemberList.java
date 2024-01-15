package Day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C02MemberList {
    public static <T> void main(String[] args) {
        
        List<Member> list = new ArrayList<>();
        Member momo = new Member("momo", 23);
        list.add(momo);


        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("momo", 25));
        list.add(new Member("dahy", 21));
        list.add(new Member("sana", 26));

        //hashcode, equals 메소드 재정의 하기 before&after 를 비교하시오
        //컴파일러는 객체의 hashcode같으면 equals 검사. 둘 다 통과시 동일객체로 결정
        //                  ㄴremove,indexOf 메소드에 동일 객체 검사할때 사용
        //


        System.err.println("현재 리스트내용: "+list +", size: "+list.size());
        
        list.remove(new Member("momo", 23));
        System.err.println("현재 리스트내용: "+list+", size: "+list.size());

        System.out.println("특정 멤버 조회: "+list.indexOf(new Member("momo", 25)));
        //new Member("momo",23)에서 인스턴스 필드값이 같다고 동일한 객체가 아님. remover, indexOf등의 메소드는 동일한 객체를 찾아서 삭제하거나 조회함
        //참고:String은 문자열 리터럴이 같으면 주소가 같음(불변객체)
        //일반적으로 만들어진 클래스는 hashcode로 메모리의 참조위치가 결정됨
            //인스턴스 필드 내용이 같으면 hashcode를 동일하게 만들도록 재정의
        
            Comparator<Member> ageDecending = new Comparator<Member>() {
                @Override
                public int compare(Member o1, Member o2) {
                    return o2.getAge()- o1.getAge() ;
                }
            //내림차순 o1>o2이 되어야 함. 만약 o2-o1<0이면 교환하지 않음
    
            };

        list.sort(ageDecending);
        System.out.println(list);
        
        //list.sort(null);

            //정수, 실수, 문자열 타입은 list.sort(null)로 오름차순 정렬, 그 이외에는 comparator를 구현해야함

            //list의 static 메소드
            //테스트용 리스트 만들때 주로 사용.. (불변객체임)
            List<String> names = List.of("momo","dahy","nana");
            System.out.println("names: "+names);

    


            List<Integer> list2 = new ArrayList<>();
            list2.add(1); 
            list2.add(4); 
            list2.add(6); 
            list2.add(2); 
            list2.add(5);
            System.out.println("정렬 전  : " + list2.toString());
            list2.sort(null);
            System.out.println("오름차순 : " + list2.toString());
               

    }
}
