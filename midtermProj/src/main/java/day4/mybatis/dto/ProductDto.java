package day4.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class ProductDto {
	    private String pcode;
		private String category;
		private String pname;
		private int price;
		
		
		public ProductDto(String pname, int price) {
			super();
			this.pname = pname;
			this.price = price;
		}

	
		@Override
	    public String toString() {
	        return String.format("\n %6s %15s %40s\t %,8d ", 
	                            category,pcode,pname,price);
	    }
		

		
}
