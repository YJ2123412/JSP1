package basic.day2;

public class A10StringVariable {
    public static void main(String[] args) {
        //String은 문자열: 문자("")의 집합
        String message = "HEllo~ Bye!";
        //char은 2byte, 이모지 윈도우+; .. 이모지는 4byte ->문자열로 저장해야함
        //String 으로 선언된 변수는 '객체'입니다. 그래서 여러가지 메소드를 갖고 필요한 기능들을 제공해 줍니다. (length..)

        System.out.println(message);
        System.out.println("'메세지'"+message+"'의 길이: "+message.length());
        //char emo = 😊;
        //System.out.println(emo);
        String message2 = "welcome~ java world!!!!";
        System.out.println("'메세지'"+message2+"'의 길이: "+message2.length());

        //자바 String의 중요한 메소드 7가지씩 조사해서 테스트 해보기
        message.charAt(0);
        message.equals(message2);
        message.toLowerCase();
        message.indexOf('H');
        message.concat(message2);
        message.contains("Hello");
        message.startsWith("Hello");

        System.out.println("첫번째 글자: "+message.charAt(0));
        System.out.println("비교 결과: "+message.equals(message2));
        System.out.println("모두 소문자로 바꾼 결과: "+ message.toLowerCase());
        System.out.println("H의 인덱스 번호 : "+ message.indexOf('H'));
        System.out.println("합해진 문장: "+message.concat(message2));
        System.out.println("대소문자 구분없이 비교결과: "+message.equalsIgnoreCase("hello~ bye!"));
        System.out.println("대소문자 구분하여 비교결과: "+message.contains("hello~ bye!"));
        System.out.println("해당 문자로 시작하는 지 : "+ message.startsWith("HEllo"));



        //1. 메소드 괄호 안에 아무것도 없는 것
        System.out.println("괄호 안에 아무것도 없는 것 "+message.isEmpty());
        //2. 메소드 괄호 안에 정수 1개를 쓰는 것
        System.out.println("4번째 글자: "+message.charAt(3));

        //3. 메소드 괄호 안에 문자열 1개를 쓰는 것
        System.out.println(message.concat("ImFine"));

        //4. 메소드 괄호 안에 정수 2개를 쓰는 것
        


        //5. 메소드 괄호 안에 문자열 2개를 쓰는 것
        


    }



}
