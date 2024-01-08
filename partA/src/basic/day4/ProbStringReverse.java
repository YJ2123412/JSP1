package basic.day4;
public class ProbStringReverse {
    public static void main(String[] args) {
        
    
    String msg = "Hello world";
    char[] Charmsg = new char[msg.length()];
    int idx = Charmsg.length-1;
    for (int i = 0; i <msg.length(); i++){
        Charmsg[idx--] = msg.charAt(i);
        }

    System.out.println(Charmsg);
    System.out.println("----반대로----");

    char[] Charmsg2 = new char[msg.length()];
    for (int i = 0; i <msg.length(); i++){
        Charmsg2[(Charmsg.length-1-i)] = msg.charAt(i);
        }
    System.out.println("idx 없이");
    System.out.println(Charmsg2);



    StringBuilder sb = new StringBuilder("Hello world");
    System.out.println(sb.reverse());

    StringBuilder sb2 = new StringBuilder();   
		sb2.append("안녕하세요 "); //append 이전 문장 뒤에 붙는다. 
        System.out.println(sb2);
		sb2.append("만나서 반갑습니다");
        System.out.println(sb2);
    }   
}


