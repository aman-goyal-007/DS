package misc;

// https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
public class FlipToMakeAlternatives {
    public static void main(String[] args) {
        String str = "0001010111";
        //String str = "001";
        System.out.println(Math.min(counts(str,'1'),counts(str,'0')));
    }

    private static int counts(String str, char expected){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != expected)
                count++;
            expected = flip(expected);
        }
        return count;
    }

    private static char flip(char character){
        return character == '0'?'1':'0';
    }
}
