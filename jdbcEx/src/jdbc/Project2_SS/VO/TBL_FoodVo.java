package jdbc.Project2_SS.VO;

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

    // @Override
    // public String toString() {
    //     return  "\t" + fname +"\t" + price + "\t   "+ category+
    //              "  \t " + gram + "\t" + kal + "\t" + fcode+"\n";

 

    @Override
    public String toString() {
	return String.format("||%4s%-20s %-35s\t %s %9d%1s %8d%1s %8d%-8s||	\n","",fcode,fname,category,price,"원",gram,"g",kal,"kcal");}



}