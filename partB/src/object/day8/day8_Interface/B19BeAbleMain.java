package object.day8.day8_Interface;

import object.day8.bable.AI;
import object.day8.bable.BeAble;
//import object.day8.bable.Cookable;
import object.day8.bable.Dog;
import object.day8.bable.Human;
import object.day8.bable.Thinkable;

public class B19BeAbleMain {
    public static void main(String[] args) {
        Thinkable th1 = new AI(); 
        AI ai =(AI)th1; ai.setOp('*');

        Thinkable th2 = new Human();
        //Thinkable th3 new dog();

        object.day8.bable.Runnable run1 = new Human();
        object.day8.bable.Runnable run2 = new Dog();
       
        //Runnable run3 = new AI();

        //Cookable cook = new Human();

        BeAble[] beAbles = new BeAble[3];
        beAbles[0] = th1;
        beAbles[1] = th2;
        beAbles[2] = run1;

        System.out.println("beable 테스트");
        for(BeAble able : beAbles){
            System.out.println("~~~~~~~~~~~~~~~");
            System.out.println(able.beAble()); 
           if(able instanceof Thinkable){
                //다운캐스팅
                Thinkable temp = (Thinkable)able;
                System.out.println(able.getClass().getName()+"이 계산합니다");
                char op = temp instanceof AI ? ((AI)temp).getOp() : '+';
                System.out.println("\t 연산: "+op);
               System.out.println("\t 정답: " +temp.calculate(2024, 3));
           }else {
            System.out.println(able.getClass().getName()+"은 계산 못합니다.");
           }
        }

    }
    //결론: 업캐스팅 또는 다운캐스팅 목적은 상속과 같은 방식으로 사용할 수 있음
    //업캐스팅은 다형성, 다운캐스팅: 업캐스팅 타입이 갖는 추상메소드가 아닌 다른메소드 실행하기 위함
    
}
