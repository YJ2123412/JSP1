package basic.day4;

import java.util.Scanner;

public class A26Test25 {
    public static void main(String[] args) {
        //A25MySampleMethod.
        Scanner sc = new Scanner(System.in);
        System.out.println("시작 값을 입력하세요: ");
        int start = sc.nextInt();
        System.out.println("마지막 값을 입력하세요");
        int end = sc.nextInt();

        System.out.println(start+"~"+end+"까지의 곱하기 결과: "+A25MySampleMethod.multiplyMToN(start, end));

        sc.close();

    }
}
