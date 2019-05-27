package hackersrank;

public class ChiefHopper {
    public static void main(String[] args) {
        int[] arr = {3,4,3,2,4};
        int length = arr.length;
        int initialEnergy = 0;
        for(int i=length-1;i>=0;i--){
            int sum = initialEnergy+arr[i];
            sum = sum%2;
            if(sum==0){
                initialEnergy = (initialEnergy+arr[i])/2;
            }else{
                initialEnergy = (initialEnergy+arr[i])/2+1;
            }
        }
        System.out.println(initialEnergy);
    }
}



