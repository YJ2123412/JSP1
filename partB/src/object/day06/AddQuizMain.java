package object.day06;

import java.util.Scanner;

public class AddQuizMain {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AddQuiz a= new AddQuiz();

    System.out.println("원하는 문제 개수를 적으시오: ");
    int num =sc.nextInt();
    a.setCount(num);
    System.out.println("덧셈 "+num+"문제를 시작합니다"); 
    a.quiz();
    a.answer();


    }
}
    
    

    

