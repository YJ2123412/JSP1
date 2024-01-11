package object.self;

import java.util.Scanner;

public class Cart {
    Scanner sc = new Scanner(System.in);


    private String userId;
    private String[] productNames;
    private int[] prices;
    private int total_Money;
    private String[] selectProduct;

    public String getUserId() {
        return userId;
    }
    public String[] getProductNames() {
        return productNames;
    }
    public int[] getPrice() {
        return prices;
    }
    public int getTotal_Money() {
        return total_Money;
    }
    public String[] getSelectProduct() {
        return selectProduct;
    }

    public void total_Money(int[] select){ //setter의 역할
        int sum =0;
        for(int i = 0; i<select.length; i++){
            int temp = select[i];
            if(temp == -1) {
                //sum-=prices[temp];
                break;}
                sum+=prices[temp];
        }  this. total_Money = sum;
    }
    
    public void selectProduct(int[] select){
        StringBuilder sb = new StringBuilder();
        //String[] name = new String [prices.length];
        for(int i = 0; i<select.length; i++){
            sb.append(productNames[i]);
        }   System.out.println(sb);
        }
       
    

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setProductNames(String[] productNames) {
        this.productNames = productNames;
    }
    public void setPrice(int[] prices) {
        this.prices = prices;
    }

    //추가적인 인스턴스 메소드 : 해결방법 ??


    public static void main(String[] args) {



    //총가격의 합.. -> 가격은 마음대로.  프라이스 배열에서 값을 가져와서 합계를 만들기
    //가격은 메인에서 주기
    //get, set
        //select 배열은 price배열에서 가져와 더할 인덱스들
    }

}
