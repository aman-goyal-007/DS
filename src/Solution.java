import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the encryption function below.
    static void encryption(String s) {
        s = s.replace(" ","");
        int length = s.length();
        double d = Math.sqrt(Double.valueOf(length));
        int row = new Double(Math.floor(d)).intValue();
        int col = new Double(Math.ceil(d)).intValue();
        while(row*col<length){
            row++;
        }
        int m = 0;
        String abc  = null;
        String solution= "";
        int k=0;
        for(int j=0;j<col;j++) {
            abc = "";
            m=k++;
            for(int i=0;i<row;i++) {
                if(m<length) {
                    abc += s.charAt(m);
                    m += col;
                }
            }
            solution+=abc+" ";
        }
        System.out.println(solution);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        encryption(s);


        scanner.close();
    }
}
