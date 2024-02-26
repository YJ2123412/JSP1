package project.vo;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
//@NoArgsConstructor
@AllArgsConstructor
public class BuyVo {
	private int buyIdx;
	private int buy_Idx;
	private String customid;
	private String pcode;
	private int quantity;
	private Date buyDate;
	private Date buy_Date;
	
	public void setBuyIdx(int buyIdx) {
		this.buyIdx = buyIdx;
	}
	public void setCustomid(String customid) {
		this.customid = customid;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public BuyVo(int buyIdx, String customid, String pcode, int quantity, Date buyDate) {
		this.buyIdx = buyIdx;
		this.customid = customid;
		this.pcode = pcode;
		this.quantity = quantity;
		this.buyDate = buyDate;
	}
	public int getBuyIdx() {
		return buyIdx;
	}
	public String getCustomid() {
		return customid;
	}
	public String getPcode() {
		return pcode;
	}
	public int getQuantity() {
		return quantity;
	}
	public Date getBuyDate() {
		return buyDate;
	}
}

//필드값이 모두 값으면 equals 로 true 가 되도록 하고싶다.
//-> equals 와 hashcode 를 재정의해야 합니다. (vo 객체)
//-> 이러한 객체는 테스트 과정에서 객체를 비교할 때 사용할 수 있습니다.