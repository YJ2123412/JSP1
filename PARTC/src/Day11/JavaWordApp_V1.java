package Day11;

import java.util.ArrayList;
import java.util.List;

import myapp.JavaWord;

public class JavaWordApp_V1 {
    //private은 현재 클래스에서만 사용할 목적으로 접근제한
    private List<JavaWord> words = new ArrayList<>();


    //프로그램 실행을 시작하는 메소드
    private void start(){
        initialize();
        //단어 등록, 목록, 검색, 삭제 기능을 메뉴로 구현
        System.out.println("단어장 프로그램 시작합니다"+"~".repeat(30));
        while (true) {
            System.out.println("\n\t <메뉴를 선택하세요.>");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 출력");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.print("선택>> "); //메소드에 입력기능이 있을때는 Scanner 관리가 불편
            int select = Integer.parseInt(System.console().readLine()); //키보드 입력 문자열 ->정수 (parseInt는 정수로 바꿔주는 것)
            //System.console() 시스템의 콘솔(표준 입출력 장치) 객체를 리턴
            //readLine : 입력메소드
            switch (select) {
                case 1:
                    addWord(null); //단어등록 메소드 실행
                    break;
            
                case 2: listWord(); break;//단어 목록 조회 메소드 실행

                case 3: searchWord(); break; //단어검색 메소드 실행
                   
                case 4: removeWord();  break;//단어 삭제 메소드 실행
                
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    listWord(); //프로그램 종료 메소드 실행
                    System.exit(0); //main 종료
                    break;
                
                default:
                System.out.println("잘못된 선택값입니다.");
                    break; //switch문 내를 빠져나가는 것이기에 있어도되고 없어도 됨 
            }//seitch end
            
        }//while end
    }//start end

    private void initialize() {//words 리스트 요소를 몇개만 저장해서 초기화 (테스트)
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("private", "개인적인", 1));
        words.add(new JavaWord("protected" , "보호하는", 1));
        words.add(new JavaWord("iterate", "반복하다", 3));
        words.add(new JavaWord("Collection", "수집",2));
        words.add(new JavaWord("application", "응용프로그램",3));
        words.add(new JavaWord("binary", "2진수의",3)); 
    
    }

    private void addWord(JavaWord word){ 
        System.out.println("\t::단어 등록 합니다.::");
        System.out.print("영어 단어 입력하세요 . -");
        String english = System.console().readLine();
        System.out.print("한글 의미 입력하세요 . -");
        String korean = System.console().readLine();
        System.out.print("단어 레벨을 입력하세요 . (1. 초급, 2:중급, 3: 고급) _");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));
    }

    private void searchWord(){
        System.out.println("\t:::단어를 검색합니다 :::");
        System.out.println("검색할 단어를 입력하세요 : _");
        String find = System.console().readLine();
        boolean isFind = false;
        for (JavaWord word : words) {
            if(word.getEnglish().equals(find)){ 
                System.out.println("검색결과: "+ word.getEnglish()+" = "+word.getKorean()+", 레벨 "+word.getLevel());
                //return; //단어를 찾으면 찾는 메소드 종료 //같은 단어를 1번만 저장하게 할 때
                isFind = true; //2번의 짝 ( 같은단어가 2번이상 단어장에 있을 때 사용)
            }
            //return은 찾고서 바로 끝내버림, boolean은 찾아도 끝까지 도니까 여러개가 있는지 검사가능
        }
            if(isFind ==false) //이 if문 조건검사는 같은 단어가 2번 이상 단어장에 있을때 사용
                System.out.println("찾는 단어가 단어장에 없습니다"); //1, 2번의 짝
    }
    
    //리스트에 동일한 단어가 2번 저장되었다면? 
    // 리스트에 없는 단어를 조회한다면?

    private void listWord() {
        //리스트 words에 저장된 요소들을 모두 출력해보세요
        System.out.println("단어 목록 출력합니다");
        System.out.println(String.format("%-20s %-30s %-20s" , "English","Korean","Level"));
        for(JavaWord word : words){
        System.out.println(String.format("%-20s %-30s %-20s", word.getEnglish(),word.getKorean(),word.getLevel()));
        } 
    }
        
    private void removeWord() {
        boolean isFind = false;
        System.out.println("\t:::삭제할 단어를 영어로 입력하세요 :::");
        String remove = System.console().readLine();
        for (int i = 0; i < words.size(); i++) { 
            if(words.get(i).getEnglish().equals(remove)){
                isFind = true; //한번이라도 true가 되면 알아서 돌아가기에 true가 아닐상황을 else로 굳이 만들지 않아도됨
                    System.out.println("단어를 정말 삭제하시겠습니까? 1. 네  2. 아니오");
                    int choice = Integer.parseInt(System.console().readLine());
                    if(choice==1){
                        System.out.println(words.get(i)+"번 단어가 삭제되었습니다.");
                        words.remove(i);
                    }
            } 
        }
        if(!isFind){
            System.out.println("해당 단어가 단어장에 없습니다.");
        }
    }
    

    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고 start 메소드 프로그램 실행을 코딩
        //메소드로 기능을 분리할때 main이 호출하는 static을 없애기 위함 - static은 꼭필요할때만 만들기
        JavaWordApp_V1 app = new JavaWordApp_V1();
        app.start();
    
    
    }
}