package basic.day3;

// if ~ else if ~ else if ~ ....
public class A18IfElseIfTest {

	public static void main(String[] args) {
		
		int menu;

		System.out.println(":::: 쇼핑몰 사용자 마이페이지 ::::");
		System.out.println("1:장바구니   2:찜 상품   3.배송 조회   4.구매 목록  5.종료");
		System.out.print("선택 하세요. >>>> ");
		
		menu=3;
		
		//동일한 값인지 비교 : 관계연산자 == 또는 != 
		if(menu==1) {
			System.out.println("장바구니 🎁🎁🎁🎁 .많이 담아 주세요.");
		}else if(menu ==2) {
			System.out.println("찜 상품 입니다.❤❤");
		}else if(menu ==3) {
			System.out.println("배송 조회 🚚🚛🚚🚛 ");
		}else if(menu ==4) {
			System.out.println("구매 목록 입니다.");
		}else if(menu ==5) {
			System.out.println("종료 입니다.");
		}else { //메뉴 값이 1,2,3,4,5가 아닐때
			System.out.println("잘못된 선택 입니다.");
		}
		
		System.out.println("메뉴 선택 종료합니다.");
		
		int jumsu = 108;
		String grade;
		
		//유효한 점수 데이터인지 검사
		if(jumsu>100 ||jumsu<0){
			System.out.println("점수는 0~100 사이의 정수값입니다.");
			return;
		}
		
		//점수가 100~90이면 A, 80~89 B, 70~79 C, 60~69 D, 60미만 F
		if(jumsu>=90){
			grade = "A";	
		} else if(jumsu>=80){
			grade = "B";
		} else if(jumsu>=70){
			grade = "C";
		} else if(jumsu>=60){
			grade = "D";
		}  else {
			grade = "F";
		}	
		System.out.println("점수는 "+jumsu+"이고, 학점은 "+grade+"입니다.");




	}
	
}

