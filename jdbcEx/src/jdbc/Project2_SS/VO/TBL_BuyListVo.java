package jdbc.Project2_SS.VO;

import java.sql.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode

public class TBL_BuyListVo {
    private int idx;
    private String id;
    private String pcode;
    private int quantity;
    private Date buy_date;
    private String fname;
    
    public TBL_BuyListVo(int idx, String id, String pcode, int quantity, Date buy_date) {
        this.idx = idx;
        this.id = id;
        this.pcode = pcode;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }



    public TBL_BuyListVo(int idx, String id, String fname, String pcode, int quantity, Date buy_date) {
        this.idx = idx;
        this.id = id;
        this.pcode = pcode;
        this.quantity = quantity;
        this.buy_date = buy_date;
        this.fname= fname;
    }



    @Override
    public String toString() {
        return "\t아이디: " + id+ ", 주문번호: "+idx + ", 상품이름: "+fname+", 상품코드: " + pcode + ", 구매수량: " + quantity
                + ", 구매일자: " + buy_date + "\n";
    }



    public static void main(String[] args) {
        System.out.println("  아이디\t"+"주문번호\t"+"상품코드\t"+ "구매수량\t"+"구매일자");
}
    }
    

