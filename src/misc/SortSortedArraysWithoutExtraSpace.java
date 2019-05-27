package misc;

import java.util.Arrays;

/*
Sort 2 sorted arrays without extra space
 */
public class SortSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] a = {2,5,6,0,0,0};
        int[] b = {1,2,3};
        int m=3;
        int n=3;
        int length = a.length-1;
        m--;
        n--;
        while(n>=0){
            if(m>=0 && a[m]>b[n]){
                a[length] = a[m];
                m--;
            }else{
                a[length] = b[n];
                n--;
            }
            length--;
        }
        Arrays.stream(a).forEach(System.out::println);
    }
}
