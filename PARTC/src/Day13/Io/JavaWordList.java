package Day13.Io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Day11.myapp.JavaWord;

   

public class JavaWordList implements WordList {
    //최후 정리: 자바단어장 클래스에 적용될 인터페이스 생성
    
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.

    private List<JavaWord> wordsList;
    private static String filePath = "C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\Wordtest.txt";
 
    //새로운 단어등록, 기존단어 삭제 등의 변경사항을 파일에 저장하기
    public void filesave(){
        File flie = new File("C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\Wordtest.txt");
        try (
            PrintWriter pw = new PrintWriter(flie);
        ){
            for(JavaWord word: wordsList){
                pw.println(word);
            }
            //words에 있는 리스트의 모든 데이터를 파일로 출력하기
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    @Override
    public String toString() {
        return "JavaWordList [wordsList=" + wordsList + "]";
    }


    //단어장에서 데이터 받아와서 리스트에 담기
     public void fileLoad(){
        try (
            BufferedReader br = new BufferedReader(new FileReader(filePath));
        ){
            String line;    //라인 단위로 읽어서 저장할 변수 
            while ((line =br.readLine())!=null) {  
                if(line.trim().length() ==0) continue; // 빈줄은 skip
            String[] temp = line.split(",");
                if(temp.length !=3) continue; //배열 크기는 반드시 3
            JavaWord word = new JavaWord(temp[0].trim(),temp[1],Integer.parseInt(temp[2]));
            wordsList.add(word);
        }}catch(Exception e){e.getMessage();}
            }


    
    public JavaWordList(String filepPath) {
        System.out.println("최대 단어 저장 개수: "+WordList.MAX_LENGTH);
        wordsList = new ArrayList<>();
        this.filePath=filepPath;
    }

    // 지정된 인덱스 i 의 JavaWord 객체 리턴
    @Override
    public JavaWord getWord(int i) {
       return wordsList.get(i);
    }

    //단어장 전체 리스트 리턴
    @Override
    public List<JavaWord> list() {     //getWords 에서 이름 변경
        return wordsList;
    }

    //단어 추가
    @Override
    public void add(JavaWord javaWord) {
       /*  if(wordsList.size()==WordList.MAX_LENGTH){
            System.out.println("단어장이 꽉 찼습니다"); */
            if(wordsList.size()==5){//오류만들기
            throw new IllegalArgumentException("단어장이 꽉 찼습니다. 5개 초과");            
          //return;
        }
        wordsList.add(javaWord);
    }

    //전달받은 영어 단어의 인덱스를 배열로 리턴합니다.-조회 및 삭제 기능에 사용할 새로운 메소드
    @Override
    public int indexOfWord(String english,int position){
        for(int i=position;i<wordsList.size();i++){
            if(wordsList.get(i).getEnglish().equals(english))
                return i;       //찾으면 인덱스 리턴
        }   
        return -1;
    }

    //단어를 인덱스로 삭제
    @Override
    public JavaWord remove(int index) {
        if(index<0||index>wordsList.size())
            throw new IllegalArgumentException("삭제할 인덱스 범위가 잘못되었습니다.");
            //throw new Exception(""); ->예외처리를 해주어야함
            //새로운 Exception 객체를 생성하면 개발자가 만든 예외가 발생
            //예를 들어 웹개발시 모든 예외를 한번에 처리하기 위해 사용
        JavaWord word = wordsList.remove(index);
        return word;
    }

    //단어 1개 조회(여러개 일때는 처음 1개)
    
    public JavaWord searchFirstByEnglish(String english) {
        for(JavaWord word : wordsList) {
            if(word.getEnglish().equals(english)) {
                return word;        //인자로 전달된 english 와 같은 word 리턴(메소드 종료)
            }
        }
        return null;            
    }
    
    //단어 목록 조회
    @Override
    public List<JavaWord> searchAllByEnglish(String english){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : wordsList) {
            if(word.getEnglish().equals(english)) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    public List<JavaWord> searchAllByLevel(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : wordsList) {
            if(word.getLevel()==level ) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }
    @Override
    public void print(){
        for(JavaWord word : wordsList) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
   
    // 출력 메소드 
    
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }



    public void add(String string, String string2, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}