package day4.mybatis.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CustomerDto {
	private String CUSTOM_ID;
    private String NAME;
    private String EMAIL;
    private int AGE;
    private Date REG_DATE;
}


