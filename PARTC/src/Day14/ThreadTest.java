package Day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadTest {

    public static void main(String[] args) {

        //실행 시간이 오래 걸릴 경우, 실행중이라는 .표시를 사용자에게 보여줌
        //1초마다 . 을 출력 ->스레드로 만듬
        //1)Thread 클래스 상속받기
        //2)Runnable 인터페이스 구현하기
        

        //1.스레드가 할 일을 인터페이스 활용하여 정의 ->익명클래스
        Runnable runnable = new Runnable() {
            @Override
            public void run() {//스레드가 할 일을 이곳에 코딩하기
                boolean run = true;
                while(run){
                    System.out.print(".");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        run=false;
                    }
                            //interrupt : 방해,간섭, 끼어들다
                }
            }
        };
        //2. 스레드 생성하기. 할일은 생성자 인자로 전달
        Thread thread = new Thread(runnable);
        //3. 실행
        thread.start();

        long start = System.nanoTime(); 
        //처리할 메소드
        copyByByte();
        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns",(end-start)));
        //4. 스레드 종료를 위해 interrupt 발생
        // thread.stop(); ->비추.. 소멸된 메소드
        thread.interrupt();

    }
    
    public static void copyByByte() {
        int b; int count=0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\src\\Day13\\image.jpg");
            fos = new FileOutputStream("계곡복사.jpg");
            while((b=fis.read()) != -1){      
                fos.write(b);
                count++;
            }
        }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }finally {
            try{ fis.close(); fos.close();}
            catch(IOException e) {}
        }
        System.out.println(String.format("\n복사한 파일 크기 : %,d 바이트",count));
    }
    
}

