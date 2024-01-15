package Day12.Io;

import java.io.FileOutputStream;
import java.io.IOException;

public class D04keyInputFileOut {
    
    //키보드 입력-> 파일로 출력

    public static void main(String[] args) {
        
        int b;
        System.out.println("입력하세요");
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("note.txt");
            //인자로 파일명을 전달
            int count = 0;
        while ((b=System.in.read())!=-1) {   //-1 = ctrl+z (입력끝) +엔터
         
            fos.write(b);    //파일 출력스트림으로 데이터 보내기
            count++;
        }
        System.out.println("총 입력 바이트 수 : "+count);
        } catch (IOException e) {
            System.out.println("예외: "+e.getMessage());

        }finally{
            //입출력 자원해제는 여기서 하세요. 예외 발생 상관없이 처리할 명령어
            try {fos.close();
            } catch (Exception e) {}  //간략하게 정리 O
        }


    }
}
//File Input -> 화면(표준) 출력
//File Input -> File Output (이미지 파일 복사)
//바이트 기반은 문자형식의 타입이 아닐때 주로 쓰임
//문자 기반 스트림 : 문자 단위 입출력.
