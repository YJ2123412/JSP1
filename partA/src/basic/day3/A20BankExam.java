package basic.day3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A20BankExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int money; //입력한값
        int balance=0; //잔액
        boolean run =true;
        //세자리마다 컴마찍기
        DecimalFormat df = new DecimalFormat("#,### 원");
        
        while (run) {
            System.out.print("--------------------------------------------\n 1. 예금 | 2. 출금 | 3. 잔액 | 4. 종료\n--------------------------------------------\n");
            System.out.print("메뉴 선택 >>>> ");
            int menu = sc.nextInt();
            switch (menu){
                case 1 : 
                    System.out.print("예금액 > ");
                    money = sc.nextInt();
                    balance +=money;
                    System.out.println("고객님의 잔액은 "+ df.format(balance)+" 입니다.");
                    break;
                case 2:
                    System.out.print("출금액 > ");
                    money = sc.nextInt();
                     if(balance>money){
                        balance -=money;
                        System.out.println("고객님의 잔액은 "+df.format(balance)+" 입니다.");
                    } else if(balance<money){
                        System.out.println("잔액이 부족합니다");
                        continue;
                    }
                        break;
                case 3:
                    System.out.println("현재 잔액은 "+df.format(balance)+" 입니다.");
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    run=false;
                    break;
                default: 
                    System.out.println("잘못된 입력입니다. 1~4만 입력하세요");
            }
        }   
        System.out.println("코드 변경 확인인");
        sc.close();
    }
    
}
