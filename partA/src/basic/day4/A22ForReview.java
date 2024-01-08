package basic.day4;

public class A22ForReview {
    public static void main(String[] args) {
        //for문으로
        //1. 1부터 정수 n까지 더하기, 2. 곱하기
        //3. 시작값 정수 m부터 마지막값까지 더하기
        //4. 시작값 정수 m부터 마지막값까지 곱하기
        //5. 2의 n승 구하기 :2를 n번 곱하기(2진수에서는 많이 사용되는 연산)
        //6. 구구단

        int m;
        int n;
        int sum=0;

        //1. 1부터 정수 n까지 더하기
        n=10;
        System.out.printf("1~%d 더하기는: %d", n, sum);
        for(int i =1; i<=n; i++){
            sum+=i;
        }

        //2. 1부터 정수 n까지 곱하기 / int타입은 정수 -2147483648~ +2147483648
        //n=20으로 int result에 결과를 저장하면 - 음수값이 나옴(오버플로우)
        n=15;
        long longresult = 1;
        for(int i =1; i<=n; i++){
            longresult*=i;
        }
        System.out.printf("\n 1~ %d 곱하기는: %,d", n, longresult);

        //3 시작값 정수 m부터 마지막값까지 더하기
        m=5; n=8;
        sum=0;
        for(int i =m; i<=n; i++){
            sum+=i;
        }
        System.out.printf("\n %d ~ %d 더하기는: %,d", m, n, sum);

        //4 시작값 정수 m부터 마지막값까지 곱하기
        longresult = 1;
        m=5; n=8;
        for(int i =m; i<=n; i++){
            longresult*=i;
        }
        System.out.printf("\n %d ~ %d 곱하기는: %,d", m, n, longresult);
        
        //5  2의 n승 구하기 :2를 n번 곱하기(2진수에서는 많이 사용되는 연산)
        n=4;
        longresult = 1;
        for(int i =1; i<=n; i++){
            longresult*=2;
        }
        System.out.printf("\n 2의 %d승은: %,d", n, longresult);

        //5. 구구단
        System.out.println("\n\t\t\t\t\t\t-----------------------------구구단------------------------------");
        sum=0;
        for(int i = 2; i<=9; i++){
            for(int j =1; j<=9; j++){
                System.out.printf("\t%d X %d : %d", i, j, i*j);
            }
            System.out.println();
        }

    }
    
}
