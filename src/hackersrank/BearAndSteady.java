package hackersrank;

public class BearAndSteady {
    public static void main(String[] args) {
        String gene = "GAAATAAA";
        int length = gene.length();
        int max = length/4;
        int[] countArr = new int[128];
        int sol=Integer.MAX_VALUE;
        int left=0,right=0;
        for(right=0;right<length;right++){
            while(countArr['A']>max || countArr['C']>max || countArr['G']>max || countArr['T']>max  ){
                if(left == length)break;
                countArr[gene.charAt(left)]--;
                left++;
            }
            sol = Math.min(sol,right-left);
            System.out.println(sol);
            countArr[gene.charAt(right)]++;
        }


        System.out.println(sol);

    }

}
