package day6.mvc;

import java.util.Objects;

import lombok.EqualsAndHashCode;

//@EqualsAndHashCode
public class EqualHashCodeTest {

	public static void main(String[] args) {
		RequestMap2 req1 = new RequestMap2("save", "GET");
		RequestMap2 req2 = new RequestMap2("save", "GET");
		
		//req1과 req2에 저장된 값은 객체의 참조값
		System.out.println("req1==req2: "+(req1==req2));
		System.out.println("req1.equals(req2): "+(req1.equals(req2)));
		
	}

}

class RequestMap2{
	private String url;
	private String method;
	public String getUrl() {
		return url;
	}
	
	//비교되는 2개의 객체가 각각 new 연산으로 만들어지면 해시코드가 다름
	//override로 값이 같다면 hashcode가 같도록 만듬
	@Override
	public int hashCode() {	//해시코드값 재정의: url과 method 참조값으로 계산한 것 리턴
		return Objects.hash(method, url);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestMap2 other = (RequestMap2) obj;
		//다른 객체 other와 url과 method 문자열이 같으면 '참'리턴
		return Objects.equals(method, other.method) && Objects.equals(url, other.url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public RequestMap2(String url, String method) {
		this.url = url;
		this.method = method;
	}
	
}