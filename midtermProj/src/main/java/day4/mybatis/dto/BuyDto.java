package day4.mybatis.dto;

//웹에서는 Vo단어 대신 dto 많이 사용.. 
//data transfer object.. db, 서블릿(컨트롤러), jsp(뷰)를 오고가며 데이터를 전달하는 역할
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
@ToString
@EqualsAndHashCode
@Getter
//마이바티스에서 매핑할때 객체는 기본생성자가 있으면 커스텀보다 기본 우선함,없으면 커스텀 생성자
@AllArgsConstructor		//커스텀 생성자: 컬럼명과 변수명 일치 안해도 O
@NoArgsConstructor			//기본 생성자: 객체 생성 후 setter로 동작하기에 걸럼명=변수명
//변수 선언 순서와 컬럼순서는 일치해야함 (생성자 형식 맞추기)
public class BuyDto {
	private int buy_Idx;
	private String customid;
	private String pcode;
	private int quantity;
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	private Date buy_Date;
	
	
	
	
}
