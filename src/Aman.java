import java.time.LocalDate;

public class Aman {

	public static void main(String...args) {
		LocalDate date = LocalDate.ofEpochDay(365);
		System.out.println(date);

	}
}

class A implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Close....");
		throw new Exception("Aman Exception");
	}
}
