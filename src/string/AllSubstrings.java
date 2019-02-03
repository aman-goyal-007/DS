package string;

public class AllSubstrings {
    public static void main(String[] args) {
        String str = "Ama";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = length; j >= i; j--) {
                System.out.println(str.substring(i, j));
            }
        }
    }
}
