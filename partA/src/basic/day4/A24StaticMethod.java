package basic.day4;

public class A24StaticMethod {
    public static void main(String[] args) {

        argumentTest(); //메소드 호출. 이름과 형식이 맞는 메소드를 찾아서 실행합니다.
        argumentTest(999);
        argumentTest(100, 333);  //100,300은 실매개 변수
        //argumentTest("100", 333);  //형식에 맞는 메소드 없음
        //메소드가 실행될때 실매개변수값이 형식 매개변수로 전달, 저장
        int a=100, b=999;
        argumentTest(a,b); //실매개변수(실제로 값이 저장되기에)

        System.out.println("resultStrTest: "+resultStrTest()+"입니다~~~");
        System.out.println("1000 - resultIntTest: "+(1000-resultIntTest()));

        boolean an = resultBooleanTest();
        System.out.println(an);
        int ac = (int)resultChraTest();
        System.out.println(ac);

        System.out.println(add(1.25, 3.1, 4.9));

        }

        //프로그램을 실행시키는 main이 static이므로 여기서 같이 사용할 수 있는 다른 static메소드 연습을 해봅시다.

        // 1~4는 리턴 없음. 인자로 선언된()안의 변수는 메소드의 지역변수 입니다.
        //1. 인자가 없는 메소드
        public static void argumentTest(){
            System.out.println("인자가 없는 메소드");
        }
        //2. 인자가 1개 있는 메소드 - 사용된 변수 i는 argumentTest안에서만 사용되는 변수
        public static void argumentTest(int i){
            System.out.println("인자가 1개 정수" +i+"입니다.");
        }
        //3. 인자가 2개 있는 메소드
        public static void argumentTest(int i, int j){ //i,j는 형식매개변수(가짜)
            System.out.println("인자가 2개 정수 i=" +i+"j="+j);
            System.out.println("i+j="+(i+j));
        }


        //리턴은 메소드 실행한 결과값입니다. 리턴값이 있는 메소드이므로 결과를 변수에 저장할 수 있음
        //4. 리턴값이 정수인 메소드
        public static int resultIntTest(){
            return 999;
        }
        //5. 리턴값이 boolean인 메소드
        public static boolean resultBooleanTest(){
            return false;
        }
        //6. 리턴값이 String인 메소드
        public static String resultStrTest(){
            return "Hello";
        }
        //7. 리턴값이 char인 메소드
        public static char resultChraTest(){
            return 'A';
        }

        //인자와 리턴값을 갖는 메소드
        public static double add(double a, double b, double c){
            return a+b+c;
        }
    

}
