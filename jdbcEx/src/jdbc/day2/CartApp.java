package jdbc.day2;

import java.util.List;

import project.dao.TblProductDao;
import project.dao.TblBuyDao;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class CartApp {
    
    public static void main(String[] args) {
        TblBuyDao buyDao = new TblBuyDao();
        System.out.println("구매할 사용자 간편로그인이 필요합니다.");
        System.out.print("아이디 입력 ___");
        String userId = System.console().readLine();
        TblProductDao po = new TblProductDao();


        //상품 목록을 선택한 카테고리에 대해 보여주기 (구매할 상품 조회)
        //또는 상품명으로 검색 (구매할 상품 조회)
        //또는 입력한 아이디로 구매한 구매 내역 보여주기(구매 수량 변경 또는 구매 취소 buy_idx 조회)


        boolean run = true;
        while (run) {//메뉴 선택 반복
            System.out.println("[1] 장바구니 담기\t[2] 구매 취소\t[3] 구매 수량 변경\t[4] 상품목록 조회\t[5] 검색\t[6]내 장바구니\t*종료는 아무 숫자나 눌러주세요");
            int select = Integer.parseInt(System.console().readLine());
            switch (select) {
                case 1: //[1] 장바구니 담기 - buy 테이블에 insert(1행)
                System.out.print("구입할 품목의 코드를 입력하세요__");
                String pcode = System.console().readLine();
                System.out.print("구매할 갯수를 입력하세요__");
                int buyquantuty = Integer.parseInt(System.console().readLine());

                BuyVo bv = new BuyVo(0, userId, pcode, buyquantuty, null);
                buyDao.buy1(bv);
                    break;

                case 2: //[2] 구매 취소 - delete 
                System.out.print("취소할 품목의 인덱스를 입력하세요__(되돌아가기는 0번)");
                int deleteidx = Integer.parseInt(System.console().readLine());
                if(deleteidx == 0)break;
                bv = new BuyVo(deleteidx ,userId,null,0,null);
                buyDao.delete(bv);
                    break;

                case 3: // [3] 구매 수량 변경 -update
                System.out.print("변경할 상품의 인덱스를 입력하세요__");
                int changeidx =  Integer.parseInt(System.console().readLine());
                System.out.print("변경할 수량을 입력하세요__");
                int changNumber = Integer.parseInt(System.console().readLine());

                bv = new BuyVo(changeidx, userId, null, changNumber, null);
                //bd.changNumber(bv, userId, changeidx, changNumber);
                    break;    
            
                case 4:System.out.println("모든 상품 조회");
                po.selectAll();
                break;

                case 5: System.out.println("[1] 카테고리 검색\t[2] 상품명 검색");
                select = Integer.parseInt(System.console().readLine());
                if(select ==1){
                    System.out.println("카테고리를 입력하세요");
                    String category = System.console().readLine();
                    po.selectByCategeory(category);}
                else if(select ==2){
                    System.out.println("상품명을 입력하세요");
                    pcode = System.console().readLine();
                    po.selectByPname(pcode);
                }else System.out.println("잘못된 선택입니다.");
                break;

                case 6: System.out.println("나의 장바구니 조회");
                    List<CustomerBuyVo> result = buyDao.selectCustomerBuyList(userId);
                    for(CustomerBuyVo vo : result) System.out.println(vo);
                break;

                default:
                    System.out.println("쇼핑을 종료합니다.");
                    run = false;
                    break;
            }
        }
    }
} 
