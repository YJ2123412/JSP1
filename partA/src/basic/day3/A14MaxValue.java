package basic.day3;

public class A14MaxValue {
    public static void main(String[] args) {
        
        int n1= 23,  n2= 34, n3 =32;
        int max;
        //가장 큰 값을 찾기(max)
        //1)조건식이 참/거짓 각각 실행명령어가 다름
        if(n1>n2){
          max=n1;
        } else {
          max=n2;
        }  
        
        //2) 조건식이 참일때만 실행하는 명령어가 있음
        if(max<n3){
            max=n3; 
        } 
        System.out.println("if문: "+ max);

        System.out.print("삼항연산자로 다시 구하기: ");
        n1=99; n2=88; n3 =77;
        //조건 삼항연산을 대입문에 활용해보기
        max = n1>n2? n1:n2;
        max = max<n3? n3: max;
        System.out.println(max);


        //System.out.println("삼항연산자로 다시 구하기: " + (n1>n2? (max = n1) : (max = n2)));
        



    }
}
