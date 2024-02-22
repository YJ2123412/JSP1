package project.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ProductVo {
    private String pcode;
	private String category;
	private String pname;
	private int price;
    
    @Override
    public String toString() {
        return String.format("%6s %15s %40s\t %,8d", 
                            category,pcode,pname,price);
    }

	public ProductVo(String pcode, String category, String pname, int price) {
		super();
		this.pcode = pcode;
		this.category = category;
		this.pname = pname;
		this.price = price;
	}

}
