package Day12.Io;

public class D03StandardIOTest {
    public static void main(String[] args) {
    //표준 입출력 테스트
    //키보드 입력: Scanner, console

    int b;
    System.out.println("입력하세요  ↓");
    //표준 입출력은 모든 글자가 2byte
    try {
        int count = 0;
        while ((b=System.in.read())!=-1) {   //-1 = ctrl+z (입력끝) +엔터
            //b=System.in.read(); ->원초적 입력        
            //System.out.println(b); ->문자 인코딩 안하고 정수값 출력
            //System.in.read() 로 입력받은 정수값을 문자로 인코딩 하는 메소드
            System.out.write(b);    //설명보류
            count++;
        }
        System.out.println("총 입력 바이트 수 : "+count);
        
        
    } catch (Exception e) {
        System.out.println("예외: "+e.getMessage());
    }
    
    

    }
}
