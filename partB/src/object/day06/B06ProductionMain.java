package object.day06;

//import java.util.Arrays;

public class B06ProductionMain {
    public static void main(String[] args) {
        
        Product snack = new Product("새우깡", 1200, "농심", new String[3]);
        Product drink = new Product("칠성사이다", 2200, "롯데", new String[3]);
        Product fruit = new Product("부사", 10200, "우리농원", new String[3]);
        Product icecream = new Product("투게더", 7000, "빙그레", new String[3]);
        //set이 있다면 값을 다 바꿀 수도 있음

        System.out.println(snack);
        System.out.println(drink);
        System.out.println(fruit);
        System.out.println(icecream);

//      object.day06.Product@372f7a8d -> 객체참조값(식별값) ->주소라고 부릅시다
//      object.day06.Product@2f92e0f4 -> object.day06.Product는 패키지 이름.클래스이름
//      object.day06.Product@28a418fc
//      object.day06.Product@5305068a


        System.out.println(snack.getData());
        System.out.println(drink.getData());
        System.out.println(fruit.getData());
        System.out.println(icecream.getData());

        //퀴즈. snack의 etc필드 배열요소 0번에 "10개 묶음"문자열을 저장하세요
        snack.getEtc();

        String[] temp = snack.getEtc();
        temp[0] = "10개 묶음"; 
        System.out.println(snack.getData());;

        //snack.setPrice(1000); //set 메소드 없음 -> 오류
        //snack.price = 1000;  //private ->오류

        //get을 통해 배열을 바꿀 수는 없지만(주소값) 그 안에 있는 내용은 바꿔줄 수 있음(값)

        //int[] numbers = new int[3]; //정수 3개 저장
        Product[] mycarts = new Product[5]; //프로덕트 객체배열 - 프로덕트 타입으로 만들어진 객체의 참조값 저장 배열
        mycarts[0]= drink;
        mycarts[1]= icecream;
        //mycarts[2]= fruit;
        mycarts[3]=fruit;
        mycarts[4]= snack;
        System.out.println("my carts~~~~~~~~~~~~~");

        //배열이므로 반복문으로 출력할 수 있음.
        for (int i = 0; i < mycarts.length; i++) {
            if(mycarts[i]!=null)
            System.out.println(mycarts[i].getData()); //null일때는 메모리 할당이 안된상태. 메소드 사용 불가

        }



    }




}
