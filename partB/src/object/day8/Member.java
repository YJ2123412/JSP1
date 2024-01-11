package object.day8;

public class Member {
    private String name;
    private int age;
    
    public Member(int age, String name){
        this.age=age;
        this.name=name;
    };

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }


    //다형성 예시: 메소드 인자가 부모타입일때, 실제 객체는 여러자식 
    public boolean isAdopt(Animal animal){
        boolean result;
        if(age>=13 && animal instanceof Rabbit? result=true:false){ 
        }else if(age>=13&& animal instanceof Puppy? result=true:false){
        }else if(age>=20 && animal instanceof Cat? result=true:false){
        }else {
            result = false;
        } return result;
    }
}
