package jdbc.Project2.VO;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode

public class TBL_FoodVo {
    private String fcode;
    private String fname;
    private String category;
    private int price;
    private int gram;
    private int kal;
    
    public TBL_FoodVo(String fcode, String fname, String category, int price, int gram, int kal) {
        this.fcode = fcode;
        this.fname = fname;
        this.category = category;
        this.price = price;
        this.gram = gram;
        this.kal = kal;
    }

    @Override
    public String toString() {
        return "[" + fname + ", 가격: " + price + ", category:  "+ category+
                 ", gram: " + gram + ", kal: " + kal + ", 제품 코드: " + fcode +"]";
    }

    

}
