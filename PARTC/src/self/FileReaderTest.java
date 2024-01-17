package self;

import java.io.FileReader;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader re = null;
        try {
         re = new FileReader("C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\Wordtest.txt");
       int read = 0;
         char[] chArray = new char[50];
         while((read = re.read(chArray))!= -1){
            System.out.print(new String(chArray,0, read));
                }} catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(re != null) {
                        re.close();}	
                } catch (Exception e) {}}}}
    
    

