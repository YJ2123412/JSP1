package jdbc.Project2_SS;

import java.util.ArrayList;
import java.util.List;

import jdbc.Project2_SS.DAO.Tbl_BuyListDao;
import jdbc.Project2_SS.DAO.Tbl_CustomerDao;
import jdbc.Project2_SS.DAO.Tbl_FoodDao;
import jdbc.Project2_SS.VO.TBL_BuyListVo;
import jdbc.Project2_SS.VO.TBL_FoodVo;

public class KioskMain {
 
    Tbl_CustomerDao cusdao = new Tbl_CustomerDao();
    Tbl_BuyListDao buydao = new Tbl_BuyListDao();
    Tbl_FoodDao foodDao = new Tbl_FoodDao();
    List<TBL_FoodVo> foodtList = new ArrayList<TBL_FoodVo>();
    List<TBL_BuyListVo> buylist = new ArrayList<TBL_BuyListVo>();
    List<TBL_BuyListVo> buylist2 = new ArrayList<TBL_BuyListVo>();

    private void setMenu(String id) {
        boolean run=false;
        String category = null;
        while(run != true){
            category = "BUGER";
            foodtList=foodDao.searchMenu_category(category);
            foodDao.print2();
            for(TBL_FoodVo vo : foodtList) System.out.println(vo);
            System.out.println("햄버거 상품코드를 입력하세요");
            String pcode = System.console().readLine();
            pcode = pcode.toUpperCase();
            System.out.println("수량을 입력하세요");
            int quantity1 = Integer.parseInt(System.console().readLine());
            
        if(buydao.buyHistory2(pcode)==1)
            {buylist2.add(new TBL_BuyListVo(0, id, pcode, quantity1, null));
            System.out.println("상품을 담았습니다.");
            run = true;}
        else
            {System.out.println("상품코드 또는 고객 아이디 오류입니다.");
            continue;}}
        
        boolean run2=false;
        while(run2 != true){    
            category = "DESSERT";
            foodtList=foodDao.searchMenu_category(category);
            foodDao.print2();
            for(TBL_FoodVo vo : foodtList) System.out.println(vo);
            System.out.println("디저트 상품코드를 입력하세요");
            String pcode2 = System.console().readLine();
            pcode2 = pcode2.toUpperCase();
            System.out.println("수량을 입력하세요");
            int quantity2 = Integer.parseInt(System.console().readLine());
            if(buydao.buyHistory2(pcode2)==1)
                {buylist2.add(new TBL_BuyListVo(0, id, pcode2, quantity2, null));
                System.out.println("상품을 담았습니다.");
                run2 = true;}
            else {System.out.println("상품코드 또는 고객 아이디 오류입니다.");
                continue;}
            }
        boolean run3=false;
        while(run3 != true){ 
            category = "DRINK";
            foodtList=foodDao.searchMenu_category(category);
            foodDao.print2();
            for(TBL_FoodVo vo : foodtList) System.out.println(vo);
            System.out.println("음료수 상품코드를 입력하세요");
            
            String pcode3= System.console().readLine();
            pcode3 = pcode3.toUpperCase();
            System.out.println("수량을 입력하세요");
            int quantity3 = Integer.parseInt(System.console().readLine());
        
            if(buydao.buyHistory2(pcode3)==1)
                {buylist2.add(new TBL_BuyListVo(0, id, pcode3, quantity3, null));
                System.out.println("상품을 담았습니다.");
                run3 = true;}
            else
                {System.out.println("상품코드 또는 고객 아이디 오류입니다."); 
                continue;}} 
            System.out.println("\n"+buylist2.get(1).getId()+"님의 현재 장바구니 목록");
            System.out.println();
            for (int i = 0; i < buylist2.size(); i++) {
                System.out.println("상품코드: "+buylist2.get(i).getPcode()+"\t 구매수량: "+buylist2.get(i).getQuantity());
            }
            System.out.println("\n구매하시겠습니까? Y/N");
            String buyselect = System.console().readLine();
            buyselect=buyselect.toUpperCase();
            if(buyselect.equals("Y")){
                System.out.println("결제가 완료 되었습니다. 초기메뉴로 돌아갑니다.");
                buydao.insertMany(buylist2);
                start();}
            else {System.out.println("주문이 취소되었습니다. 초기 메뉴로 돌아갑니다.\n");
                buylist2.removeAll(buylist2);
                start();}
    }

    private void showMenu() {
        System.out.println("-".repeat(70));
        System.out.println("1. 주문 하기\t 2. 주문 수정\t\t3. 주문 취소  \t4. 구매내역");
        System.out.println("5. 메뉴검색\t 6. 전체 메뉴 조회\t7. 메뉴추천\t 8. 세트 담기\t 9. 구매 종료");
        System.out.println("-".repeat(70));
    }


    public void start() {
        String id=null;
        boolean run=false;
        while(run != true){
            System.out.println("로그인이 필요한 서비스입니다.");
            System.out.print("아이디 입력: ");
            id = System.console().readLine();
            int num = cusdao.login2(id);
            if(num ==1) {
                System.out.println(id+"님 환영합니다.");
                run = true;
            } else {
                System.out.println("부적합한 아이디입니다. 아이디를 확인해주세요");
                continue;
            }
        } 
        
        int selectNum;
        String user; 
        while (run) {     
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
                    System.out.println("구매 내역을 조회합니다.");
                    buylist =buydao.buyHistory(id);
                    System.out.println
                    (buylist);

                    break;
                case "5":
                    System.out.println("메뉴를 검색합니다. \n 1. 카테고리별 검색 \t2. 이름 검색");
                    selectNum = Integer.parseInt(System.console().readLine());
                    if(selectNum == 1){
                        System.out.println("카테고리:\tICE\t\tDRINK\t\tCHICKEN\t\tDESSERT\t\tBUGER");
                        System.out.println("         \tTOPPING\t\tSAUCE");
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
                        foodDao.print2();
                    for(TBL_FoodVo vo : foodtList) System.out.println(vo);

                    break;    

                case "6":// 전체메뉴조회
                    foodtList = foodDao.viewMenu(); 
                    foodDao.print2();
                    for(TBL_FoodVo vo : foodtList)
                    System.out.println(vo);
                    break;

                case "7"://추천
                        System.out.println("메뉴를 추천해드립니다.");
                        System.out.println("1. 저칼로리\t2. 5천원 이하 버거\t3. 랜덤 햄버거 메뉴");
                        System.out.print("원하는 추천 목록을 선택해주세요: ");
                        int selectNum2 = Integer.parseInt(System.console().readLine());
                        foodtList = foodDao.recommend(selectNum2);
                        System.out.println(foodtList);
                        break;

                case "8": 
                    setMenu(id);            
                case "9": // 종료
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
