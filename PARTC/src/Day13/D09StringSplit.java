package Day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class D09StringSplit {
    private static String filePath = "C:\\Users\\YJ\\Desktop\\Coding\\Main\\PARTC\\score.txt";

    public static void main(String[] args) {
        //System.out.println(makeList());
        for(Score t:makeList()){
            System.out.println(t);
        } 
        //split_test2();
    }
    //BufferReader 클래스는 파일에서 1줄씩 읽어올 수 있습니다. 1줄 읽고 ->score 객체 만들기
    //변수명 모두 stu로 참조하고 출력하기

    /**
     * 이름과 점수를 분할시키는 메소드
     */
    public static Score makeScore(String line){
        String[] temp = line.split(",");
        Score score = new Score(temp[0], 
                                        Integer.parseInt(temp[1]), 
                                        Integer.parseInt(temp[2]), 
                                        Integer.parseInt(temp[3]));
        return score;
    }

    /**
     * 파일에서 라인 단위로 글을 읽어오고, 이를 리스트에 넣는 메소드
     */
    public static List<Score> makeList(){
        List<Score> score = new ArrayList<>();
        try (
            BufferedReader br = new BufferedReader(new FileReader(filePath));
        ){
            String line;    //라인 단위로 읽어서 저장할 변수 
            while ((line =br.readLine())!=null) {   
             /*    Score stu = makeScore(line);
                score.add(stu); 아래 줄과 같음*/
                score.add(makeScore(line));
                //System.out.println(String.format("count=%d, score object =%s",count,stu));
                //System.out.println(line);
            }}catch(Exception e){e.getMessage();}
        return score;
            }


    //-----------------------------------------------------------------------------------
    //1)score.txt에서 모든 데이터를 읽어오고 2) Score객체로 변환하여 3)리스트에 담고 리턴하기



    public static void split_test2(){
 
        int count=0; 
        try (
            BufferedReader br = new BufferedReader(new FileReader(filePath));
        ){
            String line;    //라인 단위로 읽어서 저장할 변수 
            while ((line =br.readLine())!=null) {   
                //readLine은 String 리턴
                /* String[] temp = line.split(",");
                Score score = new Score(temp[0], 
                                        Integer.parseInt(temp[1]), 
                                        Integer.parseInt(temp[2]), 
                                        Integer.parseInt(temp[3])); */
                Score stu = makeScore(line);
                System.out.println(String.format("count=%d, score object =%s",count,stu));
                System.out.println(line);
                count++;
            }
        } 
        catch (Exception e) {
            System.out.println("파일 입력 오류: "+ e.getMessage());
        }
        System.out.println("score 객체: "+count+"개 생성 완료!");
    }
    
    

    public static void split_test1(){  
        String stu = "김모모,67,77,88";

        String[] temp = stu.split(",");
        System.out.println("1. split 실행한 결과 문자열 배열은?");
        System.out.println(Arrays.toString(temp));
        for(String t: temp) System.out.println("배열요소: "+t);

        System.out.println("2. 분리된 객체로 Score 객체를 만들면?");
        //temp[0] = name, 1~3까지는 점수 문자열=정수로 변환

        Score score = new Score(temp[0], 
                                Integer.parseInt(temp[1]), 
                                Integer.parseInt(temp[2]), 
                                Integer.parseInt(temp[3]));

        System.out.println("출력 1. score: " + score.datas());
        System.out.println("출력 2. score: "+score.toString());

        //split 메소드는 지정된 구분자(구분기호)를 이용해서 문자열을 분리하고 배열에 저장해서 리턴
    
    }
}