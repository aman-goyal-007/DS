package sortingAndsearching;

/*
Merge two sorted arrays while first array has extra and enough space.
e.g.
A= [1,4,7,,,,]
B=[2,3,5]
 */
public class MergeSortedArrayWithoutAnotherArray {
    public static void main(String[] args) {
        int[] a = {1,4,7,0,0,0};
        int[] b = {2,3,5};
        sort(a,b,2,2);
    }
    private static void sort(int[] a, int[] b, int aIndex, int bIndex){
        int lastIndex = aIndex+bIndex+1;

        while(bIndex>=0){
            if(a[aIndex]>=b[bIndex]){
                a[lastIndex--] = a[aIndex--];
            }else{
                a[lastIndex--] = b[bIndex--];
            }
        }
        for(int elem : a){
            System.out.println(elem);
        }
    }
}
