import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution{
	public static void main(String...args) {
		String s1="hi";
		String s2="world";
		boolean[] firstArr= new boolean[65535];
		Arrays.stream(s1.split("")).forEach( c -> firstArr[c.hashCode()]=true);
		boolean isMatch = false;
		for(String s : s2.split("")){
			if(firstArr[s.hashCode()]){
				isMatch = true;
				break;
			}
		}

		if(isMatch){
			System.out.println("TRUE");
		}else{
			System.out.println("FALSE");
		}

	}

}