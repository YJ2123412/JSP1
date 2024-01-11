package object.day8;

public class Rabbit extends Animal {
	public static final String TYPE ="토끼";
	
	public Rabbit() {
	}
	
	public Rabbit(String name, String color) {
		super(name, color);
	}
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 토끼는 조용합니다.");

	}
    @Override
	public String toString() {
		return TYPE+" [color=" + color + ", name=" + name + "]";
	}
    
}
