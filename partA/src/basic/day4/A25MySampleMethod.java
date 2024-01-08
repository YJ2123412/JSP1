package basic.day4;

public class A25MySampleMethod {

    //1. 1부터 정수 n까지 더하기
    public static long sumToN(long n){
        long sum = 0;
        for(int i =1; i<=n; i++){
            sum+=i;
            }
            return sum;
        }
        
    //2. 1부터 정수 n까지 곱하기    
    public static long multiply1ToN(long n){
        long longresult = 1;
        for(int i =1; i<=n; i++){
            longresult*=i;
            }
            return longresult;
        }
        
    //3) sumMToN
    public static long sumMToN(long m, long n){
        long sum=0;;
        for(long i = m; i<=n; i++){
            sum+=i;
        } 
        return sum;
    }

    //4. multiplyMToN 
    public static long multiplyMToN(long m, long n){
       long longresult = 1;
       for(long i =m; i<=n; i++){
        longresult*=i;
        }
        return longresult;
    }

    //5)multiplyNof2
    public static long multiplyNof2(long n){
        long longresult = 1;
        for(int i =1; i<=n; i++){
            longresult*=2;
        }
        return longresult;
    }

    //6. 구구단 printGuguDan
    public static void printGuguDan(){
        for(int i = 2; i<=9; i++){
            for(int j =1; j<=9; j++){
                System.out.printf("\t%d X %d : %d", i, j, i*j);
            }    
            System.out.println();
        }

    }

            public static void main(String[] args) {
          
            //1. 1부터 정수 n까지 더하기 - sumToN
            //2. 곱하기 - multiply1ToN
            //3. 시작값 정수 m부터 마지막값까지 더하기 - sumMToN
            //4. 시작값 정수 m부터 마지막값까지 곱하기 - multiplyMToN
            //5. 2의 n승 구하기 :2를 n번 곱하기 - multiplyNof2
            //6. 구구단 - printGuguDan

            System.out.println("sumToN: "+sumToN(4));
            System.out.println("multiply1ToN: "+multiply1ToN(4));
            System.out.println("sumMToN: "+sumMToN(5, 8));
            System.out.println("multiplyMToN: "+multiplyMToN(5, 8));
            System.out.println("multiplyNof2: "+multiplyNof2(4));
            printGuguDan();
            

            }
            

}
