package Day14;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

//socket.png 그림참고 : 클라이언트와 서버 각각 실행하는 메소드가 다릅니다.
//                     서버와 클라이언트 연결 과정이 다르기 때문. 
public class ClientT {

        public static void main(String[] args) {
            Socket socket = null;

            try{
                System.out.println("[클라이언트] 프로그램 입니다.");
                socket = new Socket();
                // 시간 중지 타임 설정
                Thread.sleep(3000);     //3초간 중지(3000ms)

                //서버에서 설정한 bind 정보와 같은 객체를 만듭니다.
                socket.connect(new InetSocketAddress("192.168.30.254",5050));
                System.out.println("__연결성공 하였습니다.");

                //서버가 보낸 메시지 받기
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String message = dis.readUTF();
                System.out.println(message);

                //서버에게 인사말 보내기
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                System.out.println("서버에게 보낼 메시지를 쓰세요._");
                message = System.console().readLine();
                dos.writeUTF("\tFrom 클라이언트 >> " + message);

                //이미지 파일을 서버에 보내기(업로드)
                String filePath = "C:\\Users\\Administrator\\Downloads\\sana.jfif";
                //파일입력을 받아 소켓으로 출력하기
                FileInputStream fis = new FileInputStream(filePath);
                BufferedInputStream bis = new BufferedInputStream(fis);
                int b;
                while((b=bis.read()) != -1){    //파일에서 읽어오기
                    dos.write(b);           //소켓출력(바이트 단위)
                }
                System.out.println("파일 업로드 완료!!");


            }catch(IOException | InterruptedException e){
                    e.printStackTrace();
            }finally{
                try{ socket.close(); } catch(IOException e) {} 
            }


        }
    
}
