package jdbc.day3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdbc.day1.OracleConnectionUtil;
import project.dao.TblBuyDao;
import project.dao.TblProductDao;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;

// CartApp_4 는 다른 클래스의 상위 클래스로 상속 관계를 만들 수 있다.
//              ㄴ 단,  main 메소드도 제거하고 
//                      인스턴스 메소드는 pivate 이외 다른  접근 한정자로 해야합니다.     
public class CartApp_4 {
    //전역변수 선언 - 모든 메소드에서 사용 가능(인스턴스 필드와 같음)
    private TblBuyDao buyDao = new TblBuyDao();
    private TblProductDao productDao = new TblProductDao();
    private List<BuyVo> cart = new ArrayList<>();       //장바구니
    private Map<String, Integer> pricearr = new HashMap<>(); 

    

 

    private void showMenu() {
        System.out.println(".".repeat(70));
        System.out.println("[C] 카테고리별 상품 조회      [P] 상품명 검색");
        System.out.println("[M] 나의 구매내역             [T] 날짜별 결제 금액 조회");
        System.out.println("[B] 구매하기   [D] 구매 취소  [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println("::장바구니::[A] 담기  [L] 목록  [R] 삭제   [Y] 모두 구매 ");
        System.out.println(".".repeat(70));
    }

    private void showMyPage(String customerid) {
        List<CustomerBuyVo> result = buyDao.selectCustomerBuyList(customerid);
                    for(CustomerBuyVo vo : result)  
                            System.out.println(vo);
    }

    private void showProductListByCategory() {
        System.out.println("카테고리 : A1-과일 A2-수입과일  B1-인스턴스  B2-선물세트 C1-과자류");
        System.out.print("카테고리 입력__");
        String category = System.console().readLine();
        List<ProductVo> productList = productDao.selectByCategeory(category);
        for(ProductVo vo : productList) System.out.println(vo);
    }

    public void searchProductListByPname() {
        System.out.print("상품명 검색어 입력__");
        String pname = System.console().readLine();
        List<ProductVo> productList = productDao.selectByPname(pname);
        for(ProductVo vo : productList) System.out.println(vo);
    }                    

    private void addCartItem(String customerid) {
        System.out.println(".................. 장바구니 :: 물품 담기 ...................");
        System.out.print("구매할 상품코드 입력하세요.__");
        String pcode = System.console().readLine();
        System.out.print("구매할 수량 입력하세요.__");
        int buyquantuty = Integer.parseInt(System.console().readLine());
        cart.add(new BuyVo(0, customerid, pcode, buyquantuty, null));
     }

    private void showCartList() {
        System.out.println(".................. 장바구니 :: 목록 보기...................");
        String pcode= null;
        int totalmoney = 0;
        int price= 0;
        int quantity =0;
        for (int i = 0; i < cart.size(); i++) {
            //System.out.println("번호: "+i+" 물품"+cart.get(i));
            System.out.println("번호: ["+i+"] 물품코드: "+cart.get(i).getPCODE()+", 구매개수: "+cart.get(i).getQUANTITY()
            +"]" );

            pcode =cart.get(i).getPCODE();
            quantity= cart.get(i).getQUANTITY();
            price = buyDao.getPriceTable().get(pcode);
            totalmoney+=(price*quantity);
        } System.out.println(String.format("총 구매가격은 %,d입니다.", totalmoney));
    }

    private void removeCartItem() {
        System.out.println(".................. 장바구니 :: 물품 삭제 ...................");
        System.out.print( "삭제할 번호 입력__");
        int deleteidx = Integer.parseInt(System.console().readLine());
        if(deleteidx<0 || deleteidx>=cart.size()) {
            System.out.println("없는 구매 번호입니다.");
            return;
            }
        else {//참조 테이블에 없는 값 입력했을때
        System.out.println("물품을 장바구니에서 삭제했습니다.");
        cart.remove(deleteidx);
        }
    }
/////////////////////////////////////////////////////////////
    private void buyCartItems() {
        if(cart.size()==0){
            System.out.println("장바구니가 비었습니다. 물건을 담아주세요");
            return;
        }
        System.out.println(".................. 장바구니 :: 물품 모두 구매 ...................");
        int result = buyDao.insertMany(cart);
        if(result>0){
            System.out.println("물품 구매가 정상적으로 완료되었습니다.");
            cart.clear();
        }else{
            System.out.println("장바구니 물품 구매 실패했습니다.");
        }

    }

    public int money_of_dayByCustomer(String customid){
        String sql = "{ call money_of_day2(?,?,?) }";
        System.out.println("날짜 입력");
        String buydate = System.console().readLine(); //입력형식 yyyy-mm-dd
        int money=0;
        try (
            Connection connection = OracleConnectionUtil.getConnection();
            CallableStatement cstmt = connection.prepareCall(sql)
            ) {
            //프로시저의 IN 매개변수값 전달 : setXXX
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            //프로시저 OUT 매개변수 1) 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();      //프로시저 실행
            // OUT 매개변수 2) 결과값 가져오기 : getXXX
            money = cstmt.getInt(3);
            if(money == 0 ){System.out.println("해당 일의 구매 내역이 없습니다");}
            else System.out.println(buydate+"의 총 구매 금액은 "+money+"원 입니다.");
            
        } catch (SQLException e) {
            System.out.println("money_of_day 프로시저 실행 예외 : " + e.getMessage());
        }
        return money;
    }
    

       //상품 목록을 선택한 카테고리에 대해 보여주기  (구매할 상품 조회)
       //또는 상품명으로 검색 (구매할 상품 조회)
       //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
    public static void main(String[] args) {
        CartApp_4 app = new CartApp_4();
        TblBuyDao buyDao = new TblBuyDao();
        app.start();

    }
    
    public void start() {
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerid = System.console().readLine();
        System.out.println(customerid + " 님 환영합니다.♡");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>> ");    
           // int select = Integer.parseInt(System.console().readLine());
           String select = System.console().readLine();
            switch (select) {
                case "M","m":   // 나의 구매내역
                    showMyPage(customerid);
                    break;
                case "C","c":
                    showProductListByCategory();
                    break;  
                case "P","p":
                    searchProductListByPname();    
                    break;
                case "A","a":
                    addCartItem(customerid);
                    break;
                case "L","l":
                    showCartList();
                    break;
                case "R","r":
                    removeCartItem();
                    break;    
                case "Y","y":
                    buyCartItems();
                    break;
                case "X","x":
                    run=false;
                    break;                
                case "T","t":
                    money_of_dayByCustomer(customerid);
                default:
                    break;
            }
        }

    }






}   