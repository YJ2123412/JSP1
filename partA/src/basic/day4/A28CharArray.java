package basic.day4;
//문자열은 문자의 집합. 따라서 문자열을 구성하는 문자 하나씩 가져와 배열에 저장해봅시다.
public class A28CharArray {
    public static void main(String[] args) {
        String msg = "Hello~ World~ 자바는 맛있다.";
        
        //문자열의 길이만큼 배열의 크기를 정함
        char[] msgArray = new char[msg.length()];

        for(int i = 0; i<msg.length(); i++){
            char temp = msg.charAt(i);
            System.out.println(temp);
            msgArray[i]=temp;
        }
        //char 배열의 특징. 배열이름으로 println하면?
        System.out.println();
        System.out.print("msgArray: "+msgArray+"\n");

        System.out.print("메세지 원문: ");
        System.out.println(msgArray);
        
        //고대 암호: '모모'가 '나연'이 한테 비밀 메시지를 보냅니다. 암호문을 만듭니다.
        //          두사람이 알고있는 비밀키 값 key=7을 정했습니다. 암호문은?
        int key = 7;
        for(int i =0; i<msg.length();i++){
            msgArray[i]+=key;
        }
        System.out.println("~~~~~~~~~~모모가 나연이에게 보낸 비밀 메세지는: ");
        System.out.println(msgArray);

        System.out.println("나연이는 받은 메시지를 읽으려면 암호를 풀어야한다. 풀어보자");
         for(int i =0; i<msg.length();i++){
            msgArray[i]-=key;
        }
        System.out.println(msgArray);
    }


}
