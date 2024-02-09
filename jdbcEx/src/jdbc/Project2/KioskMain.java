package jdbc.Project2;

import java.util.ArrayList;
import java.util.List;

import jdbc.Project2.DAO.Tbl_BuyListDao;
import jdbc.Project2.DAO.Tbl_CustomerDao;
import jdbc.Project2.DAO.Tbl_FoodDao;
import jdbc.Project2.VO.TBL_BuyListVo;
import jdbc.Project2.VO.TBL_FoodVo;

public class KioskMain {
    Tbl_CustomerDao cusDao = new Tbl_CustomerDao();
    Tbl_BuyListDao buydao = new Tbl_BuyListDao();
    Tbl_FoodDao foodDao = new Tbl_FoodDao();
    List<TBL_FoodVo> foodtList = new ArrayList<TBL_FoodVo>();
    List<TBL_BuyListVo> buylist = new ArrayList<TBL_BuyListVo>();


    private void showMenu() {
        System.out.println("-".repeat(70));
        System.out.println("1. 주문 하기\t 2. 주문 수정\t\t3. 주문 취소  \t 4. 구매내역");
        System.out.println("5. 메뉴검색\t 6. 전체 메뉴 조회\t7. 메뉴추천\t 8. 구매 종료");
        System.out.println("-".repeat(70));
    }


    public void start() {
        
        System.out.println("로그인이 필요한 서비스입니다.");
        System.out.print("아이디 입력: ");
        String id = System.console().readLine();
        System.out.println( id+"님 환영합니다.");
        boolean run = true;
        int selectNum;
        String user; 
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("메뉴의 번호를 입력해주세요 ");   
            String select = System.console().readLine();
            switch (select) {
                case "1": 
                    System.out.print("주문하실 상품 코드를 입력해주세요: ");
                    select = System.console().readLine();
                    System.out.print("주문하실 상품의 개수를 입력해주세요: ");
                    selectNum = Integer.parseInt(System.console().readLine());
                    buydao.orderMenu(id, select, selectNum);
                    System.out.println("주문이 완료되었습니다.");
                        break;
                case "2":
                    System.out.print("수정할 주문 번호를 입력해주세요: ");
                    int idx = Integer.parseInt(System.console().readLine());
                    System.out.print("변경할 개수를 입력해주세요: ");
                    int quantity = Integer.parseInt(System.console().readLine());
                    buydao.modifyOrder(idx,quantity);
                    System.out.println("수정이 완료되었습니다.");
                        break;  
                case "3":
                    System.out.print("취소할 주문 번호를 입력해주세요: ");
                    idx = Integer.parseInt(System.console().readLine());
                    buydao.cancelOrder(idx);
                        break;
                case "4":
                    buylist =buydao.buyHistory(id);
                    System.out.println(buylist);

                    break;
                case "5":
                    System.out.println("메뉴를 검색합니다. \n 1. 카테고리별 검색 \t2. 이름 검색");
                    selectNum = Integer.parseInt(System.console().readLine());
                    if(selectNum == 1){
                        System.out.println("카테고리:\tICE\t\tDRINK\t\tCHICKEN\t\tDESSERT\t\tBUGER");
                        System.out.println("카테고리를 적어주세요");
                        user = System.console().readLine();
                        user = user.toUpperCase();
                        foodtList= foodDao.searchMenu_category(user);}
                    else if(selectNum == 2 ){
                        System.out.println("제품의 이름을 적어주세요");
                        user = System.console().readLine();
                        foodtList = foodDao.searchMenu_name(user);}
                    else{System.out.println("잘못된 선택입니다.");
                        continue;}
                    for(TBL_FoodVo vo : foodtList) System.out.println(vo);
                    break;    
                case "6":
                    foodtList = foodDao.viewMenu(); // 전체메뉴조회
                    for(TBL_FoodVo vo : foodtList) 
                    System.out.println(vo);
                    break;
                case "7": // 종료
                    run=false;
                    break;                
                default:
                    break;
            }
        }

    }
    public static void main(String[] args) {
        KioskMain main = new KioskMain();
        main.start();
    }
}
