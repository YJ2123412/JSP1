package day4.mybatis.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class CustomerBuyDto {
    private int buy_Idx;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp buy_Date;
    
    
    
    
}
