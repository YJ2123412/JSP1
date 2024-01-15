package Day11;

import java.util.ArrayList;
import java.util.List;

import myapp.JavaWord;

public class JavaWordApp_V2 {
    //private은 현재 클래스에서만 사용할 목적으로 접근제한
    private List<JavaWord> words = new ArrayList<>();

//메소드만드는 연습 - 검색메소드, print 메소드 리팩토링


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
            System.out.println("\t 6. 새로운 프로그램 실험");
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

                case 6: searchWordBy(); break;
                default:
                System.out.println("잘못된 선택값입니다.");
                    break; //switch문 내를 빠져나가는 것이기에 있어도되고 없어도 됨 
            }//seitch end
        }//while end
    }//start end

    private void initialize() {//words 리스트 요소를 몇개만 저장해서 초기화 (테스트)
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("public", "공용의", 2));
        words.add(new JavaWord("public", "공용의", 3));
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

        //새로운 메소드 정의
        //단어검색1: 첫 번째로 일치하는 결과만 리턴
        ///메소드 인자를 입력데이터로 하여 메소드의 코드가 실행되고 결과는 출력으로 리턴
        private JavaWord searchFirstWord(String english){
        for (JavaWord word : words) {
            if(word.getEnglish().equals(english)){ 
                return word; //인자로 전달된 english와 같은 word 리턴
              }
            } return null; //찾는 english 없으면 for문이 리스트 모두 반복후 종료. null 리턴
        }

        private List<JavaWord> searchAllWord(String english){
            List<JavaWord> list = new ArrayList<>(); //검색결과를 저장할 리스트
            for(JavaWord word: words){
                if(word.getEnglish().equals(english)){
                    list.add(word); //일치하는 단어를 만날때마다 저장할 리스트
                }
            }
            return list;
        }

        private List<JavaWord> searchLevel(int level){
            List<JavaWord> level2 = new ArrayList<>(); 
            for(JavaWord word: words){ 
                if(word.getLevel()==level){
                    level2.add(word);
                    }
                }
                return level2;
            }
        
        //searchWord 메소드를 업그레이드
        private void searchWordBy(){
            System.out.println("\t:::단어를 검색합니다 :::(단어 조회는 1, 레벨 조회는 2)");
            String find = null;
            List<JavaWord> list = null;
            switch (System.console().readLine()) {
                case "1":
                    System.out.println("검색할 단어를 영문으로 입력하세요_");
                    find = System.console().readLine();
                    list = searchAllWord(find);
                    break;
                case "2":
                    System.out.println("검색할 레벨을 입력하세요._");
                    list = searchLevel(Integer.parseInt(System.console().readLine()));
                    break;
            
                default:
                    System.out.println("1,2만 입력하세요");
                    return;
            }
            System.out.println("\t:: 검색 결과 입니다.::");
            if(list.size()==0) System.out.println("찾는 단어가 단어장에 없습니다.");
            else printWordList(list);
        }

        private void searchWord(){
            System.out.println("\t:::단어를 검색합니다 :::");
            System.out.println("검색할 단어를 입력하세요 : _");
            String find = System.console().readLine();
            //2. 단어 여러개 리턴할때
            List<JavaWord> result = searchAllWord(find);
            System.out.println(result);
            if(result.size()==0)
                System.out.println("찾는단어가 단어장에 없습니다.");
            else 
                printWordList(result); //출력할 리스트 result를 메소드에 전달
                //System.out.println("result: "+result);
        }

    //출력할 여러개의 JavaWord 객체를 전달받아 이쁘게 화면에 프린트하기
    private void printWordList(List<JavaWord> list){
    for(JavaWord word : list){
        System.out.println(String.format("%-20s %-30s %-20s", word.getEnglish(),word.getKorean(),word.getLevel()));
        } 
    }

    private void listWord() {
        //리스트 words에 저장된 요소들을 모두 출력해보세요
        System.out.println("단어 목록 출력합니다");
        System.out.println(String.format("%-20s %-30s %-20s" , "English","Korean","Level"));
        printWordList(words); //출력할 리스트 words를 메소드에 전달
    }
        
    private void removeWord() {
        boolean isFind = false;
        System.out.println("\t:::삭제할 단어를 영어로 입력하세요 :::");
        String remove = System.console().readLine();
        for (int i = 0; i < words.size(); i++) { 
            if(words.get(i).getEnglish().equals(remove)){
                isFind = true; //한번이라도 true가 되면 알아서 돌아가기에 true가 아닐상황을 else로 굳이 만들지 않아도됨
                    System.out.println("단어를 찾았습니다"+words.get(i));
                    System.out.println("단어를 정말 삭제하시겠습니까? 1. 네  2. 아니오");
                    int choice = Integer.parseInt(System.console().readLine());
                    if(choice==1){
                        System.out.println(words.get(i)+"번 단어가 삭제되었습니다.");
                        words.remove(i);
                        i--;
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
        JavaWordApp_V2 app = new JavaWordApp_V2();
        app.start();
    }
}
