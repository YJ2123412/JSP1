package object.day06;

import java.util.Scanner;

public class AddQuiz {
    Scanner sc = new Scanner(System.in);
    private int data;
    private int data2;
    private int userAnswer;


    public AddQuiz (int data, int data2, int userAnswer){
        this.data=data;
        this.data2=data2;
        this.userAnswer=userAnswer;
    }

    public boolean isRight(){
        return this.userAnswer == (this.data+this.data2);
    }

    public int getRightAnswer(){
        return data + data2;
    }

    
    public int getData() {
        return data;
    }
    public int getData2() {
        return data2;
    }
    public int getUserAnswer() {
        return userAnswer;
    }


    

    
   
}






 


