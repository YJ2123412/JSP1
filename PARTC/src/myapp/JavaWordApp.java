package myapp;

import java.util.List;
//import java.util.Map;
import java.util.Scanner;

public class JavaWordApp {
    public static void main(String[] args) {
        //단어장을 시작하는 프로그램
        //1. 단어장 생성
        JavaWordBook mybook = new JavaWordBook();


        //2. 단어추가
        JavaWord newWord = new JavaWord("public", "공용의", 1);
        mybook.addWord(newWord);
        mybook.addWord(new JavaWord("private", "개인적인", 1));
        mybook.addWord(new JavaWord("protected" , "보호하는", 1));
        mybook.addWord(new JavaWord("iterate", "반복하다", 3));
        mybook.addWord(new JavaWord("Collection", "수집",2));
        mybook.addWord(new JavaWord("application", "응용프로그램",3));
        mybook.addWord(new JavaWord("binary", "2진수의",3));

        //메모장 출력
        mybook.wordAllPrint2();
        mybook.Print();

        //3. 단어 조회
        //1)영단어 입력하면 찾아주기
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 영단어를 입력하세요>>");
        String findText = sc.nextLine();
        JavaWord result = mybook.searchWord(findText);
        System.out.println(findText+" 조회결과: "+ result);
        

        //2) public List<JavaWordX> searchWordByLevel(int level) //: 레벨로 조회하기
        // ??? JavaWordBook.wordListPrint(list);

        System.out.print("레벨을 선택하세요");
        int findLevel = sc.nextInt();
        List<JavaWord> result2 = mybook.searchWordByLevel(findLevel); //List인 경우는 여러개이기 때문에
        System.out.println(findLevel+" 조회결과: "+ result2);


        //4. 단어 삭제
        System.out.print("삭제할 영단어를 입력하세요 >>");
        sc.nextLine();
        String del2 = sc.nextLine();
        mybook.removeWord(del2);
        System.out.println(del2+ "단어가 삭제되었습니다. 메모장 새로 출력");
        mybook.wordAllPrint2();
        
        sc.close();



    }
    
}
