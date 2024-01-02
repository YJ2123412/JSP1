package basic.day3;

public class A16MaxMinValue {
    public static void main(String[] args) {
        
        int n1= 23,  n2= 34, n3 =32;
        int min,max;
        //1)조건식이 참/거짓 각각 실행명령어가 다름
        if(n1<n2){
          min=n1;
          max=n2;
        } else {
          min=n2;
          max=n1;
        }  
        
        //2) 조건식이 참일때만 실행하는 명령어가 있음
        //참 또는 거짓일때 실행하는 명령문이 1개이면{}생략하고 할 수 있음
        if(min>n3) min=n3;
        if(max<n3) max=n3;
        
        System.out.println("최소값 min = "+ min);
        System.out.println("최소값 max = "+ max);
    }
}
