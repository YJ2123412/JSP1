package object.day05;


public class Score {
    
        
        //학생들의 성적을 객체로 만들어줄 클래스입니다.
        
        private String name;//학생이름
        private int grade;  //학년
        private int[] jumsu; //점수들의 배열
        public int sum;
      
        //getter
        public String getName(){
            return name;
        };
        public int getgrade(){
            return grade;
        };        
        public int[] getJumsu(){
            return jumsu;
        };


        //setter
        public void setName(String name){
           this.name=name;
        };
        public void setgrade(int grade){
           this.grade=grade;
        };
        public void setJumsu(int[] j){
           this.jumsu= new int[j.length];
           for(int i=0; i<j.length; i++){
            jumsu[i] = j[i];
           }
        };



        //점수의 합계를 리턴하는 sum()메소드
        public int sum(){
            int sum = 0;
            for (int i = 0; i < jumsu.length; i++) {
                sum+=jumsu[i];
            }
            return sum;
        }



        //점수의 평균 double리턴하는 averager()메소드
        public double averager(){
            return (double)sum()/jumsu.length;
        }
        
        //모든 인스턴스 필드값을 확인 출력하는 printScore() 메소드
        public void printData(){
        System.out.println("학생의 이름은 "+name+"이고, "+grade+ "학년이며 , 점수 합계는 "+sum() + "이고, 평균은 "+ averager()+"입니다.");}
    public static void main(String[] args) {

    }
}
