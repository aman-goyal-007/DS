package hackersrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

public class SpecialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long sol = 0;
        char first = '0';
        char[] arr = s.toCharArray();

        // case 1
        char prevChar = arr[0];
        int length = 1;
        for(int i=1;i<arr.length;i++){
            if(prevChar == arr[i]){
                length++;
                continue;
            }else{
                sol += (length*(length+1))/2;
                length = 1;
                prevChar = arr[i];
            }
        }
        sol += (length*(length+1))/2;

        //case 2
        for(int i=1;i<arr.length-1;i++){
            int m = 1;
            char prev = arr[i-m];
            while(true) {
                if (i>=m && (m+i <arr.length) && (arr[i - m] == prev) && (arr[i] != prev) && (arr[i + m] == prev)) {
                    sol++;
                    m++;
                }else{
                    break;
                }
            }
        }

        return sol;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       File file=new File("C:\\Users\\amang\\Desktop\\Temp\\a.txt");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        StringBuffer sb=new StringBuffer();
        String line = br.readLine();
/*
        while((line=br.readLine())!=null)
        {
            System.out.println(line);
            sb.append(line);
        }
*/
        System.out.println(substrCount(1,line));
        fr.close();
    }
}
