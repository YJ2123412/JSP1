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
import java.util.Map;


//클라이언트와 서버 각각 실행하는 메소드가 다름
//서로 연결 과정이 다르기 때문
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream is = null;
        DataInputStream dis = null;
        OutputStream os = null;
        DataOutputStream dos=null;
        BufferedInputStream bis = null;
        FileInputStream fis = null;

        try {
            System.out.println("클라이언트 프로그램입니다.");
            socket = new Socket();
            //시간 중지 타입
            Thread.sleep(3000);//3초간 중지
            //서버에서 설정한 bind 정보와 같은 객체를 만듬

            socket.connect(new InetSocketAddress("192.168.30.10",5050));
            System.out.println("연결 성공하였습니다.");
            
            //서버가 보낸 메시지 받기
            is =socket.getInputStream();
            dis = new DataInputStream(is);
            String msg = dis.readUTF();
            System.out.println(msg);

            //서버에게 인사말 보내기
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            System.out.println("서버에게 보낼 메세지를 쓰세요_");
            msg = System.console().readLine();
            dos.writeUTF("\tFrom 클라이언트>>" +msg);

            //이미지 파일 서버에 보내기(업로드)
            //String filepath = ("C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\cute3.jpg");
            //보낼때에는 직접 선택해서 경로가 지정되기에 경로가 중요치않음
            Map<String,String> map = FileSelectTest.showDialog();
            String filePath= map.get("folder")+map.get("filename");
            
            //파일명을 서버에게 보내서 서버도 원래 이름으로 다운로드하도록
            dos.writeUTF(map.get("filename"));


            //파일 입력을 받아 소켓으로 출력하기
            fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);
            int b;
            while ((b=bis.read())!= -1) { //파일에서 읽어오기
                dos.write(b);               //소켓 출력(바이트 단위)
            }
            System.out.println("파일업로드 완료");



        } catch (IOException |InterruptedException e) {
            e.printStackTrace();

        } finally {
            try {socket.close(); is.close(); dis.close(); os.close(); dos.close(); fis.close(); bis.close();} catch (IOException e){}
        }
    }
}
