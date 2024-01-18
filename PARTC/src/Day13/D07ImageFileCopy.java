package Day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D07ImageFileCopy {

    public static void main(String[] args) {
        
        long start = System.nanoTime(); //System에서 시간측정 메소드: 나노 세컨드(10억분의 일), ms 밀리 세컨드(1000분의 1), 

        //처리할 메소드
        //copyByByte();       //39,271,094,100 ns
        //copyByByteArray();  //218,921,800 ns
        copyByBuffer();       //59,000,600 ns
        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns",(end-start)));
    }
    
    public static void copyByByte() {
        int b; int count=0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\src\\Day13\\image.jpg");
            fos = new FileOutputStream("계곡복사.jpg");
            while((b=fis.read()) != -1){      //1바이트 씩 복사하기(파일fis에서 파일fos 로)
                fos.write(b);
                count++;
            }
        }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }finally {
            try{ fis.close(); fos.close();}
            catch(IOException e) {}
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
    // count : 1325184
    // 소요시간 : 30,395,863,100 ns

    public static void copyByByteArray() {
        int b; int count=0;
        byte[] buffer = new byte[1024]; //바이트 배열 이용, 1024바이트씩 입출력

        //try with resources - > try ()안에 close 해야 할 자원(리소스, 파일입출력)을 선언시, fianlly 없이 자동 close();
        //이때 자원은 Closeable 인터페이스 구현체여야 함
        try
        (FileInputStream fis = new FileInputStream("C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\src\\Day13\\image.jpg");
        FileOutputStream fos = new FileOutputStream("계곡복사2.jpg")){
            while((b=fis.read(buffer,0,buffer.length)) != -1){        
                //read(배열이름, 시작위치, 최대길이) 리턴값 b는 실제 읽어온 byte
                //길이가 1024바이트가 안될수도 있으므로 실제 읽어온 바이트 수를 알아야 처리가능
                fos.write(buffer,0,b);                          //write(배열이름, 시작인덱스, 출력길이)
                count+=b;
            }
        }catch(IOException e) {
        System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
        //     복사한 파일 크기 : 1,325,184 바이트
        // 소요시간 : 63,614,900 ns

    public static void copyByBuffer(){
        int b; int count=0;
        byte[] buffer = new byte[1024];     //바이트 배열을 이용해서 1024바이트씩 입출력
                                            //->버퍼에서 사용. 버퍼입출력 스트림
        try
        (FileInputStream fis = new FileInputStream("C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\src\\Day13\\image.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("계곡복사3.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);){ //보조 버퍼 입력스트림
            while((b=bis.read(buffer,0,buffer.length)) != -1){  //보조 버퍼 출력스트림
                bos.write(buffer,0,b);                       
                count+=b;
            }
        }catch(IOException e) {
        System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }




}

