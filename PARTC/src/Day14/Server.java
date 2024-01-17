package Day14;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

//클라이언트와 서버 각각 실행하는 메소드가 다름
//서로 연결 과정이 다르기 때문
//프로그램은 서버가 먼저 실행
public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            //서버 설정을 위한 소켓 생성
            server = new ServerSocket(); //서버에서만 사용
            //서버 연결 정보 ip, port 설정
            server.bind(new InetSocketAddress("192.168.181.10",5050));
            System.out.println("서버 프로그램 시작: 연결 요청을 기다리는 중입니다.");
            //클라이언트 요청(connect)에 대한 수락, 입출력 스트림을 만들 소켓
            socket = server.accept();//클라이언트가 사용할 소켓
            System.out.println("__ 연결을 수락합니다."); //accept 정상 완료 되면 실행.

            //서버가 클라이언트에게 데이터 보내기 : 출력 스트림
            //클라이언트와 서버가 연결된 socket으로 출력스트림 생성
            OutputStream os = socket.getOutputStream(); 
            //정수, 실수, 문자열 보내는 스트림 - 보조스트림
            DataOutputStream dos = new DataOutputStream(os); 
            dos.writeUTF("\t From 서버 >> 환영합니다.");

            //클라이언트가 보낸 인사말 받기
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readUTF());

            //클라이언트가 보낸 이미지 받기

            //파일명 똑같이.. C:\\Users\\YJ\\Desktop\\Coding\\Main\\cute3.jpg
           // BufferedOutputStream bos
           // = new BufferedOutputStream(new FileOutputStream("C:\\Users\\YJ\\Desktop\\Coding\\Main\\cute3.jpg"));
           
           //클라이언트가 보내준 파일명으로 저장하기
           String filename = dis.readUTF();
           System.out.println("\t클라이언트 업로드 파일명"+filename);

            BufferedOutputStream bos
           = new BufferedOutputStream(new FileOutputStream("C:\\Users\\YJ\\Desktop\\Coding\\Main\\"+filename));
            

            int b; int count = 0;
            while((b=dis.read())!=-1){
                bos.write(b); //버퍼스트림 이용한 바이트 단위 출력
                count++;
            }
            System.out.println("파일 받기 완료. 총 바이트: "+count);

        } catch (IOException e) {
            e.printStackTrace(); //예외 발생시 코드 수정을 위해 필요


        } finally{
            //자원해제. close()
            try {server.close(); socket.close();} catch (IOException e) {}
        }
    }
    




}
