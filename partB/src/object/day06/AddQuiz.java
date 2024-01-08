package object.day06;

import java.util.Scanner;

public class AddQuiz {
    Scanner sc = new Scanner(System.in);
    private int data;
    private int data2;
    private int userAnswer;

    public boolean isRight = false;
    public int count = 4;
    public int t = 0;
    public int[] d1 = new int[4];
    public int[] d2 = new int[4];
    public int[] u = new int [4];

    public void setCount(int count) {
        this.count = count;
    }
    
    public void quiz(){
        for(int i =0; i<count; i++){ 
            data = (int)(Math.random()*99+1);
            data2 = (int)(Math.random()*99+1);
            d1[i]= data;
            d2[i]= data2;}
        for (int j = 0; j < count; j++) {
            System.out.println(j+1+"번."+ d1[j]+"+"+d2[j]+"=?");
            System.out.print("답 입력하세요: ");
            userAnswer=sc.nextInt();
            u[j] =userAnswer;
        if(userAnswer == d1[j]+d2[j]){
            isRight = true;
            t++;
            }
        }}
    public void answer(){
        System.out.println("\n:::::채점 중입니다.:::::");
        System.out.println("\n     문제 \t\t제출한 답\t\t정답");
        for (int i = 0; i < count; i++) {
            System.out.println(i+1+"번. " +d1[i] +"+"+ d2[i] +"\t\t"+u[i]+"\t\t\t"+(d1[i]+d2[i]) );
            }    
        System.out.println("\n:::맞은 갯수는 "+t+"입니다.:::");
    }
    
}






 


