package basic.day3;

public class A15MinValue {
    public static void main(String[] args) {
        
        int n1= 23,  n2= 34, n3 =32;
        int min;
        //가장 작은 값을 찾기(min)
        //1)조건식이 참/거짓 각각 실행명령어가 다름
        if(n1<n2){
          min=n1;
        } else {
          min=n2;
        }  
        
        //2) 조건식이 참일때만 실행하는 명령어가 있음
        if(min>n3){
            min=n3; 
        } 
        System.out.println("if문: "+ min);

        System.out.print("삼항연산자로 다시 구하기: ");
        n1=99; n2=88; n3 =77;

        //조건 삼항연산을 대입문에 활용해보기
        min = n1<n2? n1:n2;
        min = min>n3? n3: min;
        System.out.println(min);



    }
}
