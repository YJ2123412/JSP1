package Day10;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class C06TodayMenuVote {
    
    //Map연습

    public static void main(String[] args) {
        
        String menu = "치킨, 스파게티, 곱창, 불고기, 삼겹살";
        Map <String,Integer> map = new LinkedHashMap<>();
        map.put("치킨", 0);
        map.put("스파게티", 0);
        map.put("곱창", 0);
        map.put("불고기", 0);
        map.put("삼겹살", 0);
        
        System.out.println("오늘의 메뉴 투표합니다");
        System.out.println("메뉴: "+menu);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("메뉴 이름 입력>>>");
            String key = sc.nextLine();
            //key를 입력하면 value가 올라야함
            if(key.equals("끝")) break;
            if(map.containsKey(key)){
                int value = map.get(key);
                map.put(key,++value);
                } else {
                System.out.println("투표에 없는 메뉴이군요. 다시하세요");
                map.put(key, 1); //새로운 메뉴 초기화
                menu+=","+key; //메뉴 문자열 수정
                };
        }
        System.out.println("투표가 종료되었습니다.");
        System.out.println(map);
        System.out.println(Collections.max(map.keySet())); //key 중의 최대값
        System.out.println(Collections.max(map.values())); // value 중의 최대값

        Comparator<Entry<String,Integer>> comparator = new Comparator<Entry<String,Integer>>(){
           public int compare(Entry<String,Integer> o1, Entry<String,Integer> o2){
            return o1.getValue() - o2.getValue();
            }
        };

        Entry<String,Integer> maxEntry = Collections.max(map.entrySet(),comparator);
        System.out.println("최다득표 결과");
        System.out.println("메뉴 이름 : "+maxEntry.getKey());
        System.out.println("투표수  : "+maxEntry.getValue());

        sc.close();
    }
}