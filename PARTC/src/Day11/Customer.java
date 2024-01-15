package Day11;
// 1/14 pm 9:00까지 제출
//고객정보 클래스
public class Customer {
    private String name;
    private String phone;
    private int group; //1. 일반  2.VIP  3.기타

    //커스텀 생성자
    public Customer(String name, String phone, int group){
        this.name=name;
        this.phone=phone;
        this.group=group;
    }



    //set X, 정보 변경 메소드
    public void modify_phone(String phone, int group){
        this.phone=phone;
        this.group=group;
    }

    //toString 테스트용
   


    public int getGroup() {
        return group;
    }
    
    @Override
    public String toString() {
        return "Customer [name=" + name + ", phone=" + phone + ", group=" + group + "]";
    }



    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }




}
