public class Aman {

	public static void main(String...args) {

      String a = "aman goyal";
        System.out.println(a.replace(" ",""));
        double d = 2.1;
        System.out.println(Math.floor(d));


    }
}

class A implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Close....");
		throw new Exception("Aman Exception");
	}
}
