package object.day9;

//인터페이스 예시 - 비교가능한 객체 만들기
//ㄴ객체 비교 방법 1)comparable 인터페이스 구현하도록 함
//Comparable<member>는 <>에 타입을 표시. 이런 방식을 제너릭 타입이라 함
//제너릭 타입은 클래스 또는 인터페이스의 메소드에게 '타입을 매개변수로 전달'하기 위한 방식.
//이때 타입이 실행 시점에서 결정되기 때문. 기본형은 Wrapper클래스로 사용
//Comparable 인터페이스가 실행하는 메소드에 Member 타입을 전달합니다.

public class Member implements Comparable<Member> {

    private String id;
    private int age;
    
    
    public Member (String id, int age){
        this.id=id;
        this.age=age;
    }
        
    

    public static void main(String[] args) {
        
    }

    


    //Comparable 인터페이스의 추상메소드 compareTo를 구현

    @Override
    public String toString() {
        return "Member [id=" + id + ", age=" + age + "]";
    }


    public String hello() {
        return String.format("%s이 인사하네요",id);
    }

    



    @Override
    public int compareTo(Member o) { //메소드의 인자 타입 Member는 <> 제너릭 타입과 같게 만들어짐
        //현재 객체 this를 인자로 전달되는 Member객체와 비교합니다.
        //비교 기준은 요구사항에 따라 개발자가 결정합니다.
        //만약에 나이로 한다면
        //Comparable: 비교할 수 있는
            //return this.age - o.age;// 오름차순
            //return o.age - this.age; //내림차순

        //만약에 이름으로 한다면 
            //return this.id.compareTo(o.id); ->오름차순
           return o.id.compareTo(this.id); //내림차순
    }

    
}

