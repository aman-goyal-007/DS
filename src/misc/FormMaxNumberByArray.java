package misc;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
public class FormMaxNumberByArray {
    public static void main(String[] args) {
        Integer[] arr = {54,546,548,60,600};
        Comparator<Integer> comp  =new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a1 = o1.toString()+o2.toString();
                String a2 = o2.toString()+o1.toString();
                return Integer.compare(Integer.valueOf(a2),Integer.valueOf(a1));
            }
        };

        Arrays.sort(arr,comp);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
