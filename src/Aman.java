import java.util.HashMap;
import java.util.Iterator;

public class Aman {

	public static void main(String...args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            map.put("c", "m");
        }


	}
}

class A implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Close....");
		throw new Exception("Aman Exception");
	}
}
