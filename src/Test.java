import java.util.Arrays;


public class Test {
    public static void main(String[] args) {
        String a = new String("abc").intern();
        String b = new String("abc").intern();
        System.out.println(a==b);
    }
}