package jdbc.day2;

import java.util.List;

import project.dao.ProductDao;
import project.dao.TblBuyDao;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;

public class CartApp_2 {
//static이 많아지면 상속의 특징을 사용할 수 없음, 멀티 스레드 환경에서도 부적합 -->지금은 테스트를 위해 사용
    public static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회     [P] 상품명 검색      [M]나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소   [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println(".".repeat(50));
    }
        //상품 목록을 선택한 카테고리에 대해 보여주기  (구매할 상품 조회)
        //또는 상품명으로 검색 (구매할 상품 조회)
        //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)


    public static void main(String[] args) {
        TblBuyDao buyDao = new TblBuyDao();
        ProductDao productDao = new ProductDao();
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String userId = System.console().readLine();
        System.out.println(userId+"님 환영합니다 ♥");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>");
            String select = System.console().readLine();
            switch (select) {
                case "M","m":   //나의 구매내역
                    List<CustomerBuyVo> result = buyDao.selectCustomerBuyList(userId);
                    for(CustomerBuyVo vo : result) System.out.println(vo);
                    break;
                    
                case "C","c": //카테고리 선택
                    System.out.println("카테고리: A1-과일  A2-수입과일  B1-인스턴트  B2-선물세트  C1-과자류");
                    System.out.print("카테고리 입력__");
                    String category = System.console().readLine();
                    List<ProductVo> productList = productDao.selectByCategeory(category);
                    for(ProductVo vo : productList) System.out.println(vo);
                    break;

                case "P","p": //상품명 검색
                    System.out.println("상품명 검색__");
                    String pname = System.console().readLine();
                    productList = productDao.selectByPname(pname);
                    for(ProductVo vo : productList) System.out.println(vo);
                    break;         

                case "B","b": //구매하기
                    System.out.print("구입할 품목의 코드를 입력하세요__");
                    String pcode = System.console().readLine();
                    System.out.print("구매할 갯수를 입력하세요__");
                    int buyquantuty = Integer.parseInt(System.console().readLine());

                    BuyVo bv = new BuyVo(0, userId, pcode, buyquantuty, null);
                    buyDao.buy(bv, userId);
                    break;

                case "D","d": //구매 취소
                    System.out.print("취소할 품목의 인덱스를 입력하세요__(되돌아가기는 0번)");
                    int deleteidx = Integer.parseInt(System.console().readLine());
                    if(deleteidx == 0)break;
                    bv = new BuyVo(deleteidx ,userId,null,0,null);
                    buyDao.delete(bv);
                    break;

                case "Q","q": //구매 수량 변경
                    System.out.print("변경할 상품의 인덱스를 입력하세요__");
                    int changeidx =  Integer.parseInt(System.console().readLine());
                    System.out.print("변경할 수량을 입력하세요__");
                    int changNumber = Integer.parseInt(System.console().readLine());
                    bv = new BuyVo(changeidx, userId, null, changNumber, null);
                    break;    

                case "X","x": 
                    run=false;   
                    break;
            }
        }
    }
}   // tbl_buy 테이블을 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java 
    //         테이블 컬럼과 1:1 대응되는 BuyVo.java  
    //         테이블 PK 컬럼은 buy_idx -> update,delete 의 조건 컬럼입니다.     
    //         insert 에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.       
