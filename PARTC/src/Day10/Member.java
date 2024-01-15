package Day10;

//아래 멤버클래스는 생성될때 초기화하면 변경 못함
//hashcoce, equals를 재정의 -> 이러한 객체를 VO(value Object)라 부름
public class Member {
    private String name;
    private int age;

    public Member(String name, int age){
        this.age=age;
        this.name=name;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Member [name="+name+", age ="+age +"]";
    }

    //중요! 객체의 동일성(같은 객체)을 검사하기 위해서 hascode와 equals를 오버라이드(재정의)해야 함
    //해시코드 값이 같고 인스턴스 필드의 내용이 같으면 동일한 객체다

    @Override
    public int hashCode() { //인스턴스필드값으로 해시코드 생성: name.hashcode() 와 age 정수값으로 계산산
        final int prime = 31; 
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }
    @Override
    public boolean equals(Object obj) { //대상이되는 obj와 현재 this 객체의 인스턴스 필드값이 모두 같은지 검사
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }


}
