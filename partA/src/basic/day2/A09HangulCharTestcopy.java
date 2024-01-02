package basic.day2;

public class A09HangulCharTestcopy {
    public static void main(String[] args) {
        //문자 나~낟까지 모두 출력, 갯수 구하기
        char start = '나';
        int codeNa=start;
        int codeNet='낟';
          System.out.println("\n돌리기전: "+start);

        while(start<=codeNet){
            System.out.print(start++);
        }

        //이 시점에서의 start
       System.out.println("\n돌린 후 : "+start);
       System.out.println(codeNet);
       System.out.println("\n'나'에서 '낟'까지의 문자갯수는 "+(codeNet-codeNa+1)+"개 입니다.");



    }
    
}
