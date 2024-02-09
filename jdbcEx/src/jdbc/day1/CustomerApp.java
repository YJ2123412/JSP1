package jdbc.day1;

import java.sql.SQLException;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

public class CustomerApp {
    
    public static void main(String[] args) throws SQLException {
        TblCustomerDao dao2 = new TblCustomerDao();
        
        String customId;
        System.out.println("메뉴를 고르세요 1. 회원가입  2. 정보수정  3. 회원탈퇴");
        int user = Integer.parseInt(System.console().readLine());
        switch (user) {
            case 1:  System.out.println("우리 쇼핑몰 [회원가입] 환영합니다.");
            System.out.println("주의사항 : 아이디는 중복된 값을 저장하면 무결성 위반 오류입니다.");
            
            System.out.print(" 아이디를 입력하세요. __ ");
            customId = System.console().readLine();
            
            System.out.print(" 이름을 입력하세요. __ ");
            String name = System.console().readLine();
    
            System.out.print(" 이메일을 입력하세요. __ ");
             String email = System.console().readLine();
    
            System.out.print(" 나이를 입력하세요. __ ");
            int age = Integer.parseInt(System.console().readLine());
    
            CustomerVo vo = new CustomerVo(customId, name, email, age, null);
            dao2.join(vo);
            System.out.println("회원 가입이 완료 되었습니다.");
                
                break;
            
            case 2:  System.out.println("우리 쇼핑몰 [회원정보]-이메일과 나이 수정 합니다.");

            System.out.print(" 아이디를 입력하세요. __ ");
            customId = System.console().readLine();
    
            System.out.print(" 이메일을 입력하세요. __ ");
            email = System.console().readLine();
    
            System.out.print(" 나이를 입력하세요. __ ");
            age = Integer.parseInt(System.console().readLine());
            vo = new CustomerVo(customId, null, email, age, null);
            dao2.modify2(vo);

            case 3:  System.out.println("우리 쇼핑몰 [회원탈퇴]합니다.");
            System.out.print(" 아이디를 입력하세요. __ ");
            customId = System.console().readLine();
            dao2.delete2(customId);

            case 4:  System.out.println("우리 쇼핑몰 [회원정보]-나의 정보를 확인합니다.");
            System.out.print(" 아이디를 입력하세요. __ ");
            customId = System.console().readLine();
            dao2.getCustomer(customId);
            vo = dao2.getCustomer(customId);
            System.out.println(vo);

            case 5:  System.out.println("우리 쇼핑몰 [회원정보] 전체를 조회합니다.");
            dao2.allCustomers();
                break;

            default:
                System.out.println("프로그램을 종료합니다.");
                break;
        }

        System.out.println("우리 쇼핑몰 [회원가입] 환영합니다.");
        System.out.println("주의사항 : 아이디는 중복된 값을 저장하면 무결성 위반 오류입니다.");
        
        System.out.print(" 아이디를 입력하세요. __ ");
        customId = System.console().readLine();
        //dao2.gCustomer2(customId);
        
        System.out.print(" 이름을 입력하세요. __ ");
        String name = System.console().readLine();

        System.out.print(" 이메일을 입력하세요. __ ");
         String email = System.console().readLine();

        System.out.print(" 나이를 입력하세요. __ ");
        int age = Integer.parseInt(System.console().readLine());

        CustomerVo vo = new CustomerVo(customId, name, email, age, null);

        dao2.join(vo);
        System.out.println("회원 가입이 완료 되었습니다.");
        
        System.out.println("우리 쇼핑몰 [회원정보]-이메일과 나이 수정 합니다.");

        System.out.print(" 아이디를 입력하세요. __ ");
        customId = System.console().readLine();

        System.out.print(" 이메일을 입력하세요. __ ");
        email = System.console().readLine();

        System.out.print(" 나이를 입력하세요. __ ");
        age = Integer.parseInt(System.console().readLine());
        vo = new CustomerVo(customId, null, email, age, null);

        dao2.modify2(vo);


        System.out.println("우리 쇼핑몰 [회원탈퇴]- 합니다.");
        System.out.print(" 아이디를 입력하세요. __ ");
        customId = System.console().readLine();
        dao2.delete2(customId);
    }   //main end
    //이 클래스는 Dao 테스트를 위한 실행 클래스

}
