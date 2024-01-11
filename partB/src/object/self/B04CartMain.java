package object.self;

import java.util.Arrays;
import java.util.Scanner;

public class B04CartMain {
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    Cart a = new Cart();

            
    String[] productNames = {"감자","버섯","가지","오이","사과","고구마"};
    int[] prices = {3000,4000,5000,1000,2000,4000};

    //장바구니 값 저장하기
    a.setUserId("momo");
    a.setProductNames(productNames);
    a.setPrice(prices);
    
    //int select = sc.nextInt();
    //int[] cart2 = {select};
    //System.out.println(Arrays.toString(cart2));
    //a.total_Money;
    //System.out.println(a.getUserId()+a.getPrice()+a.getProductNames());

    //--------------------------------------------------------------------------------
    System.out.println(a.getUserId()+"님의 장바구니입니다");
    System.out.println(String.format("%s\t %20s\t %s", "번호","상품명","가격"));

    for (int i = 0; i < a.getProductNames().length; i++) {
        System.out.println(String.format("%d\t %20s\t\t %d", i+1,productNames[i],prices[i]));
    }

    
    System.out.println("물품을 고르세요. 선택종료는 -1 입니다.");
    int sel = 0;
    int[] select = new int[5]; //상품 선택 개수는 최대 5개
    //String[] n = new String[select.length];
    int k =0; //select 배열 인덱스
    
    while(sel!=-1 && k<prices.length){
        System.out.println("상품번호입력: ");
        sel = sc.nextInt(); //sel의 선택범위는 productNames 범위 안에서 설정하는 것
        if(sel<-1 ||sel> prices.length){
            System.out.println("잘못된 입력입니다");
            continue;
        }
        select[k] = sel;
        //n[k] = productNames[k];
        k++;
        // count++;
    }

    a.selectProduct(select);
    if(k==select.length){
        System.out.println("장바구니 가득 채우셨네요~!");
    }

    System.out.println("선택하신 상품은 "+Arrays.toString(select));
   //수정전 System.out.println(a.getUserId()+"님이 선택하신 상품 합계: "+a.total_Money(select));
    a.total_Money(select);
    System.out.println(a.getUserId()+"님이 선택하신 상품은" + a.getSelectProduct()+"입니다. 합계: "+a.getTotal_Money());
  
    //a.setTotal_Money(200000);  set 메소드가 여기서는 필요 없음. 토탈머니 메소드가 대신할거임

    System.out.println(a.getProductNames());


    sc.close();


    }
    
}
