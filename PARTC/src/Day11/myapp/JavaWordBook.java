package Day11.myapp;

import java.util.Map;
import java.util.TreeMap;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//JavaWord 여러개를 저장할 클래스
//조회기능에 유리한 Map 사용
//굳이 리스트 대신 map을 사용한 이유: 조회를 편하게 하려고(리스트는 찾기위해 계쏙 비교해야함)
//조회 이외에는 특히 출력에는 map.values()로 value값만 사용

public class JavaWordBook {
    //javaword는 단어객체, javaWordBook은 단어장 객체
    private Map<String,JavaWord> wordBook;
    //key 영어단어, value: JavaWord(영어, 한글, 레벨)

    public JavaWordBook(){
        this.wordBook = new TreeMap<>();
        //key값인 영어 단어 순으로 정렬하여 접근
    }

    public Map <String, JavaWord> getWordBook(){ //getter
        return this.wordBook;
    }

    //단어추가
    public void addWord(JavaWord word){ 
        this.wordBook.put(word.getEnglish(), word); //get->기존의 단어들도 덮어쓰기 되는 것
    }

    //Map의 특징 - key 값을 이용해서 조회와 삭제 가능
    //단어 조회 -(비교)리스트에서는 for 반복을 찾기. 인덱스로 삭제
    public JavaWord searchWord(String english){
        return this.wordBook.get(english);
    }
     
    //레벨 조회
   /*  public JavaWord searchLevel(int level){
        return this.wordBook.get(level);
    } */
    

    //단어 삭제
    public void removeWord(String english){
        this.wordBook.remove(english);
    }


    public void wordAllPrint(){
        Iterator<String> iterator = wordBook.keySet().iterator();    // key 값으로 반복자를 생성
        int cnt = 0;
        while (iterator.hasNext()) {
            String temp = iterator.next();      // 반복자로 가져온 값은 key!!
            System.out.println(String.format("count=%d , key= %s , value=%s",cnt++,temp,wordBook.get(temp)));
        }
    }

    public List<JavaWord> wordAllPrint2(){
        //TreeMap은 정렬되어 있으므로 Map의 Value를 리스트로 변환하여 출력메소드로 전달하기
        List<JavaWord> all = new ArrayList<>(this.wordBook.values()); //***** */
        return(all);
    }

    //인자로 전달된 list 출력하기
    public static void wordListPrint(List<JavaWord> list){
        System.out.println("~".repeat(20)+"~단어장~"+"~".repeat(20));
        System.out.println(String.format("%-15s %-15s \t %s", "<english>","<korean>","<level>"));
        for(JavaWord word : list){ //for( A : B )는 B에서 꺼내 A에다가 넣어서 한바퀴 돌림림
            System.out.println(String.format("%-15s %-15s\t %d",word.getEnglish(),word.getKorean(),word.getLevel()));
        }

    }

    public void Print(){
        System.out.println("~".repeat(20)+"~단어장~"+"~".repeat(20));
        System.out.println(String.format("%-15s %-15s \t %s", "<english>","<korean>","<level>"));
        for(JavaWord word : this.wordBook.values()){ //for( A : B )는 B에서 꺼내 A에다가 넣어서 한바퀴 돌림림
            System.out.println(String.format("%-15s %-15s\t %d",word.getEnglish(),word.getKorean(),word.getLevel()));
        }

    }

    public List<JavaWord> searchWordByLevel (int level){
        List<JavaWord> results = new ArrayList<>();
        for(JavaWord word: this.wordBook.values()){
            if(word.getLevel()==level)
            results.add(word); // 값이 같은 것들이 List result에 저장되고 이후 출력됨 
        }
        return results;
    }
}

