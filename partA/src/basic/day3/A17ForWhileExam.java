package basic.day3;

public class A17ForWhileExam {
    public static void main(String[] args) {
        //반복문 for가 활용되는 예시

        String message = "Hello, World~ Hoi";

        System.out.println("1.문자열 길이 만큼 문자 1개를 추출하는 반복문 실행하기");
        for(int i=0; i<message.length(); i++) {
           char temp = message.charAt(i);
           System.out.println("i="+i+",문자 ="+temp);
        }

        //for문을 while문으로 바꾸기
        System.out.println("==========k while문================");
        int k = 0;
        while(k<message.length()){
            char temp = message.charAt(k);
            System.out.println("k="+(k++)+",문자 = "+temp);
            //k++;
        }
        //System.out.printf("k는 %d이고, 문자는 %s이다", k, "temp");
        System.out.println("\n 2. 문자열 길이만큼 반복문의 실행하면서 if 조건문으로 문자열 검사하기");
        System.out.println("\t 문자열에서 알파벳 o의 갯수 구해봅시다. "); //char 비교는 ==
        int count = 0;

        for(int i = 0; i<message.length(); i++){
            char temp = message.charAt(i);
            if(temp == 'o'){
                count++;
            }
        }
        System.out.println("count의 수는: "+count);
    }
}
