package Day11;

import java.util.ArrayList;
import java.util.List;

public class CustomerManageApp {
    //자바 앱V2형식
    
    private List<Customer> cus = new ArrayList<>();

    public static void main(String[] args) {
        CustomerManageApp app = new CustomerManageApp();
        app.start();
    }

    private void start() {
        initialize();
        //메뉴선택: 등록, 검색(이름, 그룹), 삭제, 수정, 전체출력
        System.out.println("고객 관리 프로그램 시작합니다"+"~".repeat(30));
        while (true) {
            System.out.println("\n\t <메뉴를 선택하세요.>");
            System.out.println("\t 1. 고객 등록");
            System.out.println("\t 2. 고객 검색");
            System.out.println("\t 3. 고객 삭제");
            System.out.println("\t 4. 고객 정보 수정");
            System.out.println("\t 5. 고객 정보 전체보기");
            System.out.println("\t 6. 종료");
            System.out.print("선택>> "); 
            int select = Integer.parseInt(System.console().readLine()); 
           
            switch (select) {
                case 1: addCus(); break; //고객 등록
                    
                case 2: searchCus(); break;//고객 검색

                case 3: deleteCus(); break; //고객 삭제
                   
                case 4: modifyCus();  break;//고객 정보 수정
                
                case 5: listCus(); break; //고객 정보 전체보기 
                
                case 6:  //종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0); //main 종료
                    break;

                default:
                System.out.println("잘못된 선택값입니다.");
                    break; 
            }//switch end
        }//while end
    }

    private void initialize() {
        cus.add(new Customer("Kim", "010-0000-0000", 1));
        cus.add(new Customer("Rim", "010-0000-0000", 1));
        cus.add(new Customer("Mim", "010-0000-0000", 2));
        cus.add(new Customer("Pim", "010-0000-0000", 2));
        cus.add(new Customer("Nim", "010-0000-0000", 3));
        cus.add(new Customer("Sim", "010-0000-0000", 3));
    }

    private void modifyCus() {
        System.out.println("\t::고객 정보를 수정합니다.::");
        System.out.print("고객님 성함을 입력하세요 . -");
        String name = System.console().readLine();
        for(Customer list2:cus){
            if(list2.getName().equals(name)){
                        System.out.println("수정할 폰 번호를 적으세요");
                        String phone=System.console().readLine();
                        System.out.println("수정할 그룹 번호를 적으세요");
                        int group=Integer.parseInt(System.console().readLine());
                        list2.modify_phone(phone,group);
            } 
        }   System.out.println("찾는 정보가 목록에 없습니다.");
    }

    private void addCus() {
        System.out.println("\t::고객 등록 합니다.::");
        System.out.print("고객님 성함을 입력하세요 . -");
        String name = System.console().readLine();
        System.out.print("핸드폰 번호를 입력하세요 . -");
        String phone = System.console().readLine();
        System.out.print("group을 입력하세요  //1. 일반  2.VIP  3.기타 _");
        int group = Integer.parseInt(System.console().readLine());
        cus.add(new Customer(name, phone, group));
    }
    
    private void deleteCus() {
        boolean isFind = false;
        System.out.println("\t:::삭제할 고객의 정보를 입력하세요 :::");
        String remove = System.console().readLine();
        for (int i = 0; i < cus.size(); i++) { 
            if(cus.get(i).getName().equals(remove)){
                isFind = true; 
                    System.out.println("고객 정보를 정말 삭제하시겠습니까? 1. 네  2. 아니오");
                    int choice = Integer.parseInt(System.console().readLine());
                    if(choice==1){
                        System.out.println(cus.get(i)+"번 고객정보가 삭제되었습니다.");
                        cus.remove(i);
                    }
            } 
        }
        if(!isFind){
            System.out.println("해당 고객이 목록에 없습니다.");
        }
    }


    private void searchCus() {
        System.out.println("\t:::고객 정보를 검색합니다 :::(이름 조회는 1, 그룹 조회는 2)");
        String find = null;
        List<Customer> list2 = null;
        switch (System.console().readLine()) {
            case "1":
                System.out.println("검색할 고객의 이름을 입력하세요_");
                find = System.console().readLine();
                list2 = search(find);
                break;
            case "2":
                System.out.println("검색할 그룹을 입력하세요._");
                list2 = search(Integer.parseInt(System.console().readLine()));
                break;
        
            default:
                System.out.println("1,2만 입력하세요");
                return;
        }
        System.out.println("\t:: 검색 결과 입니다.::");
        if(list2.size()==0){
            System.out.println("찾는 정보가 목록에 없습니다.");
        }else 
            printList(list2);
    }

    private List<Customer> search(String name){
        List<Customer> list = new ArrayList<>(); //검색결과를 저장할 리스트
        for(Customer list2:cus){
            if(list2.getName().equals(name)){
                list.add(list2); //일치하는 단어를 만날때마다 저장할 리스트
            }
        }
        return list;
    }

    private List<Customer> search(int group){
        List<Customer> list = new ArrayList<>(); 
        for(Customer list2: cus){ 
            if(list2.getGroup()==group){
                list.add(list2);
                }
            }
            return list;
        }

    private void listCus() {
        System.out.println("고객 목록 출력합니다");
        System.out.println(String.format("%-20s %-30s %-20s" , "Name","Phone","Group"));
        printList(cus);
    }

    private void printList(List<Customer> cus){
        for(Customer list : cus){
            System.out.println(String.format("%-20s %-30s %-20s", list.getName(),list.getPhone(),list.getGroup()));
            } 
        }
    }






