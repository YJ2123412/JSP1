package Day10;


import java.util.Iterator;
//import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class C05MapExaple {
    public static void main(String[] args) {

        // Map<k, v> : key 값으로 value를 가져오기. key와 value는 모든 타입 Object 입니다.
        // : key는 중복된 값을 가질 수 없습니다. key와 value 모두 순서가 없습니다.
        // : 맴에 입력한 순서대로 접근해야 한다면 LinkedHashMap
        // : 또는 정렬(key 기준)된 방식으로 접근해야 한다면 TreeMap
        // Map의 구성요소 : key, value 중에서 key는 set 특성을 갖고 있다.

        Map<String, String> map = new TreeMap<>();//new LinkedHashMap<>();//new HashMap<>();
        map.put("tw", "트와이스");
        map.put("nu", "뉴진스");
        map.put("as", "에스파");
        map.put("gr", "소녀시대");
        map.put("tw", "원더걸스");
        map.put("js", "뉴진스");
        System.out.println("map 의 크기 = " + map.size());
        System.out.println("map 에 저장된 문자열 = " + map);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("찾을 값에 대한 key 입력하세요. >>>>");
            String key = sc.nextLine();
            if (key.equals("end"))  // end 입력하면 while 종료
                break;
                System.out.println("당신이 원하는 key의 값 = " + map.get(key));
            }        

        System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");
        System.out.println("\t Map.keySet() = " + map.keySet());    // 맵의 key만 가져와 set을 생성!
        Iterator<String> iterator = map.keySet().iterator();    // key 값으로 반복자를 생성
        int cnt = 0;
        while (iterator.hasNext()) {
            String temp = iterator.next();      // 반복자로 가져온 값은 key!!
            System.out.println(String.format("count=%d , key= %s , value=%s", 
                                                     cnt++,     temp,    map.get(temp)));
                                                     //         key      value
        }
        System.out.println("== for 반복자로 출력하기==");
        for (String key : map.keySet())     // map의 key 값들로 반복자 실행하기
            System.out.println(String.format("count=%d , key= %s , value=%s", 
                                                     cnt++,     key,    map.get(key)));
                                                     //         key      value
            
                                                     
        System.out.println("map.values()? "+map.values());
        //조회
        System.out.println("map.containsKey(\"tt\")? "+ map.containsKey("tt"));
        System.out.println("map.containsKey(\"js\")? "+ map.containsKey("js"));
        System.out.println("map.containsValue(\"에스파\") ? "+map.containsValue("에스파"));
        System.out.println("map.containsValue(\"잇지\") ? "+map.containsValue("잇지"));

    sc.close();


    }
}