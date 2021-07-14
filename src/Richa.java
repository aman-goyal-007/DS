
public class Richa {
	public static void main(String...args) {
	}
}
class AAA{
	public Number test() {
		System.out.println("a");
		return new Integer(2);
	}
}
class B extends AAA{
	@Override
	public Integer test() {
		System.out.println("b");
		return new Integer(4);
	}
}
