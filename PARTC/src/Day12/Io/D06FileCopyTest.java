package Day12.Io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//파일 입력 스트림으로 이미지 파일 읽어오기
//->파일 출력스트림으로 파일 내용을 출력(파일복사)
public class D06FileCopyTest {
    

    public static void main(String[] args) {
        FileInputStream fis=null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("C:\\Users\\YJ\\Desktop\\Coding\\html+css\\img\\cute.jpg");
            fos = new FileOutputStream("cute3.jpg");
            int count = 0;
            int read = 0;
	     while((read= fis.read()) != -1) {
			fos.write(read);
            count++;
         } System.out.println("count : "+ count);

        } catch (Exception e) {

        }finally{
            try {fis.close(); fos.close();
            } catch (Exception e) {}
        }
    }   

}
