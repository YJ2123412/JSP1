package jdbc.Project2.VO;

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
    
    public TBL_BuyListVo(int idx, String id, String pcode, int quantity, Date buy_date) {
        this.idx = idx;
        this.id = id;
        this.pcode = pcode;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }

    @Override
    public String toString() {
        System.out.println( );
        return "[" + idx + ", 회원 아이디: " + id + ", 상품 코드: " + pcode + ", 구매 수량: " + quantity + ", 구매 일자: "
                + buy_date + "]";
    }

    
}
