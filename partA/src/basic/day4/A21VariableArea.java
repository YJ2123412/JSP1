package basic.day4;

public class A21VariableArea {
    //변수의 선언 위치(어떤 블럭에서 선언하는가)-> 변수의 사용범위 결정

    int number = 999;           //1. 클래스 범위에서 사용되는 변수
    static int number2 = 999;

    public static void main(String[] args) {


        int a=23;               //2. 메인메소드 범위에서 사용되는 변수

        for(int i= 0; i<10; i++){ //3. 특정블럭 안에서 사용되는 변수 =i
            System.out.println("i="+i);
        }

        while(a==23){       //참인 상태 -> 무한루프
            int count;          //3. 특정블럭 안에서 사용되는 변수 = count
            System.out.println("a="+a);
            count=100;
            System.out.println("count="+count);
            //종료 조건이 없으면 무한 반복(loop)
            a = 24;
        }

        System.out.println("a="+a);
        //System.out.println(i);          //문법적인 오류 - 이 지점에서 i는 알 수 없는 변수
        //System.out.println(count);      // 동일 오류


        //이후에 진도 나갈 내용
        //main 메소드가 static 메소드임. static은 static 끼리만 서로 사용
       
        //System.out.println(number);  //static이 아닌 클래스 선언 변수는 사용 못함
        System.out.println(number2);

    }
    
}
