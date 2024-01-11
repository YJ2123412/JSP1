package object.day06;

import java.util.Scanner;
    
public class AddQuizMain {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AddQuiz[] addQuizArray = new AddQuiz[10];


    System.out.println("덧셈 10문제 퀴즈를 시작합니다.");
    for(int i = 0; i < 10; i++) { 
        int data1 = (int)(Math.random()*89)+11;    //11~99 사이의 무작위 숫자 1개 저장
        int data2 = (int)(Math.random()*89+11);    //11~99 사이의 무작위 숫자 1개 저장
        System.out.println(i+1 + "번 .  " + data1 + "+" + data2 + "=  ?");
        System.out.println("답  입력하세요. >>> ");
        int userAnswer = sc.nextInt();
        AddQuiz addQuiz = new AddQuiz(data1, data2, userAnswer);
        addQuizArray[i] = addQuiz;  //i번째 위치에 addQuiz 객체 저장
    }

    int count = 0;
    System.out.println("::::::  채점 하고 있습니다.  ::::::");
    System.out.println("\t문제\t\t제출한답\t정답\t\t\0채점");
    for(int i = 0; i < addQuizArray.length; i++) {
        AddQuiz addQuiz = addQuizArray[i];
        String result; //채점 결과 OX 표시값
        if(addQuiz.isRight()) {
            count++;
            result = "O";
        } else {
            result = "X";
        }
        System.out.println((i + 1) + "번.\t" + addQuiz.getData() + "+" + addQuiz.getData2() + "\t\t"
                + addQuiz.getUserAnswer() + "\t\t"
                + addQuiz.getRightAnswer() + "\t\t"
                + result);
    }
    System.out.println();
    System.out.println(":::맞은 갯수 " + count + " 입니다.:::");
    sc.close();
    }
}




        

    
    
    

    

