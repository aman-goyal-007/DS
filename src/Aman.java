import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Aman {

	public static void main(String...args) throws InterruptedException {
		LongestIncreasingSubsequenceLength(new int[] {2,1,3,1,6,2});
		
		 
		}
	static int LongestIncreasingSubsequenceLength(int A[])
    {
		int size = A.length;
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable,-1, len-1, A[i])] = A[i];
        }
        System.out.println(len);
        return len;
    }	
	 static int CeilIndex(int A[], int l, int r, int key)
	    {
	        while (r - l > 1)
	        {
	            int m = l + (r - l)/2;
	            if (A[m]>=key)
	                r = m;
	            else
	                l = m;
	        }
	 
	        return r;
	    }
	
}

interface AA{
	void callA();
}
class A implements AA{
	A(){
		//callA();
	}

	@Override
	public void callA() {
		System.out.println("callA A");
		callB();
		
	}
	
	void callB(){
		System.out.println("callB A");
	}
	
}
class BB extends A{
	BB(){
		super();
	}
	public void callA() {
		System.out.println("callA B");
		callB();
		
	}
	
	void callB() {
		System.out.println("callB B");
	}
}
