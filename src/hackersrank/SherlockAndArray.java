package hackersrank;

import java.util.Arrays;
import java.util.List;


public class SherlockAndArray {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3);
        int rightSum = arr.stream().mapToInt(a->a).sum();
        int leftSum = 0;
        boolean found= false;
        int element = arr.get(0);
        int total = (int)arr.stream().filter(a->a.equals(element)).count();
        if(total==arr.size()) found=true;
        if(!found) {
            for (int i = 0; i < arr.size() - 1; i++) {
                if (i != 0)
                    leftSum += arr.get(i - 1);
                int rSum = rightSum;
                rSum = rSum - leftSum - arr.get(i);
                if (leftSum == rSum) {
                    found = true;
                    break;
                }
            }
        }
        if(found) System.out.println("YES");
        else System.out.println("NO");
    }
}




