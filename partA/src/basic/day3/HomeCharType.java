package basic.day3;

import java.util.Scanner;

public class HomeCharType {
    public static void main(String[] args) {
        //공백도 기호
        //문자열 임의 저장 , 아스키코드, 기호 주의->char로 잘 세야할듯??
        //대문자, 소문자, 숫자, 기호 중 어떤 종류인지 검사

        Scanner sc = new Scanner(System.in);
        int upperCount=0; //대문자
        int lowerCount=0; //소문자
        int numberCount=0; //숫자
        int symbolCount=0; //기호

        System.out.println("문자를 입력하세요");
        String msg = sc.nextLine();

        for(int i =0; i<msg.length(); i++){
            if(65 <= msg.charAt(i) && msg.charAt(i) <=90){
                upperCount++;
            } else if(97 <= msg.charAt(i) && msg.charAt(i) <=122){
                lowerCount++;
            } else if(48 <= msg.charAt(i) && msg.charAt(i) <=57 ){
                numberCount++;
            } else {symbolCount++;}
        }

        System.out.println("문자열: "+msg);
        System.out.println("문자 종류: 대문자 "+upperCount+"개, 소문자 "+lowerCount+"개, 숫자 "+numberCount+"개, 기호 "+symbolCount+"개");

        //-------------------------------------------------------------
        String str =" MessaGe";
        int count = 0;
        for(char c : str.toCharArray()){
         if(Character.isUpperCase(c)){
            count++;
            }}
        System.out.println("count = "+count);

        sc.close();
    }
    
}

