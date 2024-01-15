package Day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {
    
    public static void main(String[] args) {
        
        Set<String> set = new HashSet<>();
        set.add("트와이스");
        set.add("아이브");
        set.add("잇지");
        set.add("뉴진스");
        set.add("트와이스");
        set.add("소녀시대");
        System.out.println("~~~~~~~~~~`HashSet~~~~~~~~~~~");
        System.out.println("set: "+set);
        System.out.println("set size: "+set.size());
        
        //본래의 set은 순서가 없으므로 무작위 접근
        //Linked는 다음 입력데이터의 참조값을 저장하여 입력순서대로 접근
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("트와이스");
        set2.add("아이브");
        set2.add("잇지");
        set2.add("뉴진스");
        set2.add("트와이스");
        set2.add("소녀시대");
        System.out.println("~~~~~~~~~~`LinkedHashSet~~~~~~~~~~~");
        System.out.println("set: "+set2);
        System.out.println("set size: "+set2.size());
        
        
        //이진트리 알고리즘을 이용하여 데이터를 정렬된 방식으로 접근
        
        Set<String> set3 = new TreeSet<>();
        set3.add("트와이스");
        set3.add("아이브");
        set3.add("잇지");
        set3.add("뉴진스");
        set3.add("트와이스");
        set3.add("소녀시대");
        System.out.println("~~~~~~~~~~TreeSet~~~~~~~~~~~");
        System.out.println("set: "+set3);
        System.out.println("set size: "+set2.size());

        //set인덱스 없습니다, for i 와 같은방식은 불가
        
        
        
        



        
    }
}
/* 
 * Set : 수학시간에 배운 집합
 * 순서(인덱스)가 없음, 중복값이 없음
 * Map의 구성요소: key, value 중에서 key는 set특성을 갖고 있음
 * 
 */
