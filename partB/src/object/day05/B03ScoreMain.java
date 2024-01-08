package object.day05;


public class B03ScoreMain {
 public static void main(String[] args) {
    //학생 4명의 성적을 저장해보세요
    //1학년 2명(모모,다현) 3과목, 2학년 2명(나연,쯔위) 4과목, 점수는 임의로
    //파일 두개 다 드라이브에 올리기
    Score m = new Score();
    Score d = new Score();
    Score n = new Score();
    Score z = new Score();

    m.setName("모모");
    m.setgrade(1);
    int[] moJumsu = {100,30, 20};
    m.setJumsu(moJumsu);
    m.printData();
  
    d.setName("다현");
    d.setgrade(1);
    int[] Jumsu22 = {100,40, 20};
    d.setJumsu(Jumsu22);
    d.printData();

    n.setName("나연");
    n.setgrade(2);
    int[] Jumsu3 = {100,100, 40,100};
    n.setJumsu(Jumsu3);
    n.printData();

    z.setName("쯔위");
    z.setgrade(2);
    int[] Jumsu4 = {100,90, 40,90};
    z.setJumsu(Jumsu4);
    z.printData();







    
    
 }   
}
